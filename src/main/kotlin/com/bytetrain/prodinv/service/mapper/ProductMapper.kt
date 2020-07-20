package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.service.dto.ProductDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [Product] and its DTO [ProductDTO].
 */
@Mapper(componentModel = "spring", uses = [])
interface ProductMapper :
    EntityMapper<ProductDTO, Product> {

    override fun toEntity(productDTO: ProductDTO): Product

    @JvmDefault
    fun fromId(id: String?) = id?.let {
        val product = Product()
        product.id = id
        product
    }
}
