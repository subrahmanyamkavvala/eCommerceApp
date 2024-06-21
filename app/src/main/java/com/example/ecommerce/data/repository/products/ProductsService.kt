package com.example.ecommerce.data.repository.products

import com.example.ecommerce.data.dto.products.ProductListResponse
import retrofit2.Response
import retrofit2.http.GET


/*
*
* Service to communicate with eCommerce mock server and returns the data
* https://app.beeceptor.com/mock-server/fake-store-api
*
* */



interface ProductsService {

    @GET("/api/products")
    suspend fun getProducts(): Response<ProductListResponse>

}