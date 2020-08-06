package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.PriceAlterationEntity
import com.bytetrain.prodinv.domain.PriceEntity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PriceAlterationModelMapperTest {

    @Autowired
    private lateinit var priceAlterationModelMapper: PriceAlterationModelMapper

    @Test
    fun `Test toDto with PriceAlterationModelMapper`() {
        var priceAlteration = priceAlterationModelMapper.toDto(generatePriceAlterationEntity())
        Assertions.assertThat(priceAlteration.priceType).isEqualTo("priceType")
        Assertions.assertThat(priceAlteration.price.atBaseType).isEqualTo("String")
        Assertions.assertThat(priceAlteration.applicationDuration).isEqualTo(1)
        Assertions.assertThat(priceAlteration.description).isEqualTo("description")
        Assertions.assertThat(priceAlteration.name).isEqualTo("name")
        Assertions.assertThat(priceAlteration.priority).isEqualTo(6)
        Assertions.assertThat(priceAlteration.recurringChargePeriod).isEqualTo("recurringChargePeriod")
        Assertions.assertThat(priceAlteration.unitOfMeasure).isEqualTo("unitOfMeasure")
        Assertions.assertThat(priceAlteration.atBaseType).isEqualTo("atBaseType")
        Assertions.assertThat(priceAlteration.atType).isEqualTo("atType")
    }

    private fun generatePriceAlterationEntity(): PriceAlterationEntity {
        return PriceAlterationEntity(
            priceType = "priceType",
            priceEntity = PriceEntity(atBaseType = "String"),
            applicationDuration = 1,
            description = "description",
            name = "name",
            priority = 6,
            recurringChargePeriod = "recurringChargePeriod",
            unitOfMeasure = "unitOfMeasure",
            atBaseType = "atBaseType",
            atType = "atType"
        )
    }
}
