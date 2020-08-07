package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.RelatedProductOrderItemEntity
import com.bytetrain.prodinv.web.api.model.RelatedProductOrderItem
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class RelatedProductOrderItemFactory {

    @ObjectFactory
    fun relatedProductOrderItemToModelFactory(relatedPartyOrderItem: RelatedProductOrderItem): RelatedProductOrderItemEntity {
        return RelatedProductOrderItemEntity(
            orderItemAction = relatedPartyOrderItem.orderItemAction,
            orderItemId = relatedPartyOrderItem.productOrderId,
            productOrderId = relatedPartyOrderItem.productOrderId,
            productOrderHref = relatedPartyOrderItem.productOrderHref,
            role = relatedPartyOrderItem.role,
            atBaseType = relatedPartyOrderItem.atBaseType,
            atSchemaLocation = relatedPartyOrderItem.atSchemaLocation,
            atType = relatedPartyOrderItem.atType,
            atReferredType = relatedPartyOrderItem.atReferredType
        )
    }

    @ObjectFactory
    fun modelToRelatedProductOrderItemFactory(relatedPartyOrderItemEntity: RelatedProductOrderItemEntity): RelatedProductOrderItem {
        return RelatedProductOrderItem(
            orderItemAction = relatedPartyOrderItemEntity.orderItemAction,
            orderItemId = relatedPartyOrderItemEntity.productOrderId,
            productOrderId = relatedPartyOrderItemEntity.productOrderId,
            productOrderHref = relatedPartyOrderItemEntity.productOrderHref,
            role = relatedPartyOrderItemEntity.role,
            atBaseType = relatedPartyOrderItemEntity.atBaseType,
            atSchemaLocation = relatedPartyOrderItemEntity.atSchemaLocation,
            atType = relatedPartyOrderItemEntity.atType,
            atReferredType = relatedPartyOrderItemEntity.atReferredType
        )
    }
}
