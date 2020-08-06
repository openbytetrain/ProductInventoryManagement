package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.web.api.model.Price
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PriceModelMapperTest {

    @Autowired
    private lateinit var priceModelMapper: PriceModelMapper

    @Test
    fun `Test toDto with PriceModelMapper`() {
        var price = priceModelMapper.toDto(generatePriceEntity())
        assertThat(price.percentage).isEqualTo(0.5.toFloat())
        assertThat(price.taxRate).isEqualTo(0.6.toFloat())
        assertThat(price.atBaseType).isEqualTo("String")
        assertThat(price.atType).isEqualTo("string")
    }

    @Test
    fun `Test toEntity with PriceModelMapper`() {
        var price = priceModelMapper.toEntity(generatePriceDto())
        assertThat(price.percentage).isEqualTo(0.5.toFloat())
        assertThat(price.taxRate).isEqualTo(0.6.toFloat())
        assertThat(price.atBaseType).isEqualTo("String")
        assertThat(price.atType).isEqualTo("string")
    }

    fun generatePriceEntity(): PriceEntity {
        return PriceEntity(
            percentage = 0.5.toFloat(),
            taxRate = 0.6.toFloat(),
            atBaseType = "String",
            atType = "string")
    }

    fun generatePriceDto(): Price {
        return Price(
            percentage = 0.5.toFloat(),
            taxRate = 0.6.toFloat(),
            atBaseType = "String",
            atType = "string")
    }
}
