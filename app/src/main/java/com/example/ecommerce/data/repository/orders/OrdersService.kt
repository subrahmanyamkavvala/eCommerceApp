package com.example.ecommerce.data.repository.orders

import com.example.ecommerce.data.dto.orders.OrderDetails
import com.example.ecommerce.data.dto.orders.OrdersResponse
import com.example.ecommerce.data.dto.orders.UpdateOrderHeaderMap
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrdersService {
    @GET("/api/orders")
    suspend fun getAllOrders(): Response<List<OrdersResponse>>

    @GET("/api/orders/status\\?order_id={order_id}")
    suspend fun getOrderDetailsByID(@Path("order_id")orderID: Int): Response<OrderDetails>
    @PUT("")
    suspend fun updateorCreateOrder(@HeaderMap orderHeader : UpdateOrderHeaderMap)

}