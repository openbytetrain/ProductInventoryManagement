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
            status = ProductStatusType.pendingActive,
            description = productEntity.description,
            name = productEntity.name,
            billingAccount = productEntity.billingAccount,
            productOffering = productEntity.productOffering,
            relatedParty = productEntity.relatedParty,
            atSchemaLocation = productEntity.atSchemaLocation
        )
    }

    @ObjectFactory
    fun productCreateToProductFactory(productCreate: ProductCreate): ProductEntity {
        return ProductEntity(
            status = ProductStatusType.pendingActive,
            description = productCreate.description,
            name = productCreate.name,
            billingAccount = productCreate.billingAccount,
            productOffering = productCreate.productOffering,
            relatedParty = productCreate.relatedParty,
            atSchemaLocation = productCreate.atSchemaLocation
        )
    }
}
