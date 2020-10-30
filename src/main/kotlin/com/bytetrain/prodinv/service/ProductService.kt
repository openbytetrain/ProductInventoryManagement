package com.bytetrain.prodinv.service
import com.bytetrain.prodinv.service.dto.ProductDTO
import java.util.Optional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * Service Interface for managing [com.bytetrain.prodinv.domain.Product].
 */
interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     */
    fun save(productDTO: ProductDTO): ProductDTO

    /**
     * Get all the products.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    fun findAll(pageable: Pageable): Page<ProductDTO>

    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    fun findOne(id: String): Optional<ProductDTO>

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    fun delete(id: String)
}
