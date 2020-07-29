package com.bytetrain.prodinv.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "price")
data class Price(
    var percentage: Float? = null,
    var taxRate: Float? = null,
    var dutyFreeAmount: com.bytetrain.prodinv.domain.Money? = null,
    var taxIncludedAmount: com.bytetrain.prodinv.domain.Money? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null

)

