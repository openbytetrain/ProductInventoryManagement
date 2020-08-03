package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.BillingAccountRefEntity
import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BillingAccountRefModelTest {

    @Autowired
    private lateinit var billingAccountRefModelMapper: BillingAccountRefModelMapper

    @Test
    fun `test BillingAccount toDto mapping with RelatedPartyModelMapper`() {
        val billingAccountEntity = billingAccountRefModelMapper.toDto(generateBillingAccountEntity())
        Assertions.assertThat(billingAccountEntity.id == "1")
    }

    @Test
    fun `test BillingAccount toEntity mapping with RelatedPartyModelMapper`() {
        val billingAccountDto = billingAccountRefModelMapper.toEntity(generateBillingAccountDto())
        Assertions.assertThat(billingAccountDto.id == "1")
    }

    fun generateBillingAccountEntity(): BillingAccountRefEntity {
        return BillingAccountRefEntity(id = "2")
    }

    fun generateBillingAccountDto(): BillingAccountRef {
        return BillingAccountRef(id = "3")
    }
}
