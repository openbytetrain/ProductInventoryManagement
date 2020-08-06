package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.BillingAccountRefEntity
import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BillingAccountRefModelTest {

    @Autowired
    private lateinit var billingAccountRefModelMapper: BillingAccountRefModelMapper

    @Test
    fun `test BillingAccount toDto mapping with RelatedPartyModelMapper`() {
        val billingAccountRef = billingAccountRefModelMapper.toDto(generateBillingAccountEntity())
        assertThat(billingAccountRef.id).isEqualTo(generateBillingAccountEntity().id)
        assertThat(billingAccountRef.href).isEqualTo("string")
        assertThat(billingAccountRef.name).isEqualTo("string")
        assertThat(billingAccountRef.atBaseType).isEqualTo("string")
        assertThat(billingAccountRef.atType).isEqualTo("string")
        assertThat(billingAccountRef.atReferredType).isEqualTo("string")
    }

    @Test
    fun `test BillingAccount toEntity mapping with RelatedPartyModelMapper`() {
        val billingAccountRef = billingAccountRefModelMapper.toEntity(generateBillingAccountDto())
        assertThat(billingAccountRef.id).isEqualTo(generateBillingAccountDto().id)
        assertThat(billingAccountRef.href).isEqualTo("string")
        assertThat(billingAccountRef.name).isEqualTo("string")
        assertThat(billingAccountRef.atBaseType).isEqualTo("string")
        assertThat(billingAccountRef.atType).isEqualTo("string")
        assertThat(billingAccountRef.atReferredType).isEqualTo("string")
    }

    fun generateBillingAccountEntity(): BillingAccountRefEntity {
        return BillingAccountRefEntity(
            id = "2",
            href = "string",
            name = "string",
            atType = "string",
            atBaseType = "string",
            atReferredType = "string")
    }

    fun generateBillingAccountDto(): BillingAccountRef {
        return BillingAccountRef(
            id = "3",
            href = "string",
            name = "string",
            atType = "string",
            atBaseType = "string",
            atReferredType = "string"
        )
    }
}
