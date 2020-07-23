package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.api.model.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductCreateModelMapperTest {

    private lateinit var productCreateModelMapper: ProductCreateModelMapper

    private var productCharacteristics = mutableListOf(Characteristic("name", Any(), null,
        null, null, null))
    private var relatedParty = mutableListOf(RelatedParty("1", "1", null, null, null,
        null, null, null))
    private var realizingService = mutableListOf(ServiceRef("1", null, null, null,
        null, null, null))
    private var productPrice = mutableListOf(ProductPrice("1", Price(null, null,
        null, null, null, null, null), null,
        null, null, null, null, null,
        null, null, null, null))

    @BeforeEach
    fun setUp() {
        productCreateModelMapper = ProductCreateModelMapperImpl()
    }

    @Test
    fun testEntityFromId() {
        val id = "id1"
        Assertions.assertThat(productCreateModelMapper.fromId(id)?.id).isEqualTo(id)
        Assertions.assertThat(productCreateModelMapper.fromId(null)).isNull()
    }

    @Test
    fun `test Product Entity creation with mapper`() {
        val product = productCreateModelMapper.toEntity(generateDto())
        Assertions.assertThat(product.name == "String")
        Assertions.assertThat(product.status == ProductStatusType.active)
        Assertions.assertThat(product.atSchemaLocation == null)
        Assertions.assertThat(product.billingAccount?.id == "id_string")
        Assertions.assertThat(product.description == "String")
        Assertions.assertThat(product.productCharacteristic == productCharacteristics)
        Assertions.assertThat(product.productOffering?.id == "1")
        Assertions.assertThat(product.productPrice == productPrice)
        Assertions.assertThat(product.productSpecification?.id == "1")
        Assertions.assertThat(product.realizingService == realizingService)
        Assertions.assertThat(product.relatedParty == relatedParty)
    }

    fun generateDto(): ProductCreate {

        return ProductCreate(
            ProductStatusType.active,
            "String",
            null,
            null,
            "Product",
            null,
            null,
            null,
            null,
            null,
            BillingAccountRef("id_string", null, null, null, null, null,
                null),
            null,
            null,
            productCharacteristics,
            ProductOfferingRef("1", null, null, null, null, null,
                null),
            null,
            productPrice,
            null,
            ProductSpecificationRef("1", null, null, null, null, null,
                null, null, null),
            null,
            null,
            realizingService,
            relatedParty,
            null,
            null,
            null)
    }
}
