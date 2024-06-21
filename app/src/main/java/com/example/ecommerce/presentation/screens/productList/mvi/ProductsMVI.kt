package com.example.ecommerce.presentation.screens.productList.mvi

import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain

data class ProductsScreenState(
    val productList: ProductListResponseDomain ? = null ,
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
) {
    fun onBeersDataLoaded(products: ProductListResponseDomain): ProductsScreenState {
        return copy(productList = products, isLoading = false)
    }

    fun onError(errorMsg: String): ProductsScreenState {
        return copy(isLoading = false, productList = null , errorMsg = errorMsg )
    }
}

sealed class ProductScreenIntent {
    object LoadProducts : ProductScreenIntent()
}