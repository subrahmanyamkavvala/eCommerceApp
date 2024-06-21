package com.example.ecommerce.data.dto.orders


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
 data class UpdateOrderHeaderMap(
    @SerializedName("items")
    val items: List<Item?>? = null,
    @SerializedName("user_id")
    val userId: Int? = null
) {
    @Keep
     data class Item(
        @SerializedName("product_id")
        val productId: Int? = null,
        @SerializedName("quantity")
        val quantity: Int? = null
    )
}