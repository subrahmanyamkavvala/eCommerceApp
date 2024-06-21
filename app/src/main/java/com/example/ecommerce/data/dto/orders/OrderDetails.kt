package com.example.ecommerce.data.dto.orders


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class OrderDetails(
    @SerializedName("items")
    val items: List<Item?>? = null,
    @SerializedName("order_id")
    val orderId: Int? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("total_price")
    val totalPrice: Double? = null,
    @SerializedName("user_id")
    val userId: Int? = null
) {
    @Keep
     data class Item(
        @SerializedName("product_id")
        val productId: Int? = -1,
        @SerializedName("quantity")
        val quantity: Int? = -1
    )
}