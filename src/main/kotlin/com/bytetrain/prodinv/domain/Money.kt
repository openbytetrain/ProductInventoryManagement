package com.bytetrain.prodinv.domain
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "money")
data class Money(
    var unit: String? = null,
    var value: Float? = null
)
