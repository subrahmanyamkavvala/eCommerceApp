package com.example.ecommerce.data.dto.products


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

 class ProductListResponse : ArrayList<ProductListResponse.ProductListResponseItem>(){
    @Keep
     data class ProductListResponseItem(
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
        val reviews: List<Review?>? = null,
        @SerializedName("unit")
        val unit: String? = null
    ) {
        @Keep
         data class Review(
            @SerializedName("comment")
            val comment: String? = null,
            @SerializedName("rating")
            val rating: Int? = null,
            @SerializedName("user_id")
            val userId: Int? = null
        )
    }
}