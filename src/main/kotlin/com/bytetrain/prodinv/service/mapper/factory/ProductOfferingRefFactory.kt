package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductOfferingRefEntity
import com.bytetrain.prodinv.web.api.model.ProductOfferingRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductOfferingRefFactory {

    @ObjectFactory
    fun productOfferingRefToModelFactory(productOfferingRef: ProductOfferingRef): ProductOfferingRefEntity {
        return ProductOfferingRefEntity(
            id = productOfferingRef.id,
            href = productOfferingRef.href,
            name = productOfferingRef.name,
            atBaseType = productOfferingRef.atBaseType,
            atSchemaLocation = productOfferingRef.atSchemaLocation,
            atType = productOfferingRef.atType,
            atReferredType = productOfferingRef.atReferredType)
    }

    @ObjectFactory
    fun modelToProductOfferingRefFactory(productOfferingRefEntity: ProductOfferingRefEntity): ProductOfferingRef {
        return ProductOfferingRef(
            id = productOfferingRefEntity.id,
            href = productOfferingRefEntity.href,
            name = productOfferingRefEntity.name,
            atBaseType = productOfferingRefEntity.atBaseType,
            atSchemaLocation = productOfferingRefEntity.atSchemaLocation,
            atType = productOfferingRefEntity.atType,
            atReferredType = productOfferingRefEntity.atReferredType
        )
    }
}
