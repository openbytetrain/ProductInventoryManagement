package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ProductPrice
import com.bytetrain.prodinv.service.mapper.PriceModelMapper
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ProductPriceFactory {

    lateinit var priceModelMapper: PriceModelMapper

    @ObjectFactory
    fun productPriceToModelFactory(productPrice: com.bytetrain.prodinv.web.api.model.ProductPrice): ProductPrice {
        return ProductPrice(productPrice.priceType, priceModelMapper.toEntity(productPrice.price))
    }
    @ObjectFactory
    fun modelToProductPriceFactory(productPrice: ProductPrice): com.bytetrain.prodinv.web.api.model.ProductPrice {
        return com.bytetrain.prodinv.web.api.model.ProductPrice(productPrice.priceType, priceModelMapper.toDto(productPrice.price))
    }
}
