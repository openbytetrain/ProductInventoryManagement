package com.bytetrain.prodinv.service.mapper

import com.bytetrain.prodinv.domain.RelatedProductOrderItemEntity
import com.bytetrain.prodinv.web.api.model.RelatedProductOrderItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RelatedProductOrderItemModelMapperTest {

    @Autowired
    private lateinit var relatedProductOrderItemModelMapper: RelatedProductOrderItemModelMapper

    @Test
    fun `test RelatedProductOrderItem toDto mapping with relatedProductOrderItemModelMapper`() {
        var productOrderItem = relatedProductOrderItemModelMapper.toDto(generateEntity())
        assertThat(productOrderItem.orderItemAction).isEqualTo("string")
        assertThat(productOrderItem.orderItemId).isEqualTo("string")
        assertThat(productOrderItem.productOrderId).isEqualTo("string")
        assertThat(productOrderItem.productOrderHref).isEqualTo("string")
        assertThat(productOrderItem.role).isEqualTo("string")
        assertThat(productOrderItem.atBaseType).isEqualTo("string")
        assertThat(productOrderItem.atType).isEqualTo("string")
        assertThat(productOrderItem.atReferredType).isEqualTo("string")
    }

    @Test
    fun `test RelatedProductOrderItem toEntity mapping with relatedProductOrderItemModelMapper`() {
        var productOrderItem = relatedProductOrderItemModelMapper.toEntity(generateDto())
        assertThat(productOrderItem.orderItemAction).isEqualTo("string")
        assertThat(productOrderItem.orderItemId).isEqualTo("string")
        assertThat(productOrderItem.productOrderId).isEqualTo("string")
        assertThat(productOrderItem.productOrderHref).isEqualTo("string")
        assertThat(productOrderItem.role).isEqualTo("string")
        assertThat(productOrderItem.atBaseType).isEqualTo("string")
        assertThat(productOrderItem.atType).isEqualTo("string")
        assertThat(productOrderItem.atReferredType).isEqualTo("string")
    }

    private fun generateDto(): RelatedProductOrderItem {
        return RelatedProductOrderItem(
            orderItemAction = "string",
            orderItemId = "string",
            productOrderId = "string",
            productOrderHref = "string",
            role = "string",
            atBaseType = "string",
            atType = "string",
            atReferredType = "string"

        )
    }

    private fun generateEntity(): RelatedProductOrderItemEntity {
        return RelatedProductOrderItemEntity(
            orderItemAction = "string",
            orderItemId = "string",
            productOrderId = "string",
            productOrderHref = "string",
            role = "string",
            atBaseType = "string",
            atType = "string",
            atReferredType = "string"

        )
    }
}
