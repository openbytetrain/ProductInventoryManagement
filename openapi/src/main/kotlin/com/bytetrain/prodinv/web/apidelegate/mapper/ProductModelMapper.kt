package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.web.api.model.ProductModel
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class])
interface ProductModelMapper :
        EntityMapper<ProductModel, Product>
