package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.apidelegate.mapper.ProductCreateModelMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductCreateModelMapperTest {

    @Autowired
    private lateinit var productCreateModelMapper: ProductCreateModelMapper

    private var productCharacteristics = mutableListOf(
        Characteristic(name = "name", value = Any()))
    private var relatedParty = mutableListOf(
        RelatedParty(id = "1", atReferredType = "1"))
    private var realizingService = mutableListOf(
        ServiceRef(id = "1"))
    private var productPrice = mutableListOf(ProductPrice(priceType = "1", price = Price()))

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
        Assertions.assertThat(product.productPriceEntity == productPrice)
        Assertions.assertThat(product.productSpecification?.id == "1")
        Assertions.assertThat(product.realizingService == realizingService)
        Assertions.assertThat(product.relatedParty == relatedParty)
    }

    fun generateDto(): ProductCreate {

        return ProductCreate(
            status = ProductStatusType.active,
            description = "String",
            name = "Product",
            billingAccount = BillingAccountRef(id = "id_string"),
            productCharacteristic = productCharacteristics,
            productOffering = ProductOfferingRef(id = "1"),
            productPrice = productPrice,
            productSpecification = ProductSpecificationRef(id = "1"),
            realizingService = realizingService,
            relatedParty = relatedParty)
    }
}
