package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.MoneyEntity
import com.bytetrain.prodinv.web.api.model.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MoneyModelMapperTest {

    @Autowired
    private lateinit var moneyModelMapper: MoneyModelMapper

    @Test
    fun `test toDto with MoneyModelMapper`() {
        val money = moneyModelMapper.toDto(generateMoneyEntity())
        assertThat(money.unit).isEqualTo("euro")
        assertThat(money.value).isEqualTo(0.3.toFloat())
    }

    @Test
    fun `test toEntity with MoneyModelMapper`() {
        val money = moneyModelMapper.toEntity(generateMoneyModel())
        assertThat(money.unit).isEqualTo("dollar")
        assertThat(money.value).isEqualTo(0.5.toFloat())
    }

    private fun generateMoneyEntity(): MoneyEntity {
        return MoneyEntity("euro", 0.3.toFloat())
    }

    private fun generateMoneyModel(): Money {
        return Money("dollar", 0.5.toFloat())
    }
}
