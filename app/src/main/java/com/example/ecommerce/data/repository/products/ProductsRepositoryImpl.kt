package com.example.ecommerce.data.repository.products

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.data.dto.products.ProductListResponse

class ProductsRepositoryImpl (val dataSource: ProductsDataSource) : ProductsRepository  {

    override suspend fun getProducts(): Result<ProductListResponseDomain?> {

        // Repository is resposible to get data from multiple source and return
        // get from local data source
        // sage to local data source
        // add to cache


        return dataSource.getProducts()

    }
}