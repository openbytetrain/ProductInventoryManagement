package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductRefOrValueEntity
import com.bytetrain.prodinv.web.api.model.ProductRefOrValue
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductRefOrValueModelMapperTest {

    @Autowired
    private lateinit var productRefOrValueModelMapper: ProductRefOrValueModelMapper

    @Test
    fun `Test toDto with ProductRefOrValueModelMapper`() {
        var productRefOrValue = productRefOrValueModelMapper.toDto(generateProductRefOrValueEntity())
        Assertions.assertThat(productRefOrValue.id).isEqualTo("id")
        Assertions.assertThat(productRefOrValue.href).isEqualTo("href")
        Assertions.assertThat(productRefOrValue.description).isEqualTo("description")
        Assertions.assertThat(productRefOrValue.isBundle).isEqualTo(true)
        Assertions.assertThat(productRefOrValue.isCustomerVisible).isEqualTo(true)
        Assertions.assertThat(productRefOrValue.name).isEqualTo("name")
        Assertions.assertThat(productRefOrValue.orderDate).isEqualTo(null)
        Assertions.assertThat(productRefOrValue.productSerialNumber).isEqualTo("1")
        Assertions.assertThat(productRefOrValue.startDate).isEqualTo(null)
    }

    @Test
    fun `Test toEntity with PriceModelMapper`() {
        var productRefOrValue = productRefOrValueModelMapper.toEntity(generateProductRefOrValueDto())
        Assertions.assertThat(productRefOrValue.id).isEqualTo("id")
        Assertions.assertThat(productRefOrValue.href).isEqualTo("href")
        Assertions.assertThat(productRefOrValue.description).isEqualTo("description")
        Assertions.assertThat(productRefOrValue.isBundle).isEqualTo(true)
        Assertions.assertThat(productRefOrValue.isCustomerVisible).isEqualTo(true)
        Assertions.assertThat(productRefOrValue.name).isEqualTo("name")
        Assertions.assertThat(productRefOrValue.orderDate).isEqualTo(null)
        Assertions.assertThat(productRefOrValue.productSerialNumber).isEqualTo("1")
        Assertions.assertThat(productRefOrValue.startDate).isEqualTo(null)
    }

    fun generateProductRefOrValueEntity(): ProductRefOrValueEntity {
        return ProductRefOrValueEntity(
            id = "id",
            href = "href",
            description = "description",
            isBundle = true,
            isCustomerVisible = true,
            name = "name",
            orderDate = null,
            productSerialNumber = "1",
            startDate = null,
            terminationDate = null,
            agreement = null,
            billingAccount = null,
            place = null,
            product = null,
            productCharacteristic = null,
            productOffering = null,
            productOrderItem = null,
            productPrice = null,
            productRelationship = null,
            productSpecification = null,
            productTerm = null,
            realizingResource = null,
            realizingService = null,
            relatedParty = null,
            status = null,
            atBaseType = null,
            atSchemaLocation = null,
            atType = null,
            atReferredType = null
        )
    }

    fun generateProductRefOrValueDto(): ProductRefOrValue {
        return ProductRefOrValue()
    }
}
