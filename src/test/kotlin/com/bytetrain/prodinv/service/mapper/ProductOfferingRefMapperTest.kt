package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductOfferingRefEntity
import com.bytetrain.prodinv.web.api.model.ProductOfferingRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductOfferingRefMapperTest {

    @Autowired
    private lateinit var productOfferingRefMapper: ProductOfferingRefMapper

    @Test
    fun `test ProductOfferingRef toDto mapping with ProductOfferingRefMapper`() {
        val productOfferingRef = productOfferingRefMapper.toDto(generateProductOfferingRefEntity())
        assertThat(productOfferingRef.id).isEqualTo(generateProductOfferingRefEntity().id)
        assertThat(productOfferingRef.href).isEqualTo("string")
        assertThat(productOfferingRef.name).isEqualTo("string")
        assertThat(productOfferingRef.atBaseType).isEqualTo("string")
        assertThat(productOfferingRef.atType).isEqualTo("string")
        assertThat(productOfferingRef.atReferredType).isEqualTo("string")
    }

    @Test
    fun `test ProductOfferingRef toEntity mapping with ProductOfferingRefMapper`() {
        val productOfferingRef = productOfferingRefMapper.toEntity(generateProductOfferingRefDto())
        assertThat(productOfferingRef.id).isEqualTo(generateProductOfferingRefDto().id)
        assertThat(productOfferingRef.href).isEqualTo("string")
        assertThat(productOfferingRef.name).isEqualTo("string")
        assertThat(productOfferingRef.atBaseType).isEqualTo("string")
        assertThat(productOfferingRef.atType).isEqualTo("string")
        assertThat(productOfferingRef.atReferredType).isEqualTo("string")
    }

    private fun generateProductOfferingRefEntity(): ProductOfferingRefEntity {
        return ProductOfferingRefEntity(
            id = "5",
            href = "string",
            name = "string",
            atBaseType = "string",
            atType = "string",
            atReferredType = "string"
        )
    }

    private fun generateProductOfferingRefDto(): ProductOfferingRef {
        return ProductOfferingRef(
            id = "4",
            href = "string",
            name = "string",
            atBaseType = "string",
            atType = "string",
            atReferredType = "string")
    }
}
