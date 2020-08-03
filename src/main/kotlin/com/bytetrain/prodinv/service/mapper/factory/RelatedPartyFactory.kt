package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.RelatedPartyEntity
import com.bytetrain.prodinv.web.api.model.RelatedParty
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class RelatedPartyFactory {
    @ObjectFactory
    fun relatedPartyToModelFactory(relatedParty: RelatedParty): RelatedPartyEntity {
        return RelatedPartyEntity(
            id = relatedParty.id,
            atReferredType = relatedParty.atReferredType,
            href = relatedParty.href,
            name = relatedParty.name,
            role = relatedParty.atBaseType,
            atSchemaLocation = relatedParty.atSchemaLocation,
            atType = relatedParty.atType)
    }

    @ObjectFactory
    fun modelToRelatedParty(relatedPartyEntity: RelatedPartyEntity): RelatedParty {
        return RelatedParty(
            id = relatedPartyEntity.id,
            atReferredType = relatedPartyEntity.atReferredType,
            href = relatedPartyEntity.href,
            name = relatedPartyEntity.name,
            role = relatedPartyEntity.atBaseType,
            atSchemaLocation = relatedPartyEntity.atSchemaLocation,
            atType = relatedPartyEntity.atType)
    }
}
