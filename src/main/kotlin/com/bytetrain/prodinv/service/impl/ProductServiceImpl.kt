package com.bytetrain.prodinv.service.impl

import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.repository.ProductRepository
import com.bytetrain.prodinv.service.ProductService
import com.bytetrain.prodinv.service.dto.ProductDTO
import com.bytetrain.prodinv.service.mapper.ProductCreateModelMapper
import com.bytetrain.prodinv.service.mapper.ProductMapper
import com.bytetrain.prodinv.service.mapper.ProductModelMapper
import com.bytetrain.prodinv.web.api.ProductApiDelegate
import com.bytetrain.prodinv.web.api.model.ProductCreate
import java.util.Optional
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * Service Implementation for managing [ProductEntity].
 */
@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
    private val productCreateModelMapper: ProductCreateModelMapper,
    private val productModelMapper: ProductModelMapper

) : ProductService, ProductApiDelegate {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun createProduct(productCreateDto: ProductCreate): ResponseEntity<com.bytetrain.prodinv.web.api.model.Product> {
        log.debug("Request to save Product : {}", productCreateDto)

        var product = productCreateModelMapper.toEntity(productCreateDto)
        product = productRepository.save(product)
        return ResponseEntity(productModelMapper.toDto(product), HttpStatus.CREATED)
    }

    /**
     * Get all the products.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    override fun findAll(pageable: Pageable): Page<ProductDTO> {
        log.debug("Request to get all Products")
        return productRepository.findAll(pageable)
            .map(productMapper::toDto)
    }

    /**
     * Get one product by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    override fun findOne(id: String): Optional<ProductDTO> {
        log.debug("Request to get Product : {}", id)
        return productRepository.findById(id)
            .map(productMapper::toDto)
    }

    /**
     * Delete the product by id.
     *
     * @param id the id of the entity.
     */
    override fun delete(id: String) {
        log.debug("Request to delete Product : {}", id)

        productRepository.deleteById(id)
    }
}
