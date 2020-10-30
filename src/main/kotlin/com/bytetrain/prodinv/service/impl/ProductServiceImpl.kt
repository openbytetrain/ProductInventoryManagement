package com.bytetrain.prodinv.service.impl

import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.repository.ProductRepository
import com.bytetrain.prodinv.service.ProductService
import com.bytetrain.prodinv.service.dto.ProductDTO
import com.bytetrain.prodinv.service.mapper.ProductMapper
import java.util.Optional
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Service Implementation for managing [Product].
 */
@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : ProductService {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     */
    override fun save(productDTO: ProductDTO): ProductDTO {
        log.debug("Request to save Product : {}", productDTO)

        var product = productMapper.toEntity(productDTO)
        product = productRepository.save(product)
        return productMapper.toDto(product)
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
