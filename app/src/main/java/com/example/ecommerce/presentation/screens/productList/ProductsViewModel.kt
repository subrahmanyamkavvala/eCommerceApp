package com.example.ecommerce.presentation.screens.productList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.api.Result
import com.example.ecommerce.data.repository.products.ProductsRepository
import com.example.ecommerce.domain.mappers.GetProductListUsecase
import com.example.ecommerce.presentation.screens.productList.mvi.ProductScreenIntent
import com.example.ecommerce.presentation.screens.productList.mvi.ProductsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductListUsecase: GetProductListUsecase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsScreenState(isLoading = true))
    val state: StateFlow<ProductsScreenState> = _state.asStateFlow()

    init {
        processIntent(ProductScreenIntent.LoadProducts)
    }

    private fun processIntent(beersScreenIntent: ProductScreenIntent) {
        when (beersScreenIntent) {
            is ProductScreenIntent.LoadProducts -> {
                viewModelScope.launch {
                   when(val response = getProductListUsecase.invoke()) {
                       is Result.Success -> {
                            if(response.data != null) {
                                setState {
                                    onBeersDataLoaded(response.data)
                                }
                            }
                       }

                       is Result.Error -> {
                           setState {
                               onError(errorMsg = response.errorBody?:"")
                           }
                       }
                   }

                }
            }
        }
    }

    private fun setState(stateReducer: ProductsScreenState.() -> ProductsScreenState) {
        viewModelScope.launch {
            _state.emit(stateReducer(state.value))
        }
    }
}