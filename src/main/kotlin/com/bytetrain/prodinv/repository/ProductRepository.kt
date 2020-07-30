package com.bytetrain.prodinv.repository

import com.bytetrain.prodinv.domain.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Spring Data MongoDB repository for the [ProductEntity] entity.
 */
@Suppress("unused")
@Repository
interface ProductRepository : MongoRepository<ProductEntity, String>
