package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductRefOrValueEntity
import com.bytetrain.prodinv.web.api.model.ProductRefOrValue
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class])
interface ProductRefOrValueModelMapper :
    EntityMapper<ProductRefOrValue, ProductRefOrValueEntity>
