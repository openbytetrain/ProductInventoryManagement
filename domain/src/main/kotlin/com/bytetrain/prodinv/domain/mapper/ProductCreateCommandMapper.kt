package com.bytetrain.prodinv.domain.mapper

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.domain.dto.ProductCreateCommand
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
    interface ProductCreateCommandMapper {

    fun toDomain(productCreateCommand: ProductCreateCommand): Product
}
