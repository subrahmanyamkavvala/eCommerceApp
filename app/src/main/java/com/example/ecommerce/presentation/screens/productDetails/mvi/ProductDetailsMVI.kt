package com.example.ecommerce.presentation.screens.productDetails.mvi

import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.presentation.screens.productDetails.ProductDetailsViewModel

data class ProductDetailsScreenState(
    val productDetails: ProductListResponseDomain.ProductListResponseItemDomain? = null,
    val isLoading:Boolean = false,
    val errorMessage:String? = null
) {

    fun onBeerDetailsDataLoaded(details: ProductListResponseDomain.ProductListResponseItemDomain): ProductDetailsScreenState {
        return copy(productDetails = details, isLoading = false)
    }

    fun onErrorOccurred(errorMsg: String): ProductDetailsScreenState {
        return copy(productDetails = null, isLoading = false, errorMessage = errorMsg )
    }

}

sealed class BeerDetailsScreenIntent {

    object LoadBeerDetails: BeerDetailsScreenIntent()
}