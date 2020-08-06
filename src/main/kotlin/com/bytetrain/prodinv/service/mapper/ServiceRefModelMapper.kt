package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ServiceRefEntity
import com.bytetrain.prodinv.service.mapper.factory.ServiceRefFactory
import com.bytetrain.prodinv.web.api.model.ServiceRef
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", uses = [ServiceRefFactory::class])
interface ServiceRefModelMapper :
    EntityMapper<ServiceRef, ServiceRefEntity>
