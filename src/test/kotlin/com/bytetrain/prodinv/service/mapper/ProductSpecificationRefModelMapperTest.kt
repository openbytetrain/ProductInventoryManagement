package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductSpecificationRefEntity
import com.bytetrain.prodinv.web.api.model.ProductSpecificationRef
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductSpecificationRefModelMapperTest {

    @Autowired
    private lateinit var productSpecificationRefModelMapper: ProductSpecificationRefModelMapper

    @Test
    fun `test productSpecificationRef creation with productSpecificationRefModelMapper`() {
        var productSpecificationRef = productSpecificationRefModelMapper.toDto(generateSpecificationRefEntity())
        Assertions.assertThat(productSpecificationRef.id).isEqualTo("string1")
        Assertions.assertThat(productSpecificationRef.href).isEqualTo("string2")
        Assertions.assertThat(productSpecificationRef.name).isEqualTo("string3")
    }

    @Test
    fun `test productSpecificationRefEntity creation with productSpecificationRefModelMapper`() {
        var productSpecificationRefEntity = productSpecificationRefModelMapper.toEntity(generateSpecificationRefDto())
        Assertions.assertThat(productSpecificationRefEntity.id).isEqualTo("string1")
        Assertions.assertThat(productSpecificationRefEntity.href).isEqualTo("string2")
        Assertions.assertThat(productSpecificationRefEntity.name).isEqualTo("string3")
    }

    private fun generateSpecificationRefEntity(): ProductSpecificationRefEntity {
        return ProductSpecificationRefEntity(
            id = "string1",
            href = "string2",
            name = "string3"

        )
    }

    private fun generateSpecificationRefDto(): ProductSpecificationRef {
        return ProductSpecificationRef(
            id = "string1",
            href = "string2",
            name = "string3"

        )
    }
}
