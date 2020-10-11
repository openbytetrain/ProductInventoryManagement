package com.bytetrain.prodinv.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "characteristic")
data class CharacteristicEntity(
    var name: String,
    var value: Any,
    var valueType: String? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
)
