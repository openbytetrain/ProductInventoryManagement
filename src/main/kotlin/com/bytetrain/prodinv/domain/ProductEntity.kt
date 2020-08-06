package com.bytetrain.prodinv.domain

import com.bytetrain.prodinv.web.api.model.*
import java.io.Serializable
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "product")
data class ProductEntity(
    @Id
    var id: String? = null,
    @Field("name")
    var name: String? = null,
    @Field("status")
    var status: ProductStatusType? = null,
    @Field("description")
    var description: String? = null,
    @Field("product_offering")
    var productOffering: ProductOfferingRef? = null,
    @Field("product_characteristic")
    var productCharacteristic: List<CharacteristicEntity>? = null,
    @Field("product_specification")
    var productSpecification: ProductSpecificationRef? = null,
    @Field("billing_account")
    var billingAccount: BillingAccountRef? = null,
    @Field("schema_location")
    var atSchemaLocation: java.net.URI? = null,
    @Field("related_party")
    var relatedParty: List<RelatedParty>? = null,
    @Field("realizing_service")
    var realizingService: List<ServiceRef>? = null,
    @Field("product_price")
    var productPriceEntity: List<ProductPriceEntity>? = null,
    @Field("product_term")
    val productTerm: List<ProductTermEntity>? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductEntity) return false

        return id != null && other.id != null && id == other.id
    }

    override fun hashCode() = 31

    override fun toString() = "Product{" +
        "id=$id" +
        ", name='$name'" +
        ", description='$description'" +
        "}"

    companion object {
        private const val serialVersionUID = 1L
    }
}
