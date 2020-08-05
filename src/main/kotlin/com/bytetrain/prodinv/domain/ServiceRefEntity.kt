package com.bytetrain.prodinv.domain
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "service_ref")
data class ServiceRefEntity(
    var id: String,
    var href: String? = null,
    var name: String? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null,
    var atReferredType: String? = null

)
