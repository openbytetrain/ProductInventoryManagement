package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.CharacteristicEntity
import com.bytetrain.prodinv.service.mapper.factory.CharacteristicFactory
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicFactory::class])
interface CharacteristicModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Characteristic, CharacteristicEntity>
