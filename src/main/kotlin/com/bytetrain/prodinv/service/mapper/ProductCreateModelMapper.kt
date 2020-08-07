package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.service.mapper.factory.ProductCreateFactory
import com.bytetrain.prodinv.web.api.model.ProductCreate
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class, ProductCreateFactory::class, RelatedProductOrderItemModelMapper::class])
abstract class ProductCreateModelMapper :
    EntityMapper<ProductCreate, ProductEntity> {

    fun fromId(id: String?) = id?.let {
        val product = ProductEntity()
        product.id = id
        product
    }
}
