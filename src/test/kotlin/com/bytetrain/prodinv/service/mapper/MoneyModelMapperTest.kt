package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.MoneyEntity
import com.bytetrain.prodinv.web.api.model.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MoneyModelMapperTest {

    private lateinit var moneyModelMapper: MoneyModelMapper

    @BeforeEach
    fun setup() {
        moneyModelMapper = MoneyModelMapperImpl()
    }

    @Test
    fun `test toDto with MoneyModelMapper`() {
        val money = moneyModelMapper.toDto(generateMoneyEntity())
        Assertions.assertThat(money.unit == "euro")
        Assertions.assertThat(money.value == 0.3.toFloat())
    }

    @Test
    fun `test toEntity with MoneyModelMapper`() {
        val money = moneyModelMapper.toEntity(generateMoneyModel())
        Assertions.assertThat(money.unit == "dollar")
        Assertions.assertThat(money.value == 0.5.toFloat())
    }

    private fun generateMoneyEntity(): MoneyEntity {
        return MoneyEntity("euro", 0.3.toFloat())
    }

    private fun generateMoneyModel(): Money {
        return Money("dollar", 0.5.toFloat())
    }
}
