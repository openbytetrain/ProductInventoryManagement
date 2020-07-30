package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.CharacteristicEntity
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
        val characteristicEntity = characteristicModelMapper.toDto(generateCharacteristic())
        Assertions.assertThat(characteristicEntity.name == "characteristic")
        Assertions.assertThat(characteristicEntity.value == "Any")
        Assertions.assertThat(characteristicEntity.valueType == "null")
        Assertions.assertThat(characteristicEntity.atBaseType == "null")
        Assertions.assertThat(characteristicEntity.atType == "String")
    }

    private fun generateCharacteristic(): CharacteristicEntity {

        return CharacteristicEntity("characteristic",
            "Any",
            "null",
            "null",
            null,
            "String")
    }
}
