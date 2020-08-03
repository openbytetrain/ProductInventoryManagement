package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductOfferingRefEntity
import com.bytetrain.prodinv.web.api.model.ProductOfferingRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductOfferingRefFactory {

    @ObjectFactory
    fun productOfferingRefToModelFactory(productOfferingRef: ProductOfferingRef): ProductOfferingRefEntity {
        return ProductOfferingRefEntity(productOfferingRef.id)
    }

    @ObjectFactory
    fun modelToProductOfferingRefFactory(productOfferingRefEntity: ProductOfferingRefEntity): ProductOfferingRef {
        return ProductOfferingRef(productOfferingRefEntity.id)
    }
}
