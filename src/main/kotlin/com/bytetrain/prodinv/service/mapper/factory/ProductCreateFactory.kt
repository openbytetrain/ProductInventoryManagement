package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.service.mapper.ProductCreateModelMapper
import com.bytetrain.prodinv.web.api.model.ProductCreate
import com.bytetrain.prodinv.web.api.model.ProductStatusType
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductCreateFactory(var createModelMapper: ProductCreateModelMapper) {

    @ObjectFactory
    fun productToProductCreateFactory(productEntity: ProductEntity): ProductCreate {
        return ProductCreate(
            status = ProductStatusType.pendingActive,
            description = productEntity.description,
            name = productEntity.name,
            productSpecification = productEntity.productSpecification,
            realizingService = productEntity.realizingService,
            atSchemaLocation = productEntity.atSchemaLocation
        )
    }
}
