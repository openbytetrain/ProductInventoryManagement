package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.TargetProductSchema
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product_specification_ref")
data class ProductSpecificationRefEntity(
    var id: String,
    var href: String? = null,
    var name: String? = null,
    var version: String? = null,
    var targetProductSchema: TargetProductSchema? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null,
    var atReferredType: String? = null
)
