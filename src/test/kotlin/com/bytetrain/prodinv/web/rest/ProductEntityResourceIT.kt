package com.bytetrain.prodinv.web.rest

import com.bytetrain.prodinv.ProductinventoryApp
import com.bytetrain.prodinv.domain.CharacteristicEntity
import com.bytetrain.prodinv.domain.PriceEntity
import com.bytetrain.prodinv.domain.ProductEntity
import com.bytetrain.prodinv.domain.ProductPriceEntity
import com.bytetrain.prodinv.repository.ProductRepository
import com.bytetrain.prodinv.service.mapper.ProductMapper
import com.bytetrain.prodinv.web.api.ProductApiController
import com.bytetrain.prodinv.web.api.model.*
import com.bytetrain.prodinv.web.rest.errors.ExceptionTranslator
import java.io.File
import kotlin.test.assertNotNull
import org.apache.commons.io.FileUtils
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

@SpringBootTest(classes = [ProductinventoryApp::class])
@AutoConfigureMockMvc
@WithMockUser
class ProductEntityResourceIT {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var productMapper: ProductMapper

    @Autowired
    private lateinit var controller: ProductApiController

    @Autowired
    private lateinit var jacksonMessageConverter: MappingJackson2HttpMessageConverter

    @Autowired
    private lateinit var pageableArgumentResolver: PageableHandlerMethodArgumentResolver

    @Autowired
    private lateinit var exceptionTranslator: ExceptionTranslator

    @Autowired
    private lateinit var validator: Validator

    private lateinit var restProductMockMvc: MockMvc

    private lateinit var productEntity: ProductEntity

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        this.restProductMockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build()
    }

    @BeforeEach
    fun initTest() {
        productRepository.deleteAll()
        productEntity = productCreateProductCreateEntity()
    }

    @Test
    @Throws(Exception::class)
    fun createProduct() {
        val databaseSizeBeforeCreate = productRepository.findAll().size

        val readFileToByteArray = FileUtils.readFileToByteArray(File("src/test/kotlin/com/bytetrain/prodinv/web/rest/product.txt"))
        restProductMockMvc.perform(
            post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readFileToByteArray)
        ).andExpect(status().isCreated)
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
        productEntity.id = "existing_id"
        val productDTO = productMapper.toDto(productEntity)

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductMockMvc.perform(
            post("/api/product")
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
        productRepository.save(productEntity)

        restProductMockMvc.perform(get("/api/product?sort=id,desc"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productEntity.id)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
    }

    @Test
    @Throws(Exception::class)
    fun getProduct() {
        productRepository.save(productEntity)

        val id = productEntity.id
        assertNotNull(id)

        // Get the product
        restProductMockMvc.perform(get("/api/product/{id}", id))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(productEntity.id))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
    }

    @Test
    @Throws(Exception::class)
    fun getNonExistingProduct() {
        restProductMockMvc.perform(get("/api/product/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound)
    }

    @Test
    fun updateProduct() {
        productRepository.save(productEntity)

        val databaseSizeBeforeUpdate = productRepository.findAll().size

        val id = productEntity.id
        assertNotNull(id)
        val updatedProduct = productRepository.findById(id).get()
        updatedProduct.name = UPDATED_NAME
        updatedProduct.description = UPDATED_DESCRIPTION
        val productDTO = productMapper.toDto(updatedProduct)

        restProductMockMvc.perform(
            put("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(productDTO))
        ).andExpect(status().isOk)

        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeUpdate)
        val testProduct = productList[productList.size - 1]
        assertThat(testProduct.name).isEqualTo(UPDATED_NAME)
        assertThat(testProduct.description).isEqualTo(UPDATED_DESCRIPTION)
    }

    @Test
    fun updateNonExistingProduct() {
        val databaseSizeBeforeUpdate = productRepository.findAll().size

        val productDTO = productMapper.toDto(productEntity)

        restProductMockMvc.perform(
            put("/api/product")
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
        productRepository.save(productEntity)

        val databaseSizeBeforeDelete = productRepository.findAll().size

        restProductMockMvc.perform(
            delete("/api/product/{id}", productEntity.id)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent)

        val productList = productRepository.findAll()
        assertThat(productList).hasSize(databaseSizeBeforeDelete - 1)
    }

    companion object {

        private const val DEFAULT_NAME = "string"
        private const val UPDATED_NAME = "BBBBBBBBBB"

        private const val DEFAULT_DESCRIPTION = "string"
        private const val UPDATED_DESCRIPTION = "BBBBBBBBBB"

        private var productCharacteristics = mutableListOf(
            CharacteristicEntity(
                "name",
                Any(),
                null,
                null,
                null,
                null))
       private var relatedParty = mutableListOf(
            RelatedParty(
                "1",
                "1",
                null,
                null,
                null,
                null,
                null,
                null))
       private var realizingService = mutableListOf(
            ServiceRef(
                "1",
                null,
                null,
                null,
                null,
                null,
                null))
        private var productPrice = mutableListOf(
            ProductPriceEntity(
                "1",
                PriceEntity(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null))
        @JvmStatic
        fun productCreateProductCreateEntity(): ProductEntity {

            return ProductEntity("1",
                DEFAULT_NAME,
                ProductStatusType.cancelled,
                DEFAULT_DESCRIPTION,
                ProductOfferingRef(
                    "1",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                productCharacteristics,
                ProductSpecificationRef(
                    "1",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                BillingAccountRef(
                    "id_string",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                null,
                relatedParty,
                realizingService,
                productPrice)
        }

        @JvmStatic
        fun createUpdatedEntity(): ProductEntity {
            return ProductEntity("1",
                "Product",
                ProductStatusType.cancelled,
                "String",
                ProductOfferingRef(
                    "1",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                productCharacteristics,
                ProductSpecificationRef(
                    "1",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                BillingAccountRef(
                    "id_string",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null),
                null,
                relatedParty,
                realizingService,
                productPrice)
        }
    }
}
