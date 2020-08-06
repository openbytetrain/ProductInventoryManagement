package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.Quantity
import com.bytetrain.prodinv.web.api.model.TimePeriod
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product_term")
data class ProductTermEntity(
    var description: String? = null,
    var name: String? = null,
    var duration: Quantity? = null,
    var validFor: TimePeriod? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
)
