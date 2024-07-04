package com.example.ecommerce.presentation.screens.productDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.repository.products.ProductsRepository
import com.example.ecommerce.presentation.screens.productDetails.mvi.ProductDetailsMVI
import com.example.ecommerce.presentation.screens.productDetails.mvi.ProductDetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val repository: ProductsRepository,
): ViewModel() {

    private val _state = MutableStateFlow(ProductDetailsScreenState(isLoading = true))
    val state: StateFlow<ProductDetailsScreenState> = _state.asStateFlow()

    fun processIntent(productDetailsMVI: ProductDetailsMVI, selectedProduct: String?) {
        when(productDetailsMVI) {
            is ProductDetailsMVI.LoadProductDetails -> {
             // TODO Load product Details
            }
        }
    }

}