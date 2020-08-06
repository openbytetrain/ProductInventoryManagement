package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductRefOrValueEntity
import com.bytetrain.prodinv.service.mapper.ProductRefOrValueModelMapper
import com.bytetrain.prodinv.web.api.model.ProductRefOrValue
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductRefOrValueFactory(var productRefOrValueModelMapper: ProductRefOrValueModelMapper) {
    @ObjectFactory
    fun productRefOrValueToModelFactory(productRefOrValueEntity: ProductRefOrValueEntity): ProductRefOrValueEntity {
        return ProductRefOrValueEntity(
            productRefOrValueEntity.id,
            productRefOrValueEntity.href,
            productRefOrValueEntity.description,
            productRefOrValueEntity.isBundle,
            productRefOrValueEntity.isCustomerVisible,
            productRefOrValueEntity.name,
            productRefOrValueEntity.orderDate,
            productRefOrValueEntity.productSerialNumber,
            productRefOrValueEntity.startDate,
            productRefOrValueEntity.terminationDate,
            productRefOrValueEntity.agreement,
            productRefOrValueEntity.billingAccount,
            productRefOrValueEntity.place,
            productRefOrValueEntity.product,
            productRefOrValueEntity.productCharacteristic,
            productRefOrValueEntity.productOffering,
            productRefOrValueEntity.productOrderItem,
            productRefOrValueEntity.productPrice,
            productRefOrValueEntity.productRelationship,
            productRefOrValueEntity.productSpecification,
            productRefOrValueEntity.productTerm,
            productRefOrValueEntity.realizingResource,
            productRefOrValueEntity.realizingService,
            productRefOrValueEntity.relatedParty,
            productRefOrValueEntity.status,
            productRefOrValueEntity.atBaseType,
            productRefOrValueEntity.atSchemaLocation,
            productRefOrValueEntity.atType,
            productRefOrValueEntity.atReferredType
            )
    }

    @ObjectFactory
    fun modelToProductRefOrValueFactory(productRefOrValueEntity: ProductRefOrValueEntity): ProductRefOrValue {
        return ProductRefOrValue(
            productRefOrValueEntity.id,
            productRefOrValueEntity.href,
            productRefOrValueEntity.description,
            productRefOrValueEntity.isBundle,
            productRefOrValueEntity.isCustomerVisible,
            productRefOrValueEntity.name,
            productRefOrValueEntity.orderDate,
            productRefOrValueEntity.productSerialNumber,
            productRefOrValueEntity.startDate,
            productRefOrValueEntity.terminationDate,
            productRefOrValueEntity.agreement,
            productRefOrValueEntity.billingAccount,
            productRefOrValueEntity.place,
            productRefOrValueEntity.product,
            productRefOrValueEntity.productCharacteristic,
            productRefOrValueEntity.productOffering,
            productRefOrValueEntity.productOrderItem,
            productRefOrValueEntity.productPrice,
            productRefOrValueEntity.productRelationship,
            productRefOrValueEntity.productSpecification,
            productRefOrValueEntity.productTerm,
            productRefOrValueEntity.realizingResource,
            productRefOrValueEntity.realizingService,
            productRefOrValueEntity.relatedParty,
            productRefOrValueEntity.status,
            productRefOrValueEntity.atBaseType,
            productRefOrValueEntity.atSchemaLocation,
            productRefOrValueEntity.atType,
            productRefOrValueEntity.atReferredType
        )
    }
}
