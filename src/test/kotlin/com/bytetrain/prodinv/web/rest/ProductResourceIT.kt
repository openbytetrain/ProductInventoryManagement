package com.bytetrain.prodinv.web.rest

import com.bytetrain.prodinv.ProductinventoryApp
import com.bytetrain.prodinv.domain.Product
import com.bytetrain.prodinv.repository.ProductRepository
import com.bytetrain.prodinv.service.ProductService
import com.bytetrain.prodinv.service.mapper.ProductMapper
import com.bytetrain.prodinv.web.rest.errors.ExceptionTranslator
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.hasItem
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.validation.Validator

/**
 * Integration tests for the [ProductResource] REST controller.
 *
 * @see ProductResource
 */
@SpringBootTest(classes = [ProductinventoryApp::class])
@AutoConfigureMockMvc
@WithMockUser
class ProductResourceIT {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var productMapper: ProductMapper

    @Autowired
    private lateinit var productService: ProductService

    @Autowired
    private lateinit var jacksonMessageConverter: MappingJackson2HttpMessageConverter

    @Autowired
    private lateinit var pageableArgumentResolver: PageableHandlerMethodArgumentResolver

    @Autowired
    private lateinit var exceptionTranslator: ExceptionTranslator

    @Autowired
    private lateinit var validator: Validator

    private lateinit var restProductMockMvc: MockMvc

    private lateinit var product: Product

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val productResource = ProductResource(productService)
         this.restProductMockMvc = MockMvcBuilders.standaloneSetup(productResource)
             .setCustomArgumentResolvers(pageableArgumentResolver)
             .setControllerAdvice(exceptionTranslator)
             .setConversionService(createFormattingConversionService())
             .setMessageConverters(jacksonMessageConverter)
             .setValidator(validator).build()
    }

    @BeforeEach
    fun initTest() {
        productRepository.deleteAll()
        product = createEntity()
    }

    @Test
    @Throws(Exception::class)
    fun createProduct() {
        val databaseSizeBeforeCreate = productRepository.findAll().size

        // Create the Product
        val productDTO = productMapper.toDto(product)
        restProductMockMvc.perform(
            post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(productDTO))
        ).andExpect(status().isCreated)

        // Validate the Product in the database
        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeCreate + 1)
        val testProduct = productList[productList.size - 1]
        assertThat(testProduct.name).isEqualTo(DEFAULT_NAME)
        assertThat(testProduct.description).isEqualTo(DEFAULT_DESCRIPTION)
    }

    @Test
    fun createProductWithExistingId() {
        val databaseSizeBeforeCreate = productRepository.findAll().size

        // Create the Product with an existing ID
        product.id = "existing_id"
        val productDTO = productMapper.toDto(product)

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductMockMvc.perform(
            post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(productDTO))
        ).andExpect(status().isBadRequest)

        // Validate the Product in the database
        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeCreate)
    }

    @Test
    @Throws(Exception::class)
    fun getAllProducts() {
        // Initialize the database
        productRepository.save(product)

        // Get all the productList
        restProductMockMvc.perform(get("/api/products?sort=id,desc"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(product.id)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION))) }

    @Test
    @Throws(Exception::class)
    fun getProduct() {
        // Initialize the database
        productRepository.save(product)

        val id = product.id
        assertNotNull(id)

        // Get the product
        restProductMockMvc.perform(get("/api/products/{id}", id))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(product.id))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION)) }

    @Test
    @Throws(Exception::class)
    fun getNonExistingProduct() {
        // Get the product
        restProductMockMvc.perform(get("/api/products/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound)
    }
    @Test
    fun updateProduct() {
        // Initialize the database
        productRepository.save(product)

        val databaseSizeBeforeUpdate = productRepository.findAll().size

        // Update the product
        val id = product.id
        assertNotNull(id)
        val updatedProduct = productRepository.findById(id).get()
        updatedProduct.name = UPDATED_NAME
        updatedProduct.description = UPDATED_DESCRIPTION
        val productDTO = productMapper.toDto(updatedProduct)

        restProductMockMvc.perform(
            put("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(productDTO))
        ).andExpect(status().isOk)

        // Validate the Product in the database
        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeUpdate)
        val testProduct = productList[productList.size - 1]
        assertThat(testProduct.name).isEqualTo(UPDATED_NAME)
        assertThat(testProduct.description).isEqualTo(UPDATED_DESCRIPTION)
    }

    @Test
    fun updateNonExistingProduct() {
        val databaseSizeBeforeUpdate = productRepository.findAll().size

        // Create the Product
        val productDTO = productMapper.toDto(product)

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductMockMvc.perform(
            put("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(productDTO))
        ).andExpect(status().isBadRequest)

        // Validate the Product in the database
        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeUpdate)
    }

    @Test
    @Throws(Exception::class)
    fun deleteProduct() {
        // Initialize the database
        productRepository.save(product)

        val databaseSizeBeforeDelete = productRepository.findAll().size

        // Delete the product
        restProductMockMvc.perform(
            delete("/api/products/{id}", product.id)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent)

        // Validate the database contains one less item
        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeDelete - 1)
    }

    companion object {

        private const val DEFAULT_NAME = "AAAAAAAAAA"
        private const val UPDATED_NAME = "BBBBBBBBBB"

        private const val DEFAULT_DESCRIPTION = "AAAAAAAAAA"
        private const val UPDATED_DESCRIPTION = "BBBBBBBBBB"

        /**
         * Create an entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createEntity(): Product {
            val product = Product(
                name = DEFAULT_NAME,
                description = DEFAULT_DESCRIPTION
            )

            return product
        }

        /**
         * Create an updated entity for this test.
         *
         * This is a static method, as tests for other entities might also need it,
         * if they test an entity which requires the current entity.
         */
        @JvmStatic
        fun createUpdatedEntity(): Product {
            val product = Product(
                name = UPDATED_NAME,
                description = UPDATED_DESCRIPTION
            )

            return product
        }
    }
}
