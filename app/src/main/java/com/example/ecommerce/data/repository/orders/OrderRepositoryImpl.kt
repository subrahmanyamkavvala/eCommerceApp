package com.example.ecommerce.data.repository.orders

import com.example.ecommerce.data.dto.orders.OrdersResponse
import com.example.ecommerce.data.dto.orders.UpdateOrderHeaderMap
import com.example.ecommerce.data.dto.orders.UpdateOrderResponse

class OrderRepositoryImpl(val ordersService: OrdersService) : OrdersRepository {
    override suspend fun getAllOrders(): OrdersResponse? {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrCreateOrder(updateOrderDetails: UpdateOrderHeaderMap): UpdateOrderResponse? {
        TODO("Not yet implemented")
    }
}