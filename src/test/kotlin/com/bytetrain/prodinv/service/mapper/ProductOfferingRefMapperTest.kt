package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductOfferingRefEntity
import com.bytetrain.prodinv.web.api.model.ProductOfferingRef
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductOfferingRefMapperTest {

    @Autowired
    private lateinit var productOfferingRefMapper: ProductOfferingRefMapper

    @Test
    fun `test ProductOfferingRef toDto mapping with ProductOfferingRefMapper`() {
        val productOfferingRefEntity = productOfferingRefMapper.toDto(generateProductOfferingRefEntity())
        Assertions.assertThat(productOfferingRefEntity.id).isEqualTo("5")
        Assertions.assertThat(productOfferingRefEntity.href).isEqualTo("string")
        Assertions.assertThat(productOfferingRefEntity.name).isEqualTo("string")
    }

    @Test
    fun `test ProductOfferingRef toEntity mapping with ProductOfferingRefMapper`() {
        val productOfferingRefDto = productOfferingRefMapper.toEntity(generateProductOfferingRefDto())
        Assertions.assertThat(productOfferingRefDto.id).isEqualTo("4")
        Assertions.assertThat(productOfferingRefDto.href).isEqualTo("string")
        Assertions.assertThat(productOfferingRefDto.name).isEqualTo("string")
    }

    private fun generateProductOfferingRefEntity(): ProductOfferingRefEntity {
        return ProductOfferingRefEntity(id = "5", href = "string", name = "string")
    }

    private fun generateProductOfferingRefDto(): ProductOfferingRef {
        return ProductOfferingRef(id = "4", href = "string", name = "string")
    }
}
