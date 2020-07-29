package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.ProductOfferingPriceRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "price_alteration")
data class PriceAlteration(
    var priceType: String,
    var price: com.bytetrain.prodinv.domain.Price,
    var applicationDuration: Int? = null,
    var description: String? = null,
    var name: String? = null,
    var priority: Int? = null,
    var recurringChargePeriod: String? = null,
    var unitOfMeasure: String? = null,
    var productOfferingPrice: ProductOfferingPriceRef? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
)
