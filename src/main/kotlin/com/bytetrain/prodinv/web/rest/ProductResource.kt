package com.bytetrain.prodinv.web.rest

import com.bytetrain.prodinv.service.ProductService
import com.bytetrain.prodinv.service.dto.ProductDTO
import com.bytetrain.prodinv.web.rest.errors.BadRequestAlertException
import io.github.jhipster.web.util.HeaderUtil
import io.github.jhipster.web.util.PaginationUtil
import io.github.jhipster.web.util.ResponseUtil
import java.net.URI
import java.net.URISyntaxException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

private const val ENTITY_NAME = "productinventoryProduct"
/**
 * REST controller for managing [com.bytetrain.prodinv.domain.Product].
 */
@RestController
@RequestMapping("/api")
class ProductResource(
    private val productService: ProductService
) {

    private val log = LoggerFactory.getLogger(javaClass)
    @Value("\${jhipster.clientApp.name}")
    private var applicationName: String? = null

    /**
     * `POST  /products` : Create a new product.
     *
     * @param productDTO the productDTO to create.
     * @return the [ResponseEntity] with status `201 (Created)` and with body the new productDTO, or with status `400 (Bad Request)` if the product has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/products")
    fun createProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        log.debug("REST request to save Product : {}", productDTO)
        if (productDTO.id != null) {
            throw BadRequestAlertException(
                "A new product cannot already have an ID",
                ENTITY_NAME, "idexists"
            )
        }
        val result = productService.save(productDTO)
        return ResponseEntity.created(URI("/api/products/${result.id}"))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.id))
            .body(result)
    }

    /**
     * `PUT  /products` : Updates an existing product.
     *
     * @param productDTO the productDTO to update.
     * @return the [ResponseEntity] with status `200 (OK)` and with body the updated productDTO,
     * or with status `400 (Bad Request)` if the productDTO is not valid,
     * or with status `500 (Internal Server Error)` if the productDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/products")
    fun updateProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        log.debug("REST request to update Product : {}", productDTO)
        if (productDTO.id == null) {
            throw BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull")
        }
        val result = productService.save(productDTO)
        return ResponseEntity.ok()
            .headers(
                HeaderUtil.createEntityUpdateAlert(
                    applicationName, false, ENTITY_NAME,
                     productDTO.id
                )
            )
            .body(result)
    }
    /**
     * `GET  /products` : get all the products.
     *
     * @param pageable the pagination information.

     * @return the [ResponseEntity] with status `200 (OK)` and the list of products in body.
     */
    @GetMapping("/products")
    fun getAllProducts(pageable: Pageable): ResponseEntity<List<ProductDTO>> {
        log.debug("REST request to get a page of Products")
        val page = productService.findAll(pageable)
        val headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page)
        return ResponseEntity.ok().headers(headers).body(page.content)
    }

    /**
     * `GET  /products/:id` : get the "id" product.
     *
     * @param id the id of the productDTO to retrieve.
     * @return the [ResponseEntity] with status `200 (OK)` and with body the productDTO, or with status `404 (Not Found)`.
     */
    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: String): ResponseEntity<ProductDTO> {
        log.debug("REST request to get Product : {}", id)
        val productDTO = productService.findOne(id)
        return ResponseUtil.wrapOrNotFound(productDTO)
    }
    /**
     *  `DELETE  /products/:id` : delete the "id" product.
     *
     * @param id the id of the productDTO to delete.
     * @return the [ResponseEntity] with status `204 (NO_CONTENT)`.
     */
    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Void> {
        log.debug("REST request to delete Product : {}", id)

        productService.delete(id)
            return ResponseEntity.noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build()
    }
}
