package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface ProductModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Product, Product>
