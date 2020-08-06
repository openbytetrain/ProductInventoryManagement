package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.RelatedPlaceRefOrValueEntity
import com.bytetrain.prodinv.web.api.model.RelatedPlaceRefOrValue
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class RelatedPlaceRefOrValueFactory {

    @ObjectFactory
    fun relatedPlaceOrValueToModelFactory(relatedPlaceRefOrValue: RelatedPlaceRefOrValue): RelatedPlaceRefOrValueEntity {
        return RelatedPlaceRefOrValueEntity(
            role = relatedPlaceRefOrValue.role,
            id = relatedPlaceRefOrValue.id,
            href = relatedPlaceRefOrValue.href,
            name = relatedPlaceRefOrValue.name,
            atBaseType = relatedPlaceRefOrValue.atBaseType,
            atSchemaLocation = relatedPlaceRefOrValue.atSchemaLocation,
            atType = relatedPlaceRefOrValue.atType,
            atReferredType = relatedPlaceRefOrValue.atReferredType
        )
    }

    @ObjectFactory
    fun modelToRelatedPlaceOrValue(relatedPlaceRefOrValueEntity: RelatedPlaceRefOrValueEntity): RelatedPlaceRefOrValue {
        return RelatedPlaceRefOrValue(
            role = relatedPlaceRefOrValueEntity.role,
            id = relatedPlaceRefOrValueEntity.id,
            href = relatedPlaceRefOrValueEntity.href,
            name = relatedPlaceRefOrValueEntity.name,
            atBaseType = relatedPlaceRefOrValueEntity.atBaseType,
            atSchemaLocation = relatedPlaceRefOrValueEntity.atSchemaLocation,
            atType = relatedPlaceRefOrValueEntity.atType,
            atReferredType = relatedPlaceRefOrValueEntity.atReferredType
        )
    }
}
