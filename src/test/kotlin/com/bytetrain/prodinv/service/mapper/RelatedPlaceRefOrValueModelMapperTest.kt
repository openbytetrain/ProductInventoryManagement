package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedPlaceRefOrValueEntity
import com.bytetrain.prodinv.web.api.model.RelatedPlaceRefOrValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RelatedPlaceRefOrValueModelMapperTest {

    @Autowired
    private lateinit var relatedPlaceRefOrValueModelMapper: RelatedPlaceRefOrValueModelMapper

    @Test
    fun `test relatedPlaceOrRefValue Dto creation with RelatedPlaceRefOrValueModelMapper`() {
        var relatedPlaceRefOrValue = relatedPlaceRefOrValueModelMapper.toDto(generateRelatedPlaceRefOrValueEntity())
        assertThat(relatedPlaceRefOrValue.role).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.id).isEqualTo(generateRelatedPlaceRefOrValueEntity().id)
        assertThat(relatedPlaceRefOrValue.href).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.name).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atReferredType).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atType).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atBaseType).isEqualTo("string")
    }

    @Test
    fun `test relatedPlaceOrRefValue Entity creation with RelatedPlaceRefOrValueModelMapper`() {
        var relatedPlaceRefOrValue = relatedPlaceRefOrValueModelMapper.toEntity(generateRelatedPlaceRefOrValueDto())
        assertThat(relatedPlaceRefOrValue.role).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.id).isEqualTo(generateRelatedPlaceRefOrValueDto().id)
        assertThat(relatedPlaceRefOrValue.href).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.name).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atReferredType).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atType).isEqualTo("string")
        assertThat(relatedPlaceRefOrValue.atBaseType).isEqualTo("string")
    }

    private fun generateRelatedPlaceRefOrValueEntity(): RelatedPlaceRefOrValueEntity {
        return RelatedPlaceRefOrValueEntity(
            role = "string",
            id = "string1",
            href = "string",
            name = "string",
            atReferredType = "string",
            atType = "string",
            atBaseType = "string"
        )
    }

    private fun generateRelatedPlaceRefOrValueDto(): RelatedPlaceRefOrValue {
        return RelatedPlaceRefOrValue(
            role = "string",
            id = "string2",
            href = "string",
            name = "string",
            atReferredType = "string",
            atType = "string",
            atBaseType = "string"
        )
    }
}
