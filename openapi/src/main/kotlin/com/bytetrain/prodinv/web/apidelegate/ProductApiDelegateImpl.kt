package com.bytetrain.prodinv.web.apidelegate

import com.bytetrain.prodinv.domain.ProductService
import com.bytetrain.prodinv.service.dto.ProductDTO
import com.bytetrain.prodinv.web.api.ProductApiDelegate
import com.bytetrain.prodinv.web.api.model.ProductCreateModel
import com.bytetrain.prodinv.web.api.model.ProductModel
import com.bytetrain.prodinv.web.apidelegate.mapper.ProductCreateModelMapper
import com.bytetrain.prodinv.web.apidelegate.mapper.ProductModelMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProductApiDelegateImpl(
    private val productCreateModelMapper: ProductCreateModelMapper,
    private val productModelMapper: ProductModelMapper,
    private val productService: ProductService

) : ProductApiDelegate {

    private val log = LoggerFactory.getLogger(javaClass)

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun createProduct(productCreateModel: ProductCreateModel): ResponseEntity<ProductModel> {
        log.debug("Request to save Product : {}", productCreateModel)

        val productCreateCommand = productCreateModelMapper.toEntity(productCreateModel)
        val product = productService.createProduct(productCreateCommand)
        return ResponseEntity(productModelMapper.toDto(product), HttpStatus.CREATED)
    }
}
