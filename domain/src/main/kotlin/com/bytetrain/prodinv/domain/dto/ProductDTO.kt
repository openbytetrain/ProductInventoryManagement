package com.bytetrain.prodinv.service.dto

import java.io.Serializable

/**
 * A DTO for the [com.bytetrain.prodinv.domain.ProductEntity] entity.
 */
data class ProductDTO(

    var id: String? = null,

    var name: String? = null,

    var description: String? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductDTO) return false
        return id != null && id == other.id
    }

    override fun hashCode() = 31
}
