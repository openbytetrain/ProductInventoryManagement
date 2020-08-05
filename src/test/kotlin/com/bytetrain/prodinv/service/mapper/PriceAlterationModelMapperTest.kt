package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.PriceAlterationEntity
import com.bytetrain.prodinv.domain.PriceEntity
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.net.URI

@SpringBootTest
class PriceAlterationModelMapperTest {

    private var priceEntity = PriceEntity(
        null,
        null,
        null,
        null,
        null,
        null,
        null)

    @Autowired
    private lateinit var priceAlterationModelMapper: PriceAlterationModelMapper

    @Test
    fun `Test toDto with PriceAlterationModelMapper`() {
        var priceAlteration = priceAlterationModelMapper.toDto(generatePriceAlterationEntity())
        org.assertj.core.api.Assertions.assertThat(priceAlteration.priceType == "priceType")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.priceEntity)
        org.assertj.core.api.Assertions.assertThat(priceAlteration.applicationDuration == 0.5.toInt())
        org.assertj.core.api.Assertions.assertThat(priceAlteration.description == "description")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.name == "name")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.priority == 0.6.toInt())
        org.assertj.core.api.Assertions.assertThat(priceAlteration.recurringChargePeriod == "recurringChargePeriod")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.unitOfMeasure == "unitOfMeasure")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.productOfferingPrice == null)
        org.assertj.core.api.Assertions.assertThat(priceAlteration.atBaseType == "atBaseType")
        org.assertj.core.api.Assertions.assertThat(priceAlteration.atSchemaLocation == null)
        org.assertj.core.api.Assertions.assertThat(priceAlteration.atType == "atType")
    }

    private fun generatePriceAlterationEntity(): PriceAlterationEntity {
        return PriceAlterationEntity(
            priceType = "priceType",
            priceEntity = priceEntity,
            applicationDuration = 0.5.toInt(),
            description = "description",
            name = "name",
            priority = 0.6.toInt(),
            recurringChargePeriod = "recurringChargePeriod",
            unitOfMeasure = "unitOfMeasure",
            productOfferingPrice = null,
            atBaseType = "atBaseType",
            atSchemaLocation = null,
            atType = "atType"
        )
    }
}
