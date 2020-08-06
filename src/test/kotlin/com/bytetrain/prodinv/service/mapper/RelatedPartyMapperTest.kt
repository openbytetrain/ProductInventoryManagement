package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedPartyEntity
import com.bytetrain.prodinv.web.api.model.RelatedParty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RelatedPartyMapperTest {

    @Autowired
    private lateinit var relatedPartyModelMapper: RelatedPartyModelMapper

    @Test
    fun `test RelatedParty toDto mapping with RelatedPartyModelMapper`() {
        val relatedParty = relatedPartyModelMapper.toDto(generateRelatedPartyEntity())
        assertThat(relatedParty.id).isEqualTo("1")
        assertThat(relatedParty.atReferredType).isEqualTo("String")
    }

    @Test
    fun `test RelatedParty toEntity mapping with RelatedPartyModelMapper`() {
        val relatedParty = relatedPartyModelMapper.toEntity(generateRelatedPartyDto())
        assertThat(relatedParty.id).isEqualTo(generateRelatedPartyDto().id)
        assertThat(relatedParty.atReferredType).isEqualTo("String")
    }

    fun generateRelatedPartyEntity(): RelatedPartyEntity {
        return RelatedPartyEntity(id = "1", atReferredType = "String")
    }

    fun generateRelatedPartyDto(): RelatedParty {
        return RelatedParty(id = "1", atReferredType = "String")
    }
}
