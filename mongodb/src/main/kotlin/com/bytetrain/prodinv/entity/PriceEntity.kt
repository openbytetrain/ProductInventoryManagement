package com.bytetrain.prodinv.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "price")
data class PriceEntity(
        var percentage: Float? = null,
        var taxRate: Float? = null,
        var dutyFreeAmount: MoneyEntity? = null,
        var taxIncludedAmount: MoneyEntity? = null,
        var atBaseType: String? = null,
        var atSchemaLocation: java.net.URI? = null,
        var atType: String? = null

)
