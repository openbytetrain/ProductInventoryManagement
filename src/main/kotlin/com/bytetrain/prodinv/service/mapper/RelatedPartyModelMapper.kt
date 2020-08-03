package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedPartyEntity
import com.bytetrain.prodinv.service.mapper.factory.RelatedPartyFactory
import com.bytetrain.prodinv.web.api.model.RelatedParty
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [RelatedPartyFactory::class])
interface RelatedPartyModelMapper :
    EntityMapper<RelatedParty, RelatedPartyEntity>
