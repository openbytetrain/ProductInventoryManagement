package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import com.bytetrain.prodinv.web.api.model.ProductOfferingPriceRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product_price")
data class ProductPriceEntity(
    var priceType: String,
    var priceEntity: com.bytetrain.prodinv.domain.PriceEntity,
    var description: String? = null,
    var name: String? = null,
    var recurringChargePeriod: String? = null,
    var unitOfMeasure: String? = null,
    var billingAccount: BillingAccountRef? = null,
    var productOfferingPrice: ProductOfferingPriceRef? = null,
    var productPriceAlterationEntity: List<com.bytetrain.prodinv.domain.PriceAlterationEntity>? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
)
