package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.service.mapper.factory.PriceAlterationFactory
import com.bytetrain.prodinv.web.api.model.PriceAlteration
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [PriceAlterationFactory::class, PriceModelMapper::class])
interface PriceAlterationModelMapper :
        EntityMapper<PriceAlteration, com.bytetrain.prodinv.domain.PriceAlterationEntity>
