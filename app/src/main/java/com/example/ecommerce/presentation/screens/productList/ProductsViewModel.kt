package com.example.ecommerce.presentation.screens.productList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.api.Result
import com.example.ecommerce.domain.usecases.GetProductListUsecase
import com.example.ecommerce.presentation.screens.productList.mvi.ProductsMVI
import com.subbu.core.presentation.MVI
import com.subbu.core.presentation.mvi

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private fun initialUiState() = ProductsMVI.ProductsScreenState(isLoading = true)

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductListUsecase: GetProductListUsecase
) : ViewModel(),
    MVI<ProductsMVI.ProductsScreenState, ProductsMVI.ProductScreenAction, ProductsMVI.ProductScreenSideEffect> by mvi(
        initialUiState = initialUiState()
    ) {

    init {
        loadProducts()
    }

    override fun onAction(uiAction: ProductsMVI.ProductScreenAction) {
        when (uiAction) {
            is ProductsMVI.ProductScreenAction.ClickedProduct -> {
                viewModelScope.emitSideEffect(
                    ProductsMVI.ProductScreenSideEffect.NavigateToProductDetailsScreen(
                        uiAction.product
                    )
                )
            }
        }

    }

    private fun loadProducts() {
        viewModelScope.launch {
            when (val response = getProductListUsecase.invoke()) {
                is Result.Success -> {
                    if (response.data != null) {
                        updateUiState(ProductsMVI.ProductsScreenState(response.data, false))

                    }
                }

                is Result.Error -> {
                    updateUiState(
                        ProductsMVI.ProductsScreenState(
                            errorMsg = response.errorBody ?: ""
                        )
                    )
                }
            }
        }
    }
}