package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.web.api.model.Characteristic
import org.mapstruct.ObjectFactory
import org.springframework.stereotype.Component

@Component
class CharacteristicFactory {

    @ObjectFactory
    fun characteristicToModelFactory(characteristic: Characteristic): com.bytetrain.prodinv.domain.Characteristic {
        return com.bytetrain.prodinv.domain.Characteristic(characteristic.name, characteristic.value)
    }
    @ObjectFactory
    fun modelToCharacteristicFactory(characteristic: com.bytetrain.prodinv.domain.Characteristic): Characteristic {
        return Characteristic(characteristic.name, characteristic.value)
    }
}
