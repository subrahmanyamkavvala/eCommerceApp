package com.example.ecommerce.domain.usecases

import com.example.ecommerce.api.Result
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.data.repository.products.ProductsRepository


class GetProductListUsecase ( private val productsRepository: ProductsRepository) {

    suspend operator fun invoke() : Result<ProductListResponseDomain?>  {
        // store in cache
        // do data transformation
        // apply data validation
        // return the UI model
        return productsRepository.getProducts()
    }

}