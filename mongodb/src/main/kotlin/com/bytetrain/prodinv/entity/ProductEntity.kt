package com.bytetrain.prodinv.entity

import com.bytetrain.prodinv.domain.ProductStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable

@Document(collection = "product")
data class ProductEntity(
    @Id
    var id: String? = null,
    @Field("name")
    var name: String? = null,
    @Field("status")
    var status: ProductStatus? = null,
    @Field("description")
    var description: String? = null,
    @Field("product_characteristic")
    var productCharacteristic: List<CharacteristicEntity>? = null,
    @Field("schema_location")
    var atSchemaLocation: java.net.URI? = null,
    @Field("product_price")
    var productPriceEntity: List<ProductPriceEntity>? = null

) : Serializable {

    override fun toString() = "Product{" +
        "id=$id" +
        ", name='$name'" +
        ", description='$description'" +
        "}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
