package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.*
import java.net.URI

fun ProductOfferingRef.Companion.defaultTestEntity(
    id: String = "1",
    href: String = "http://test",
    name: String = "name",
    baseType: String = "BillingAccountRef",
    schemaLocation: URI = URI("http://SchemaLocation"),
    type: String = "type",
    referredType: String = "referredType"
): ProductOfferingRef {
    return ProductOfferingRef(
        id = id,
        href = href,
        name = name,
        atBaseType = baseType,
        atSchemaLocation = schemaLocation,
        atType = type,
        atReferredType = referredType)
}

fun BillingAccountRef.Companion.defaultTestEntity(
    id: String = "1",
    href: String = "http://test",
    name: String = "name",
    baseType: String = "BillingAccountRef",
    schemaLocation: URI = URI("http://SchemaLocation"),
    type: String = "type",
    referredType: String = "referredType"
): BillingAccountRef {
    return BillingAccountRef(
        id = id,
        href = href,
        name = name,
        atBaseType = baseType,
        atSchemaLocation = schemaLocation,
        atType = type,
        atReferredType = referredType)
}

fun ProductSpecificationRef.Companion.defaultTestEntity(
    id: String = "1",
    href: String = "http://test",
    name: String = "name",
    baseType: String = "ProductSpecification",
    schemaLocation: URI = URI("http://SchemaLocation"),
    type: String = "type",
    referredType: String = "referredType"
): ProductSpecificationRef {
    return ProductSpecificationRef(
        id = id,
        href = href,
        name = name,
        atBaseType = baseType,
        atSchemaLocation = schemaLocation,
        atType = type,
        atReferredType = referredType)
}

fun ProductEntity.Companion.defaultTestEntity(
    id: String = "1",
    name: String = "Name",
    status: ProductStatusType = ProductStatusType.active,
    description: String = "Description",
    productOffering: ProductOfferingRef = ProductOfferingRef.defaultTestEntity(),
    productCharacteristic: List<CharacteristicEntity> = emptyList(),
    productSpecification: ProductSpecificationRef = ProductSpecificationRef.defaultTestEntity(),
    billingAccount: BillingAccountRef = BillingAccountRef.defaultTestEntity(),
    atSchemaLocation: URI = URI("http://schema"),
    relatedParty: List<RelatedParty> = emptyList(),
    realizingService: List<ServiceRef> = emptyList(),
    productPriceEntity: List<ProductPriceEntity> = emptyList()
): ProductEntity {
    return ProductEntity(
        id = id,
        name = name,
        status = status,
        description = description,
        productOffering = productOffering,
        productCharacteristic = productCharacteristic,
        productSpecification = productSpecification,
        billingAccount = billingAccount,
        atSchemaLocation = atSchemaLocation,
        relatedParty = relatedParty,
        realizingService = realizingService,
        productPriceEntity = productPriceEntity
    )
}
