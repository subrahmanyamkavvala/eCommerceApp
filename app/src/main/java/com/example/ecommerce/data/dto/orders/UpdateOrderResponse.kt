package com.example.ecommerce.data.dto.orders


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UpdateOrderResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("order_id")
    val orderId: Int? = null,
    @SerializedName("status")
    val status: String? = null
)