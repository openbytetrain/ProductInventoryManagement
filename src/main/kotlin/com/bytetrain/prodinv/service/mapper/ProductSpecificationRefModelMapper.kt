package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductSpecificationRefEntity
import com.bytetrain.prodinv.service.mapper.factory.ProductSpecificationRefFactory
import com.bytetrain.prodinv.web.api.model.ProductSpecificationRef
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [ProductSpecificationRefFactory::class])
interface ProductSpecificationRefModelMapper :
    EntityMapper<ProductSpecificationRef, ProductSpecificationRefEntity>
