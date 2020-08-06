package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.MoneyEntity
import com.bytetrain.prodinv.service.mapper.factory.MoneyFactory
import com.bytetrain.prodinv.web.api.model.Money
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [MoneyFactory::class])
interface MoneyModelMapper :
    EntityMapper<Money, MoneyEntity>
