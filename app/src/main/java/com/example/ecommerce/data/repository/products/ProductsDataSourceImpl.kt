package com.example.ecommerce.data.repository.products

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomainMapper


class ProductsDataSourceImpl(private val productsService: ProductsService) : ProductsDataSource {

    override suspend fun getProducts(): Result<ProductListResponseDomain?> {
        return if (productsService.getProducts().isSuccessful) {
            Result.Success(ProductListResponseDomainMapper().map(productsService.getProducts().body()))
        } else
            Result.Error(productsService.getProducts().code())

    }


}