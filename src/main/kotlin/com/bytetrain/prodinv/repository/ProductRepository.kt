package com.bytetrain.prodinv.repository

import com.bytetrain.prodinv.domain.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Spring Data MongoDB repository for the [Product] entity.
 */
@Suppress("unused")
@Repository
interface ProductRepository : MongoRepository<Product, String>
