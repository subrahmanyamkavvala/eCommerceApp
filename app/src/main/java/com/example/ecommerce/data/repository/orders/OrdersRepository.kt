package com.example.ecommerce.data.repository.orders

import com.example.ecommerce.data.dto.orders.OrdersResponse
import com.example.ecommerce.data.dto.orders.UpdateOrderHeaderMap
import com.example.ecommerce.data.dto.orders.UpdateOrderResponse

internal interface OrdersRepository {
    suspend fun getAllOrders() : OrdersResponse?
    suspend fun updateOrCreateOrder(updateOrderDetails : UpdateOrderHeaderMap) : UpdateOrderResponse?
}