package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.MoneyEntity
import com.bytetrain.prodinv.web.api.model.Money
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class MoneyFactory {

    @ObjectFactory
    fun moneyToModelFactory(money: Money): MoneyEntity {
        return MoneyEntity(unit = money.unit, value = money.value)
    }

    @ObjectFactory
    fun modelToMoney(moneyEntity: MoneyEntity): Money {
        return Money(unit = moneyEntity.unit, value = moneyEntity.value)
    }
}
