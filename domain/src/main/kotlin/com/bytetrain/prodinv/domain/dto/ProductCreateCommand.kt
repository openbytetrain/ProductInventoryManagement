package com.bytetrain.prodinv.domain.dto

import com.bytetrain.prodinv.domain.ProductStatus

data class ProductCreateCommand(
    val status: ProductStatus,
    val description: String? = null,
    val isBundle: Boolean? = null,
    val isCustomerVisible: Boolean? = null,
    val name: String? = null,
    val orderDate: java.time.OffsetDateTime? = null,
    val productSerialNumber: String? = null,
    val startDate: java.time.OffsetDateTime? = null,
    val terminationDate: java.time.OffsetDateTime? = null,
//    val agreement: List<AgreementItemRefModel>? = null,
//    val billingAccount: BillingAccountRefModel? = null,
//    val place: List<RelatedPlaceRefOrValueModel>? = null,
//    val product: List<ProductRefOrValueModel>? = null,
//    val productCharacteristic: List<CharacteristicModel>? = null,
//    val productOffering: ProductOfferingRefModel? = null,
//    val productOrderItem: List<RelatedProductOrderItemModel>? = null,
//    val productPrice: List<ProductPriceModel>? = null,
//    val productRelationship: List<ProductRelationshipModel>? = null,
//    val productSpecification: ProductSpecificationRefModel? = null,
//    val productTerm: List<ProductTermModel>? = null,
//    val realizingResource: List<ResourceRefModel>? = null,
//    val realizingService: List<ServiceRefModel>? = null,
//    val relatedParty: List<RelatedPartyModel>? = null,
    val atBaseType: String? = null,
    val atSchemaLocation: java.net.URI? = null,
    val atType: String? = null
)
