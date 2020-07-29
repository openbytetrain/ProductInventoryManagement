package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.service.mapper.PriceModelMapper
import com.bytetrain.prodinv.web.api.model.PriceAlteration
import org.mapstruct.ObjectFactory

class PriceAlterationFactory {

    lateinit var priceModelMapper: PriceModelMapper

    @ObjectFactory
    fun priceAlterationToModelFactory(priceAlteration: PriceAlteration): com.bytetrain.prodinv.domain.PriceAlteration {
        return com.bytetrain.prodinv.domain.PriceAlteration(priceAlteration.priceType, priceModelMapper.toEntity(priceAlteration.price))
    }

    @ObjectFactory
    fun priceAlterationModelToPriceAlterationFactory(priceAlteration: com.bytetrain.prodinv.domain.PriceAlteration):
        PriceAlteration {
        return PriceAlteration(priceAlteration.priceType, priceModelMapper.toDto(priceAlteration.price))
    }
}
