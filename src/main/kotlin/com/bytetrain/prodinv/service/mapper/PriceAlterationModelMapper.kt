package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Price
import com.bytetrain.prodinv.web.api.model.PriceAlteration
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface PriceAlterationModelMapper:
    EntityMapper<PriceAlteration, Price>
