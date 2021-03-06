package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.PriceEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [MoneyModelMapper::class])
interface PriceModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Price, PriceEntity>
