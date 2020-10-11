package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.domain.dto.ProductCreateCommand
import com.bytetrain.prodinv.web.api.model.ProductCreateModel
import com.bytetrain.prodinv.web.apidelegate.mapper.factory.ProductCreateFactory
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [CharacteristicModelMapper::class, ProductPriceModelMapper::class, ProductCreateFactory::class])
abstract class ProductCreateModelMapper :
    EntityMapper<ProductCreateModel, ProductCreateCommand> {
}
