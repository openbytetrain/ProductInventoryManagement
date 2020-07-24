package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.web.api.model.ProductCreate
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class])
abstract class ProductCreateModelMapper :
    EntityMapper<ProductCreate, Product> {

    abstract override fun toEntity(dto: ProductCreate): Product

    override fun toDto(entity: Product): ProductCreate {
        TODO("Not yet implemented")
    }

    override fun toDto(entityList: MutableList<Product>): MutableList<ProductCreate> {
        TODO("Not yet implemented")
    }

    fun fromId(id: String?) = id?.let {
        val product = Product()
        product.id = id
        product
    }
}
