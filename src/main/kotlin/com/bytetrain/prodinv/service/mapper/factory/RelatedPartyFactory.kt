package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.RelatedPartyEntity
import com.bytetrain.prodinv.web.api.model.RelatedParty
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class RelatedPartyFactory {
    @ObjectFactory
    fun relatedPartyToModelFactory(relatedParty: RelatedParty): RelatedPartyEntity {
        return RelatedPartyEntity(relatedParty.id, relatedParty.atReferredType)
    }

    @ObjectFactory
    fun modelToRelatedParty(relatedPartyEntity: RelatedPartyEntity): RelatedParty{
        return RelatedParty(relatedPartyEntity.id, relatedPartyEntity.atReferredType)
    }
}
