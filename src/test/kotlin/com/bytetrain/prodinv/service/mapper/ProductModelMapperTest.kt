package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.web.api.model.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductModelMapperTest {

    private lateinit var productModelMapper: ProductModelMapper

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
        productModelMapper = ProductModelMapperImpl()
    }

    @Test
    fun `test Product Dto creation with ProductModelMapper`() {

        val product = productModelMapper.toDto(generateProduct())
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

    private fun generateProduct(): Product {

        return Product("1",
            "Product",
            ProductStatusType.cancelled,
            "String",
            ProductOfferingRef("1", null, null, null, null, null,
                null),
            productCharacteristics,
            ProductSpecificationRef("1", null, null, null, null, null,
                null, null, null),
            BillingAccountRef("id_string", null, null, null, null, null,
                null),
            null,
            relatedParty,
            realizingService,
            productPrice)
    }
}
