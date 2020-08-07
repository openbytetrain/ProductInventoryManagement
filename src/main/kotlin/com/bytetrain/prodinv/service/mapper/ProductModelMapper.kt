package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.web.api.model.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class, RelatedProductOrderItemModelMapper::class])
interface ProductModelMapper :
    EntityMapper<Product, ProductEntity>
