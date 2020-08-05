package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ServiceRefEntity
import com.bytetrain.prodinv.web.api.model.ServiceRef
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ServiceRefModelMapperTest {

    @Autowired
    private lateinit var serviceRefModelMapper: ServiceRefModelMapper

    @Test
    fun `test serviceRefRef creation with ProductModelMapper`() {
        var serviceSpecificationRef = serviceRefModelMapper.toDto(generateServiceRefEntity())
        Assertions.assertThat(serviceSpecificationRef.id).isEqualTo("string1")
        Assertions.assertThat(serviceSpecificationRef.href).isEqualTo("string2")
        Assertions.assertThat(serviceSpecificationRef.name).isEqualTo("string3")
    }

    @Test
    fun `test serviceRefRefEntity creation with serviceRefModelMapper`() {
        var serviceRefEntity = serviceRefModelMapper.toEntity(generateServiceRefDto())
        Assertions.assertThat(serviceRefEntity.id).isEqualTo("string1")
        Assertions.assertThat(serviceRefEntity.href).isEqualTo("string2")
        Assertions.assertThat(serviceRefEntity.name).isEqualTo("string3")
    }

    private fun generateServiceRefEntity(): ServiceRefEntity {
        return ServiceRefEntity(
            id = "string1",
            href = "string2",
            name = "string3"

        )
    }

    private fun generateServiceRefDto(): ServiceRef {
        return ServiceRef(
            id = "string1",
            href = "string2",
            name = "string3"

        )
    }
}
