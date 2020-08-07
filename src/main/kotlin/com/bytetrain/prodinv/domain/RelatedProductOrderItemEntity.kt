package com.bytetrain.prodinv.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "related_product_order_item")

data class RelatedProductOrderItemEntity(

    var orderItemId: String,
    var productOrderId: String,
    var orderItemAction: String? = null,
    var productOrderHref: String? = null,
    var role: String? = null,
    var atBaseType: String? = null,
    var atSchemaLocation: java.net.URI? = null,
    var atType: String? = null,
    var atReferredType: String? = null
)
