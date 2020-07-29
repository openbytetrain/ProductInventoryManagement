package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.api.model.ProductPrice
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [PriceModelMapper::class])
interface ProductPriceModelMapper :
    EntityMapper<ProductPrice, com.bytetrain.prodinv.domain.ProductPrice>
