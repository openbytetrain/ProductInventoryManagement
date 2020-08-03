package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedPartyEntity
import com.bytetrain.prodinv.web.api.model.RelatedParty
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RelatedPartyMapperTest {

    @Autowired
    private lateinit var relatedPartyModelMapper: RelatedPartyModelMapper

    @Test
    fun `test RelatedParty toDto mapping with RelatedPartyModelMapper`() {
        val relatedPartyEntity = relatedPartyModelMapper.toDto(generateRelatedPartyEntity())
        Assertions.assertThat(relatedPartyEntity.id == "1")
        Assertions.assertThat(relatedPartyEntity.atReferredType == "String")
    }

    @Test
    fun `test RelatedParty toEntity mapping with RelatedPartyModelMapper`() {
        val relatedPartyDto = relatedPartyModelMapper.toEntity(generateRelatedPartyDto())
        Assertions.assertThat(relatedPartyDto.id == "1")
        Assertions.assertThat(relatedPartyDto.atReferredType == "String")
    }

    fun generateRelatedPartyEntity(): RelatedPartyEntity {
        return RelatedPartyEntity(id = "1", atReferredType = "String")
    }

    fun generateRelatedPartyDto(): RelatedParty {
        return RelatedParty(id = "1", atReferredType = "String")
    }
}
