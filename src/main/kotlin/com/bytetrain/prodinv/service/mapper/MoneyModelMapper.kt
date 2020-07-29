package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.api.model.Money
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [])
interface MoneyModelMapper :
    EntityMapper<Money, com.bytetrain.prodinv.domain.Money>
