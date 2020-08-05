package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.*
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product_ref_or_value")
data class ProductRefOrValueEntity(
    var id: String? = null,
    var href: String? = null,
    var description: String? = null,
    var isBundle: Boolean? = null,
    var isCustomerVisible: Boolean? = null,
    var name: String? = null,
    var orderDate: java.time.OffsetDateTime? = null,
    var productSerialNumber: String? = null,
    var startDate: java.time.OffsetDateTime? = null,
    var terminationDate: java.time.OffsetDateTime? = null,
    var agreement: List<AgreementItemRef>? = null,
    var billingAccount: BillingAccountRef? = null,
    var place: List<RelatedPlaceRefOrValue>? = null,
    var product: List<ProductRefOrValue>? = null,
    var productCharacteristic: List<Characteristic>? = null,
    var productOffering: ProductOfferingRef? = null,
    var productOrderItem: List<RelatedProductOrderItem>? = null,
    var productPrice: List<ProductPrice>? = null,
    var productRelationship: List<ProductRelationship>? = null,
    var productSpecification: ProductSpecificationRef? = null,
    var productTerm: List<ProductTerm>? = null,
    var realizingResource: List<ResourceRef>? = null,
    var realizingService: List<ServiceRef>? = null,
    var relatedParty: List<RelatedParty>? = null,
    var status: ProductStatusType? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null,
    var atReferredType: String? = null
)
