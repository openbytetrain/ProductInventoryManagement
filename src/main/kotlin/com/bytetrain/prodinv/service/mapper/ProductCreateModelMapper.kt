package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.web.api.model.ProductCreate
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class])
abstract class ProductCreateModelMapper :
    EntityMapper<ProductCreate, ProductEntity> {

    abstract override fun toEntity(dto: ProductCreate): ProductEntity

    override fun toDto(entity: ProductEntity): ProductCreate {
        TODO("Not yet implemented")
    }

    override fun toDto(entityList: MutableList<ProductEntity>): MutableList<ProductCreate> {
        TODO("Not yet implemented")
    }

    fun fromId(id: String?) = id?.let {
        val product = ProductEntity()
        product.id = id
        product
    }
}
