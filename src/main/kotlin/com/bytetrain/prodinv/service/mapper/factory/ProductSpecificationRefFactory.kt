package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductSpecificationRefEntity
import com.bytetrain.prodinv.web.api.model.ProductSpecificationRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductSpecificationRefFactory {

    @ObjectFactory
    fun productSpecificationRefToModel(productSpecificationRef: ProductSpecificationRef): ProductSpecificationRefEntity {
        return ProductSpecificationRefEntity(
            id = productSpecificationRef.id,
            href = productSpecificationRef.href,
            name = productSpecificationRef.name,
            version = productSpecificationRef.version,
            targetProductSchema = productSpecificationRef.targetProductSchema,
            atBaseType = productSpecificationRef.atBaseType,
            atSchemaLocation = productSpecificationRef.atSchemaLocation,
            atType = productSpecificationRef.atType,
            atReferredType = productSpecificationRef.atReferredType)
    }

    @ObjectFactory
    fun modelToProductSpecificationRef(productSpecificationRefEntity: ProductSpecificationRefEntity): ProductSpecificationRef {
        return ProductSpecificationRef(
            id = productSpecificationRefEntity.id,
            href = productSpecificationRefEntity.href,
            name = productSpecificationRefEntity.name,
            version = productSpecificationRefEntity.version,
            targetProductSchema = productSpecificationRefEntity.targetProductSchema,
            atBaseType = productSpecificationRefEntity.atBaseType,
            atSchemaLocation = productSpecificationRefEntity.atSchemaLocation,
            atType = productSpecificationRefEntity.atType,
            atReferredType = productSpecificationRefEntity.atReferredType
        )
    }
}
