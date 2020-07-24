package com.bytetrain.prodinv.domain

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Describes a given characteristic of an object or entity through a name/value pair.
 * @param name Name of the characteristic
 * @param value
 * @param valueType Data type of the value of the characteristic
 * @param atBaseType When sub-classing, this defines the super-class
 * @param atSchemaLocation A URI to a JSON-Schema file that defines additional attributes and relationships
 * @param atType When sub-classing, this defines the sub-class entity name
 */

@Document(collection = "characteristics")
data class Characteristic(
    var name: String,
    var value: Any,
    var valueType: String? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
)
