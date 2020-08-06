package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.domain.CharacteristicEntity
import com.bytetrain.prodinv.web.api.model.Characteristic
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class CharacteristicFactory {

    @ObjectFactory
    fun characteristicToModelFactory(characteristic: Characteristic): CharacteristicEntity {
        return CharacteristicEntity(
            name = characteristic.name,
            value = characteristic.value,
            valueType = characteristic.valueType,
            atBaseType = characteristic.atBaseType,
            atSchemaLocation = characteristic.atSchemaLocation,
            atType = characteristic.atType)
    }

    @ObjectFactory
    fun modelToCharacteristicFactory(characteristicEntity: CharacteristicEntity): Characteristic {
        return Characteristic(
            name = characteristicEntity.name,
            value = characteristicEntity.value,
            valueType = characteristicEntity.valueType,
            atBaseType = characteristicEntity.atBaseType,
            atSchemaLocation = characteristicEntity.atSchemaLocation,
            atType = characteristicEntity.atType)
    }
}
