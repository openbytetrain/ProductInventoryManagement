package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.Characteristic
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CharacteristicModelMapperTest {

    @Autowired
    private lateinit var characteristicModelMapper: CharacteristicModelMapper

    @Test
    fun `test Characteristic Model mapping with CharacteristicModelMapper`() {
        val characteristic = characteristicModelMapper.toDto(generateCharacteristic())
        Assertions.assertThat(characteristic.name == "characteristic")
        Assertions.assertThat(characteristic.value == "Any")
        Assertions.assertThat(characteristic.valueType == "null")
        Assertions.assertThat(characteristic.atBaseType == "null")
        Assertions.assertThat(characteristic.atType == "String")
    }

    private fun generateCharacteristic(): Characteristic {

        return Characteristic("characteristic",
            "Any",
            "null",
            "null",
            null,
            "String")
    }
}
