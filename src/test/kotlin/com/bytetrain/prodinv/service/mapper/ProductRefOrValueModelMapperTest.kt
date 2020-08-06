package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductRefOrValueEntity
import com.bytetrain.prodinv.web.api.model.*
import java.net.URI
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductRefOrValueModelMapperTest {

    @Autowired
    private lateinit var productRefOrValueModelMapper: ProductRefOrValueModelMapper
    private var productPrice = mutableListOf(ProductPrice(priceType = "1", price = Price()))
    private var agreement = mutableListOf(
        AgreementItemRef(
            "id",
            "href"
            )
    )
    private var place = mutableListOf(
        RelatedPlaceRefOrValue(
            "role",
            "id")
    )
    private var productCharacteristic = mutableListOf(
        Characteristic(
            "name",
            "value")
    )
    private var productOrderItem = mutableListOf(
        RelatedProductOrderItem(
            "orderItemId",
            "productOrderId"
        )
    )
    private var product = mutableListOf(
        ProductRefOrValue(
            "id",
            "href"
        )
    )
    private var productRelationship = mutableListOf(
        ProductRelationship(
            relationshipType = "relationshipType",
            product = ProductRefOrValue(name = "name")
        )
    )
    private var productTerm = mutableListOf(
        ProductTerm(
            description = null
        )
    )
    private var realizingResource = mutableListOf(
        ResourceRef(
            id = "id"
        )
    )
    private var realizingService = mutableListOf(
        ServiceRef(
            id = "id"
        )
    )
    private var relatedParty = mutableListOf(
        RelatedParty(
            id = "id",
            atReferredType = "atReferredType"
        )
    )

    @Test
    fun `Test toDto with ProductRefOrValueModelMapper`() {
        var productRefOrValue = productRefOrValueModelMapper.toDto(generateProductRefOrValueEntity())
        assertThat(productRefOrValue.id).isEqualTo(generateProductRefOrValueDto().id)
        assertThat(productRefOrValue.href).isEqualTo("href")
        assertThat(productRefOrValue.description).isEqualTo("description")
        assertThat(productRefOrValue.isBundle).isEqualTo(true)
        assertThat(productRefOrValue.isCustomerVisible).isEqualTo(true)
        assertThat(productRefOrValue.name).isEqualTo("name")
        assertThat(productRefOrValue.orderDate).isEqualTo(OffsetDateTime.MAX)
        assertThat(productRefOrValue.productSerialNumber).isEqualTo("1")
        assertThat(productRefOrValue.startDate).isEqualTo(OffsetDateTime.MIN)
        assertThat(productRefOrValue.terminationDate).isEqualTo(OffsetDateTime.MAX)
        assertThat(productRefOrValue.agreement).isEqualTo(agreement)
        assertThat(productRefOrValue.billingAccount?.id).isEqualTo("id")
        assertThat(productRefOrValue.place).isEqualTo(place)
        assertThat(productRefOrValue.product).isEqualTo(product)
        assertThat(productRefOrValue.productCharacteristic).isEqualTo(productCharacteristic)
        assertThat(productRefOrValue.productOffering?.id).isEqualTo("id")
        assertThat(productRefOrValue.productOrderItem).isEqualTo(productOrderItem)
        assertThat(productRefOrValue.productPrice).isEqualTo(productPrice)
        assertThat(productRefOrValue.productRelationship).isEqualTo(productRelationship)
        assertThat(productRefOrValue.productSpecification?.id).isEqualTo("id")
        assertThat(productRefOrValue.productTerm).isEqualTo(productTerm)
        assertThat(productRefOrValue.realizingResource).isEqualTo(realizingResource)
        assertThat(productRefOrValue.realizingService).isEqualTo(realizingService)
        assertThat(productRefOrValue.relatedParty).isEqualTo(relatedParty)
        assertThat(productRefOrValue.status).isEqualTo(ProductStatusType.active)
        assertThat(productRefOrValue.atBaseType).isEqualTo("atBaseType")
        assertThat(productRefOrValue.atSchemaLocation).isEqualTo(URI("1"))
        assertThat(productRefOrValue.atType).isEqualTo("atType")
        assertThat(productRefOrValue.atReferredType).isEqualTo("atReferredType")
    }

    @Test
    fun `Test toEntity with PriceModelMapper`() {
        var productRefOrValue = productRefOrValueModelMapper.toEntity(generateProductRefOrValueDto())
        assertThat(productRefOrValue.id).isEqualTo(generateProductRefOrValueEntity().id)
        assertThat(productRefOrValue.href).isEqualTo("href")
        assertThat(productRefOrValue.description).isEqualTo("description")
        assertThat(productRefOrValue.isBundle).isEqualTo(true)
        assertThat(productRefOrValue.isCustomerVisible).isEqualTo(true)
        assertThat(productRefOrValue.name).isEqualTo("name")
        assertThat(productRefOrValue.orderDate).isEqualTo(OffsetDateTime.MAX)
        assertThat(productRefOrValue.productSerialNumber).isEqualTo("1")
        assertThat(productRefOrValue.startDate).isEqualTo(OffsetDateTime.MIN)
        assertThat(productRefOrValue.terminationDate).isEqualTo(OffsetDateTime.MAX)
        assertThat(productRefOrValue.agreement).isEqualTo(agreement)
        assertThat(productRefOrValue.billingAccount?.id).isEqualTo("id")
        assertThat(productRefOrValue.place).isEqualTo(place)
        assertThat(productRefOrValue.product).isEqualTo(product)
        assertThat(productRefOrValue.productCharacteristic).isEqualTo(productCharacteristic)
        assertThat(productRefOrValue.productOffering?.id).isEqualTo("id")
        assertThat(productRefOrValue.productOrderItem).isEqualTo(productOrderItem)
        assertThat(productRefOrValue.productPrice).isEqualTo(productPrice)
        assertThat(productRefOrValue.productRelationship).isEqualTo(productRelationship)
        assertThat(productRefOrValue.productSpecification?.id).isEqualTo("id")
        assertThat(productRefOrValue.productTerm).isEqualTo(productTerm)
        assertThat(productRefOrValue.realizingResource).isEqualTo(realizingResource)
        assertThat(productRefOrValue.realizingService).isEqualTo(realizingService)
        assertThat(productRefOrValue.relatedParty).isEqualTo(relatedParty)
        assertThat(productRefOrValue.status).isEqualTo(ProductStatusType.active)
        assertThat(productRefOrValue.atBaseType).isEqualTo("atBaseType")
        assertThat(productRefOrValue.atSchemaLocation).isEqualTo(URI("1"))
        assertThat(productRefOrValue.atType).isEqualTo("atType")
        assertThat(productRefOrValue.atReferredType).isEqualTo("atReferredType")
    }

    fun generateProductRefOrValueEntity(): ProductRefOrValueEntity {
        return ProductRefOrValueEntity(
            id = "id",
            href = "href",
            description = "description",
            isBundle = true,
            isCustomerVisible = true,
            name = "name",
            orderDate = OffsetDateTime.MAX,
            productSerialNumber = "1",
            startDate = OffsetDateTime.MIN,
            terminationDate = OffsetDateTime.MAX,
            agreement = agreement,
            billingAccount = BillingAccountRef(
                id = "id",
                href = "href",
                name = "name"
            ),
            place = place,
            product = product,
            productCharacteristic = productCharacteristic,
            productOffering = ProductOfferingRef(
                id = "id",
                href = "href",
                name = "name"
            ),
            productOrderItem = productOrderItem,
            productPrice = productPrice,
            productRelationship = productRelationship,
            productSpecification = ProductSpecificationRef(
                id = "id",
                href = "href",
                name = "name",
                version = "version"
            ),
            productTerm = productTerm,
            realizingResource = realizingResource,
            realizingService = realizingService,
            relatedParty = relatedParty,
            status = ProductStatusType.active,
            atBaseType = "atBaseType",
            atSchemaLocation = URI("1"),
            atType = "atType",
            atReferredType = "atReferredType"
        )
    }

    fun generateProductRefOrValueDto(): ProductRefOrValue {
        return ProductRefOrValue(
            id = "id",
            href = "href",
            description = "description",
            isBundle = true,
            isCustomerVisible = true,
            name = "name",
            orderDate = OffsetDateTime.MAX,
            productSerialNumber = "1",
            startDate = OffsetDateTime.MIN,
            terminationDate = OffsetDateTime.MAX,
            agreement = agreement,
            billingAccount = BillingAccountRef(
                id = "id",
                href = "href",
                name = "name"
            ),
            place = place,
            product = product,
            productCharacteristic = productCharacteristic,
            productOffering = ProductOfferingRef(
                id = "id",
                href = "href",
                name = "name"
            ),
            productOrderItem = productOrderItem,
            productPrice = productPrice,
            productRelationship = productRelationship,
            productSpecification = ProductSpecificationRef(
                id = "id",
                href = "href",
                name = "name",
                version = "version"
            ),
            productTerm = productTerm,
            realizingResource = realizingResource,
            realizingService = realizingService,
            relatedParty = relatedParty,
            status = ProductStatusType.active,
            atBaseType = "atBaseType",
            atSchemaLocation = URI("1"),
            atType = "atType",
            atReferredType = "atReferredType"
        )
    }
}
