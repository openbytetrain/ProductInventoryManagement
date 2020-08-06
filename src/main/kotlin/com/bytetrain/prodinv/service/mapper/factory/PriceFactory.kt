package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.service.mapper.MoneyModelMapper
import com.bytetrain.prodinv.web.api.model.Price
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class PriceFactory(var moneyModelMapper: MoneyModelMapper) {

    @ObjectFactory
    fun priceToModel(price: Price): PriceEntity {
        return PriceEntity(
            percentage = price.percentage,
            taxRate = price.taxRate,
            atBaseType = price.atBaseType,
            atType = price.atType,
            atSchemaLocation = price.atSchemaLocation

        )
    }

    @ObjectFactory
    fun modelToPrice(priceEntity: PriceEntity): Price {
        return Price(
            percentage = priceEntity.percentage,
            taxRate = priceEntity.taxRate,
            atBaseType = priceEntity.atBaseType,
            atType = priceEntity.atType,
            atSchemaLocation = priceEntity.atSchemaLocation
        )
    }
}
