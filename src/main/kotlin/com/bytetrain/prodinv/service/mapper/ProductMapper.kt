package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.service.dto.ProductDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [ProductEntity] and its DTO [ProductDTO].
 */
@Mapper(componentModel = "spring", uses = [])
interface ProductMapper :
    EntityMapper<ProductDTO, ProductEntity> {

    override fun toEntity(productDTO: ProductDTO): ProductEntity

    @JvmDefault
    fun fromId(id: String?) = id?.let {
        val product = ProductEntity()
        product.id = id
        product
    }
}
