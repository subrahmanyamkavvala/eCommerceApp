package com.example.ecommerce.data.domainModels.orders


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.ecommerce.data.domainModels.orders.OrderDetailsDomain.OrderItemDomain
import com.example.ecommerce.data.dto.orders.OrderDetails
import com.example.ecommerce.domain.mappers.EntityMapper

class OrderDetailsEntityMapper : EntityMapper<OrderDetails, OrderDetailsDomain> {
    override fun map(input: OrderDetails?): OrderDetailsDomain? {
        val orderDetailsDomain: OrderDetailsDomain
        input.run {
            val items = mutableListOf<OrderItemDomain>()
            input?.items?.forEach { item ->
                items.add(
                    (OrderItemDomain(
                        item?.productId,
                        item?.quantity
                    ))
                )
            }
            orderDetailsDomain = OrderDetailsDomain(
                items,
                input?.orderId?:-1,
                input?.status,
                input?.totalPrice,
                input?.userId
            )
        }
        return orderDetailsDomain
    }
}

@Keep
data class OrderDetailsDomain(
    @SerializedName("items")
    val items: List<OrderItemDomain?>? = null,
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
    data class OrderItemDomain(
        @SerializedName("product_id")
        val productId: Int? = null,
        @SerializedName("quantity")
        val quantity: Int? = null
    )
}