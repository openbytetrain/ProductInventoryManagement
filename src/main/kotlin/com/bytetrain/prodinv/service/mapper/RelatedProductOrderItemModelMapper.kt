package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedProductOrderItemEntity
import com.bytetrain.prodinv.service.mapper.factory.RelatedProductOrderItemFactory
import com.bytetrain.prodinv.web.api.model.RelatedProductOrderItem
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [RelatedProductOrderItemFactory::class])
interface RelatedProductOrderItemModelMapper :
    EntityMapper<RelatedProductOrderItem, RelatedProductOrderItemEntity>
