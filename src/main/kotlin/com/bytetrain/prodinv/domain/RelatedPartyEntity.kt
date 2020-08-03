package com.bytetrain.prodinv.domain


import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "related_party")
data class RelatedPartyEntity(

    var id: String,
    var atReferredType: String,
    var href: String? = null,
    var name: String? = null,
    var role: String? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null
) {
}
