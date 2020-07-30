package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.service.mapper.PriceModelMapper
import com.bytetrain.prodinv.web.api.model.PriceAlteration
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class PriceAlterationFactory(var priceModelMapper: PriceModelMapper) {

    @ObjectFactory
    fun priceAlterationToModelFactory(priceAlteration: PriceAlteration): com.bytetrain.prodinv.domain.PriceAlterationEntity {
        return com.bytetrain.prodinv.domain.PriceAlterationEntity(priceAlteration.priceType, priceModelMapper.toEntity(priceAlteration.price))
    }

    @ObjectFactory
    fun priceAlterationModelToPriceAlterationFactory(priceAlterationEntity: com.bytetrain.prodinv.domain.PriceAlterationEntity):
        PriceAlteration {
        return PriceAlteration(priceAlterationEntity.priceType, priceModelMapper.toDto(priceAlterationEntity.priceEntity))
    }
}
