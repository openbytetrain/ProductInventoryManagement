package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.ServiceRefEntity
import com.bytetrain.prodinv.web.api.model.ServiceRef
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class ServiceRefFactory {

    @ObjectFactory
    fun serviceRefToModel(serviceRef: ServiceRef): ServiceRefEntity {
        return ServiceRefEntity(
            id = serviceRef.id,
            href = serviceRef.href,
            name = serviceRef.name,
            atBaseType = serviceRef.atBaseType,
            atSchemaLocation = serviceRef.atSchemaLocation,
            atType = serviceRef.atType,
            atReferredType = serviceRef.atType
        )
    }

    @ObjectFactory
    fun modelToServiceRef(serviceRefEntity: ServiceRefEntity): ServiceRef {
        return ServiceRef(
            id = serviceRefEntity.id,
            href = serviceRefEntity.href,
            name = serviceRefEntity.name,
            atBaseType = serviceRefEntity.atBaseType,
            atSchemaLocation = serviceRefEntity.atSchemaLocation,
            atType = serviceRefEntity.atType,
            atReferredType = serviceRefEntity.atType
        )
    }
}
