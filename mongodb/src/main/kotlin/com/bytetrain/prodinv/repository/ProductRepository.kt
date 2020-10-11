package com.bytetrain.prodinv.repository

import com.bytetrain.prodinv.entity.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Suppress("unused")
@Repository
interface ProductMongoRepository : MongoRepository<ProductEntity, String>
