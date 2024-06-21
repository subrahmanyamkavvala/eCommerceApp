package com.example.ecommerce.presentation.screens.productDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.api.Result
import com.example.ecommerce.data.repository.products.ProductsRepository
import com.example.ecommerce.presentation.screens.productDetails.mvi.BeerDetailsScreenIntent
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

    fun processIntent(beerDetailsScreenIntent: BeerDetailsScreenIntent, selectedBeerId: Int?) {
        when(beerDetailsScreenIntent){

            is BeerDetailsScreenIntent.LoadBeerDetails -> {
                /*viewModelScope.launch {
                    val response = selectedBeerId?.let { repository.fetchBeerDetails(it) }
                    if (response != null) {
                        processResult(response)
                    }
                }*/
            }
        }
    }

   /* private fun processResult(response: Result<List<BeersDomainModel>>) {
        when(response) {
            is Result.Success -> {
                setState {
                    onBeerDetailsDataLoaded(beerDetails = response.data[0])
                }
            }
            is Result.Error -> {
                setState {
                    onErrorOccurred(errorMsg = response.exception)
                }
            }
        }
    }*/


    private fun setState(stateReducer: ProductDetailsScreenState.() -> ProductDetailsScreenState) {
        viewModelScope.launch {
            _state.emit(stateReducer(state.value))
        }
    }
}