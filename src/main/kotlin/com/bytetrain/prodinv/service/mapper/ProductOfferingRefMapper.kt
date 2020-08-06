package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ProductOfferingRefEntity
import com.bytetrain.prodinv.service.mapper.factory.ProductOfferingRefFactory
import com.bytetrain.prodinv.web.api.model.ProductOfferingRef
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [ProductOfferingRefFactory::class])
interface ProductOfferingRefMapper :
    EntityMapper<ProductOfferingRef, ProductOfferingRefEntity>
