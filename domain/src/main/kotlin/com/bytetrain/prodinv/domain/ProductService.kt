package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.domain.dto.ProductCreateCommand
import com.bytetrain.prodinv.domain.mapper.ProductCreateCommandMapper
import com.bytetrain.prodinv.domain.repository.ProductRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productCreateCommandMapper: ProductCreateCommandMapper

) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun createProduct(productCreateCommand: ProductCreateCommand): Product {
        log.debug("Request to save Product : {}", productCreateCommand)
        val product = productCreateCommandMapper.toDomain(productCreateCommand)
        return productRepository.save(product)
    }
}
