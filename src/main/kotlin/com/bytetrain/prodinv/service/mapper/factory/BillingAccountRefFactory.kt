package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.BillingAccountRefEntity
import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class BillingAccountRefFactory {

    @ObjectFactory
    fun billingAccountRefToModelFactory(billingAccountRef: BillingAccountRef): BillingAccountRefEntity {
        return BillingAccountRefEntity(
            id = billingAccountRef.id,
            href = billingAccountRef.href,
            name = billingAccountRef.name,
            atType = billingAccountRef.atType,
            atBaseType = billingAccountRef.atBaseType,
            atSchemaLocation = billingAccountRef.atSchemaLocation,
            atReferredType = billingAccountRef.atReferredType)
    }

    @ObjectFactory
    fun modelToBillingAccountRefFactory(billingAccountRefEntity: BillingAccountRefEntity): BillingAccountRef {
        return BillingAccountRef(
            id = billingAccountRefEntity.id,
            href = billingAccountRefEntity.href,
            name = billingAccountRefEntity.name,
            atType = billingAccountRefEntity.atType,
            atBaseType = billingAccountRefEntity.atBaseType,
            atSchemaLocation = billingAccountRefEntity.atSchemaLocation,
            atReferredType = billingAccountRefEntity.atReferredType)
    }
}
