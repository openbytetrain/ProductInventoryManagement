package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.ServiceRefEntity
import com.bytetrain.prodinv.web.api.model.ServiceRef
import org.assertj.core.api.Assertions.assertThat
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
        assertThat(serviceSpecificationRef.id).isEqualTo(generateServiceRefEntity().id)
        assertThat(serviceSpecificationRef.href).isEqualTo("string2")
        assertThat(serviceSpecificationRef.name).isEqualTo("string3")
    }

    @Test
    fun `test serviceRefRefEntity creation with serviceRefModelMapper`() {
        var serviceRefEntity = serviceRefModelMapper.toEntity(generateServiceRefDto())
        assertThat(serviceRefEntity.id).isEqualTo(generateServiceRefDto().id)
        assertThat(serviceRefEntity.href).isEqualTo("string2")
        assertThat(serviceRefEntity.name).isEqualTo("string3")
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
