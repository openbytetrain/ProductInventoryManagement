package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.service.mapper.factory.PriceFactory
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [MoneyModelMapper::class, PriceFactory::class])
interface PriceModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Price, PriceEntity>
