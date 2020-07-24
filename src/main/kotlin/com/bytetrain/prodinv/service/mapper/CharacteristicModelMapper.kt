package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Characteristic
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicFactory::class])
interface CharacteristicModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Characteristic, Characteristic>
