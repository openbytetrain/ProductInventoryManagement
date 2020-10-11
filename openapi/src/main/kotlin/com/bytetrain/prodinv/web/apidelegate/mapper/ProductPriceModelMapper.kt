package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.service.mapper.factory.ProductPriceFactory
import com.bytetrain.prodinv.web.api.model.ProductPrice
import com.bytetrain.prodinv.web.apidelegate.mapper.factory.ProductPriceFactory
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [PriceAlterationModelMapper::class, ProductPriceFactory::class, PriceModelMapper::class])
interface ProductPriceModelMapper :
        EntityMapper<ProductPrice, com.bytetrain.prodinv.domain.ProductPriceEntity>
