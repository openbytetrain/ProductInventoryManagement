package com.bytetrain.prodinv.web.apidelegate.mapper.factory

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.domain.dto.ProductCreateCommand
import com.bytetrain.prodinv.web.api.model.ProductCreate
import com.bytetrain.prodinv.web.api.model.ProductStatusType
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductCreateFactory() {

    @ObjectFactory
    fun productToProductCreateFactory(productEntity: ProductEntity): ProductCreateCommand {
        return ProductCreateCommand(
            status = ProductStatusType.pendingActive,
            description = productEntity.description,
            name = productEntity.name,
            billingAccount = productEntity.billingAccount,
            productOffering = productEntity.productOffering,
            productSpecification = productEntity.productSpecification,
            realizingService = productEntity.realizingService,
            relatedParty = productEntity.relatedParty,
            atSchemaLocation = productEntity.atSchemaLocation
        )
    }
}
