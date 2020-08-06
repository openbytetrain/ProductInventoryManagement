package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductTermEntity
import com.bytetrain.prodinv.web.api.model.ProductTerm
import com.bytetrain.prodinv.web.api.model.Quantity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductTermModelMapperTest {

    @Autowired
    private lateinit var productTermModelMapper: ProductTermModelMapper

    @Test
    fun `test ProductTerm toDto mapping with ProductTermModelMapper`() {
        var productTerm = productTermModelMapper.toDto(generateProductTermEntity())
        assertThat(productTerm.description).isEqualTo("string")
        assertThat(productTerm.name).isEqualTo("string")
        assertThat(productTerm.atBaseType).isEqualTo("string")
        assertThat(productTerm.atType).isEqualTo("string")
        assertThat(productTerm.duration?.units).isEqualTo("string")
    }

    @Test
    fun `test ProductTerm toEntity mapping with ProductTermModelMapper`() {
        var productTerm = productTermModelMapper.toEntity(generateProductTermDto())
        assertThat(productTerm.description).isEqualTo("string")
        assertThat(productTerm.name).isEqualTo("string")
        assertThat(productTerm.atBaseType).isEqualTo("string")
        assertThat(productTerm.atType).isEqualTo("string")
        assertThat(productTerm.duration?.units).isEqualTo("string")
    }

    private fun generateProductTermEntity(): ProductTermEntity {
        return ProductTermEntity(
            description = "string",
            name = "string",
            atBaseType = "string",
            atType = "string",
            duration = Quantity(units = "string")
        )
    }

    private fun generateProductTermDto(): ProductTerm {
        return ProductTerm(
            description = "string",
            name = "string",
            atBaseType = "string",
            atType = "string",
            duration = Quantity(units = "string")
        )
    }
}
