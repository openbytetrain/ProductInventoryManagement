package com.bytetrain.prodinv.service.mapper.factory

import com.bytetrain.prodinv.web.api.model.Characteristic
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class CharacteristicFactory {

    @ObjectFactory
    fun characteristicToModelFactory(characteristic: Characteristic): com.bytetrain.prodinv.domain.CharacteristicEntity {
        return com.bytetrain.prodinv.domain.CharacteristicEntity(characteristic.name, characteristic.value)
    }
    @ObjectFactory
    fun modelToCharacteristicFactory(characteristicEntity: com.bytetrain.prodinv.domain.CharacteristicEntity): Characteristic {
        return Characteristic(characteristicEntity.name, characteristicEntity.value)
    }
}
