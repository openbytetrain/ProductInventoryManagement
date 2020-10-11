package com.bytetrain.prodinv.web.apidelegate.mapper.factory

import com.bytetrain.prodinv.domain.ProductPriceEntity
import com.bytetrain.prodinv.web.apidelegate.mapper.PriceModelMapper
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductPriceFactory(var priceModelMapper: PriceModelMapper) {

    @ObjectFactory
    fun productPriceToModelFactory(productPrice: com.bytetrain.prodinv.web.api.model.ProductPrice): ProductPriceEntity {
        return ProductPriceEntity(productPrice.priceType, priceModelMapper.toEntity(productPrice.price))
    }

    @ObjectFactory
    fun modelToProductPriceFactory(productPriceEntity: ProductPriceEntity): com.bytetrain.prodinv.web.api.model.ProductPrice {
        return com.bytetrain.prodinv.web.api.model.ProductPrice(productPriceEntity.priceType, priceModelMapper.toDto(productPriceEntity.priceEntity))
    }
}
