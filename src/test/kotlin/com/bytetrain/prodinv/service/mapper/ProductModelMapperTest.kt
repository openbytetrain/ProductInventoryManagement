package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.CharacteristicEntity
import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.domain.ProductPriceEntity
import com.bytetrain.prodinv.web.apidelegate.mapper.ProductModelMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductModelMapperTest {

    private lateinit var productModelMapper: ProductModelMapper

    private var productCharacteristics = mutableListOf(
        CharacteristicEntity(name = "name", value = Any()))
    private var relatedParty = mutableListOf(
        RelatedParty(id = "1", atReferredType = "1"))
    private var realizingService = mutableListOf(
        ServiceRef(id = "1"))
    private var productPrice = mutableListOf(
        ProductPriceEntity(
            priceType = "1",
            priceEntity = PriceEntity()))

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

    private fun generateProduct(): ProductEntity {

        return ProductEntity(id = "1",
            name = "Product",
            status = ProductStatusType.cancelled,
            description = "String",
            productOffering = ProductOfferingRef(id = "1"),
            productCharacteristic = productCharacteristics,
            productSpecification = ProductSpecificationRef(id = "1"),
            billingAccount = BillingAccountRef(id = "id_string"),
            relatedParty = relatedParty,
            realizingService = realizingService,
            productPriceEntity = productPrice)
    }
}
