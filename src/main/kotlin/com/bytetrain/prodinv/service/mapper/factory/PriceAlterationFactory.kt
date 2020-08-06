package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.service.mapper.PriceModelMapper
import com.bytetrain.prodinv.web.api.model.PriceAlteration
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class PriceAlterationFactory(var priceModelMapper: PriceModelMapper) {

    @ObjectFactory
    fun priceAlterationToModelFactory(priceAlteration: PriceAlteration): com.bytetrain.prodinv.domain.PriceAlterationEntity {
        return com.bytetrain.prodinv.domain.PriceAlterationEntity(
            description = priceAlteration.description,
            priceType = priceAlteration.priceType,
            priceEntity = priceModelMapper.toEntity(priceAlteration.price),
            applicationDuration = priceAlteration.applicationDuration,
            name = priceAlteration.name,
            priority = priceAlteration.priority,
            recurringChargePeriod = priceAlteration.recurringChargePeriod,
            unitOfMeasure = priceAlteration.unitOfMeasure,
            productOfferingPrice = priceAlteration.productOfferingPrice,
            atBaseType = priceAlteration.atBaseType,
            atSchemaLocation = priceAlteration.atSchemaLocation,
            atType = priceAlteration.atType
        )
    }

    @ObjectFactory
    fun priceAlterationModelToPriceAlterationFactory(priceAlterationEntity: com.bytetrain.prodinv.domain.PriceAlterationEntity):
        PriceAlteration {
        return PriceAlteration(
            priceType = priceAlterationEntity.priceType,
            price = priceModelMapper.toDto(priceAlterationEntity.priceEntity),
            description = priceAlterationEntity.description,
            applicationDuration = priceAlterationEntity.applicationDuration,
            name = priceAlterationEntity.name,
            priority = priceAlterationEntity.priority,
            recurringChargePeriod = priceAlterationEntity.recurringChargePeriod,
            unitOfMeasure = priceAlterationEntity.unitOfMeasure,
            productOfferingPrice = priceAlterationEntity.productOfferingPrice,
            atBaseType = priceAlterationEntity.atBaseType,
            atSchemaLocation = priceAlterationEntity.atSchemaLocation,
            atType = priceAlterationEntity.atType
        )
    }
}
