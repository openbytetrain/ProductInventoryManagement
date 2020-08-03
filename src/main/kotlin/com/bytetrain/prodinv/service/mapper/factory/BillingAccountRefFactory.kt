package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.BillingAccountRefEntity
import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class BillingAccountRefFactory {

    @ObjectFactory
    fun billingAccountRefToModelFactory(billingAccountRef: BillingAccountRef): BillingAccountRefEntity {
        return BillingAccountRefEntity(billingAccountRef.id)
    }

    @ObjectFactory
    fun modelToBillingAccountRefFactory(billingAccountRefEntity: BillingAccountRefEntity): BillingAccountRef {
        return BillingAccountRef(billingAccountRefEntity.id)
    }
}
