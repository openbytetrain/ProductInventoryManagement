package com.bytetrain.prodinv.entity
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "money")
data class MoneyEntity(
    var unit: String? = null,
    var value: Float? = null
)
