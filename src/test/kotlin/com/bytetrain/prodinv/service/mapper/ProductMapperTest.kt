package com.bytetrain.prodinv.service.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductMapperTest {

    private lateinit var productMapper: ProductMapper

    @BeforeEach
    fun setUp() {
        productMapper = ProductMapperImpl()
    }

    @Test
    fun testEntityFromId() {
        val id = "id1"
        assertThat(productMapper.fromId(id)?.id).isEqualTo(id)
        assertThat(productMapper.fromId(null)).isNull()
    }
}
