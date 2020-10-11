package com.bytetrain.prodinv.domain.repository

import com.bytetrain.prodinv.domain.Product

interface ProductRepository {
    fun save(product: Product): Product
}
