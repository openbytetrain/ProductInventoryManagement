package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.web.api.model.ProductCreate
import com.bytetrain.prodinv.web.api.model.ProductStatusType
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductCreateFactory() {

    @ObjectFactory
    fun productToProductCreateFactory(productEntity: ProductEntity): ProductCreate {

        return ProductCreate(
            ProductStatusType.pendingActive,
            productEntity.description,
            null,
            null,
            productEntity.name,
            null,
            null,
            null,
            null,
            null,
            productEntity.billingAccount,
            null,
            null,
            null,
            productEntity.productOffering,
            null,
            null,
            null,
            productEntity.productSpecification,
            null,
            null,
            productEntity.realizingService,
            productEntity.relatedParty,
            null,
            productEntity.atSchemaLocation,
            null)
    }
}
