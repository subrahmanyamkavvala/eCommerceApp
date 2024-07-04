package com.example.ecommerce.data.repository.products

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain

interface ProductsDataSource {
    suspend fun getProducts() : Result<ProductListResponseDomain?>
}