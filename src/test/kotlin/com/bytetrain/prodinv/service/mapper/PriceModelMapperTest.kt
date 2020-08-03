package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.MoneyEntity
import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.web.api.model.Money
import com.bytetrain.prodinv.web.api.model.Price
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PriceModelMapperTest {

    private var moneyEntity = MoneyEntity("null", null)
    private var money = Money("null", null)

    @Autowired
    private lateinit var priceModelMapper: PriceModelMapper

    @Test
    fun `Test toDto with PriceModelMapper`() {
        var price = priceModelMapper.toDto(generatePriceEntity())
        Assertions.assertThat(price.percentage == 0.5.toFloat())
        Assertions.assertThat(price.taxRate == 0.6.toFloat())
        Assertions.assertThat(price.dutyFreeAmount?.unit == "null")
        Assertions.assertThat(price.taxIncludedAmount?.unit == "null")
        Assertions.assertThat(price.atBaseType == "String")
        Assertions.assertThat(price.atType == "string")
    }

    @Test
    fun `Test toEntity with PriceModelMapper`() {
        var price = priceModelMapper.toEntity(generatePriceDto())
        Assertions.assertThat(price.percentage == 0.5.toFloat())
        Assertions.assertThat(price.taxRate == 0.6.toFloat())
        Assertions.assertThat(price.dutyFreeAmount?.unit == "null")
        Assertions.assertThat(price.taxIncludedAmount?.unit == "null")
        Assertions.assertThat(price.atBaseType == "String")
        Assertions.assertThat(price.atType == "string")
    }

    fun generatePriceEntity(): PriceEntity {
        return PriceEntity(
            percentage = 0.5.toFloat(),
            taxRate = 0.6.toFloat(),
            dutyFreeAmount = moneyEntity,
            taxIncludedAmount = moneyEntity,
            atBaseType = "String",
            atType = "string")
    }

    fun generatePriceDto(): Price {
        return Price(
            percentage = 0.5.toFloat(),
            taxRate = 0.6.toFloat(),
            dutyFreeAmount = money,
            taxIncludedAmount = money,
            atBaseType = "String",
            atType = "string")
    }
}
