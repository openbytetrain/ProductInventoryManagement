package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductTermEntity
import com.bytetrain.prodinv.web.api.model.ProductTerm
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductTermFactory {

    @ObjectFactory
    fun productTermToModel(productTerm: ProductTerm): ProductTermEntity {
        return ProductTermEntity(
            description = productTerm.description,
            name = productTerm.name,
            duration = productTerm.duration,
            validFor = productTerm.validFor,
            atBaseType = productTerm.atBaseType,
            atSchemaLocation = productTerm.atSchemaLocation,
            atType = productTerm.atType
        )
    }

    @ObjectFactory
    fun modelToProductTerm(productTermEntity: ProductTermEntity): ProductTerm {
        return ProductTerm(
            description = productTermEntity.description,
            name = productTermEntity.name,
            duration = productTermEntity.duration,
            validFor = productTermEntity.validFor,
            atBaseType = productTermEntity.atBaseType,
            atSchemaLocation = productTermEntity.atSchemaLocation,
            atType = productTermEntity.atType
        )
    }
}
