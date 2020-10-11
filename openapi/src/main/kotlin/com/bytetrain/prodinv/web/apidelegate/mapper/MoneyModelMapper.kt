package com.bytetrain.prodinv.web.apidelegate.mapper

import com.bytetrain.prodinv.web.api.model.Money
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface MoneyModelMapper :
        EntityMapper<Money, com.bytetrain.prodinv.domain.MoneyEntity>
