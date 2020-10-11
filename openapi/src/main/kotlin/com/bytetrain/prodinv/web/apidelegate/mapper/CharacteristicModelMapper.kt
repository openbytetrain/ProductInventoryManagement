package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.web.api.model.CharacteristicModel
import com.bytetrain.prodinv.web.apidelegate.mapper.factory.CharacteristicFactory
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicFactory::class])
interface CharacteristicModelMapper :
    EntityMapper<CharacteristicModel, CharacteristicEntity>
