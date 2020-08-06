package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.BillingAccountRefEntity
import com.bytetrain.prodinv.service.mapper.factory.BillingAccountRefFactory
import com.bytetrain.prodinv.web.api.model.BillingAccountRef
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [BillingAccountRefFactory::class])
interface BillingAccountRefModelMapper :
    EntityMapper<BillingAccountRef, BillingAccountRefEntity>
