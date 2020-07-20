package com.bytetrain.prodinv.service.dto

import com.bytetrain.prodinv.web.rest.equalsVerifier
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductDTOTest {

    @Test
    fun dtoEqualsVerifier() {
        equalsVerifier(ProductDTO::class)
        val productDTO1 = ProductDTO()
        productDTO1.id = "id1"
        val productDTO2 = ProductDTO()
        assertThat(productDTO1).isNotEqualTo(productDTO2)
        productDTO2.id = productDTO1.id
        assertThat(productDTO1).isEqualTo(productDTO2)
        productDTO2.id = "id2"
        assertThat(productDTO1).isNotEqualTo(productDTO2)
        productDTO1.id = null
        assertThat(productDTO1).isNotEqualTo(productDTO2)
    }
}
