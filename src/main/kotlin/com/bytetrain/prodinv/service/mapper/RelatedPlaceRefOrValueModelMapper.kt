package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedPlaceRefOrValueEntity
import com.bytetrain.prodinv.service.mapper.factory.RelatedPlaceRefOrValueFactory
import com.bytetrain.prodinv.web.api.model.RelatedPlaceRefOrValue
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [RelatedPlaceRefOrValueFactory::class])
interface RelatedPlaceRefOrValueModelMapper :
    EntityMapper<RelatedPlaceRefOrValue, RelatedPlaceRefOrValueEntity>
