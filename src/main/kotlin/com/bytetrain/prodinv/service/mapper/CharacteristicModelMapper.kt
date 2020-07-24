package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.api.model.Characteristic
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface CharacteristicModelMapper : EntityMapper<Characteristic, com.bytetrain.prodinv.domain.Characteristic>
