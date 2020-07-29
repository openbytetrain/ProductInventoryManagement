package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class])
interface ProductModelMapper :
    EntityMapper<com.bytetrain.prodinv.web.api.model.Product, Product> {

    // fun characteristicToModelCharacteristic(characteristic: Characteristic): com.bytetrain.prodinv.domain.Characteristic?
}
