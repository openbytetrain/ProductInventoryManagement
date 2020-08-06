package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductTermEntity
import com.bytetrain.prodinv.service.mapper.factory.ProductTermFactory
import com.bytetrain.prodinv.web.api.model.ProductTerm
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [ProductTermFactory::class])
interface ProductTermModelMapper :
    EntityMapper<ProductTerm, ProductTermEntity>
