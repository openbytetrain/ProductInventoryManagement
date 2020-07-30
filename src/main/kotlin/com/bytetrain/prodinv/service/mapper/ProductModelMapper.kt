package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class])
interface ProductModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Product, ProductEntity>
