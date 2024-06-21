package com.example.ecommerce.data.domainModels.products


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.ecommerce.data.dto.products.ProductListResponse
import com.example.ecommerce.domain.mappers.EntityMapper

class ProductListResponseDomainMapper :
    EntityMapper<ProductListResponse, ProductListResponseDomain> {

    override fun map(dto: ProductListResponse?): ProductListResponseDomain? {
        val domain = ProductListResponseDomain()

        dto?.forEach { item ->
            val reviewDomains =
                mutableListOf<ProductListResponseDomain.ProductListResponseItemDomain.ReviewDomain>()
            item.reviews?.forEach { review ->
                reviewDomains.add(
                    ProductListResponseDomain.ProductListResponseItemDomain.ReviewDomain(
                        review?.comment,
                        review?.rating
                    )
                )
            }
            domain.add(
                ProductListResponseDomain.ProductListResponseItemDomain(
                    availability =
                    item.availability,
                   brand = item.brand,
                   image = item.image,
                   description = item.description,
                   reviewDomains = reviewDomains,
                   price = item.price
                )
            )
        }
        return domain
    }

}

class ProductListResponseDomain :
    ArrayList<ProductListResponseDomain.ProductListResponseItemDomain>() {
    @Keep
    data class ProductListResponseItemDomain(
        @SerializedName("availability")
        val availability: Boolean? = null,
        @SerializedName("brand")
        val brand: String? = null,
        @SerializedName("category")
        val category: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("discount")
        val discount: Int? = null,
        @SerializedName("image")
        val image: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("price")
        val price: Double? = null,
        @SerializedName("product_id")
        val productId: Int? = null,
        @SerializedName("rating")
        val rating: Double? = null,
        @SerializedName("reviews")
        val reviewDomains: List<ReviewDomain?>? = null,
        @SerializedName("unit")
        val unit: String? = null
    ) {
        @Keep
        data class ReviewDomain(
            @SerializedName("comment")
            val comment: String? = null,
            @SerializedName("rating")
            val rating: Int? = null,
            @SerializedName("user_id")
            val userId: Int? = null
        )
    }
}