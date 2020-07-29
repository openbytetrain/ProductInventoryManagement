package com.bytetrain.prodinv.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "price")
data class Price(
    var percentage: Float? = null,
    var taxRate: Float? = null,
    var dutyFreeAmount: Money? = null,
    var taxIncludedAmount: Money? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null

)
