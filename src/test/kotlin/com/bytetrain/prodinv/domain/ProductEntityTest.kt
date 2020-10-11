package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.utils.equalsVerifier
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductEntityTest {

    @Test
    fun equalsVerifier() {
        equalsVerifier(ProductEntity::class)
        val product1 = ProductEntity()
        product1.id = "id1"
        val product2 = ProductEntity()
        product2.id = product1.id
        assertThat(product1).isEqualTo(product2)
        product2.id = "id2"
        assertThat(product1).isNotEqualTo(product2)
        product1.id = null
        assertThat(product1).isNotEqualTo(product2)
    }
}
