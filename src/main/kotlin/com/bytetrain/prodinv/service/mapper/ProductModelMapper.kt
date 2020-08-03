package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.web.api.model.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [
    CharacteristicModelMapper::class,
    ProductPriceModelMapper::class,
    RelatedPartyMapper::class])
interface ProductModelMapper :
    EntityMapper<Product, ProductEntity>
