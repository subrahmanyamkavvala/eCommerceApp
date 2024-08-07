package com.example.ecommerce.presentation.screens.productList.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


@Composable
fun <SideEffect> CollectSideEffect(
    sideEffect: Flow<SideEffect>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    context: CoroutineContext = Dispatchers.Main.immediate,
    onSideEffect: suspend CoroutineScope.(effect: SideEffect) -> Unit,
) {
    LaunchedEffect(sideEffect, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(minActiveState) {
            if (context == EmptyCoroutineContext) {
                sideEffect.collect { onSideEffect(it) }
            } else {
                withContext(context) {
                    sideEffect.collect { onSideEffect(it) }
                }
            }
        }
    }
}

interface ProductsMVI {

    data class ProductsScreenState(
        val productList: ProductListResponseDomain? = null,
        val isLoading: Boolean = false,
        val errorMsg: String? = null,
    ) {
        fun onProductDataLoaded(products: ProductListResponseDomain): ProductsScreenState {
            return copy(productList = products, isLoading = false)
        }

        fun onError(errorMsg: String): ProductsScreenState {
            return copy(isLoading = false, productList = null, errorMsg = errorMsg)
        }
    }


    sealed interface ProductScreenAction {
        data class ClickedProduct(val product: ProductListResponseDomain.ProductListResponseItemDomain) :
            ProductScreenAction

        data class addToCart(val product: ProductListResponseDomain.ProductListResponseItemDomain) :
            ProductScreenAction
    }

    sealed interface ProductScreenSideEffect {
        data class NavigateToProductDetailsScreen(val product: ProductListResponseDomain.ProductListResponseItemDomain) :
            ProductScreenSideEffect

        data class addToCart(val product: ProductListResponseDomain.ProductListResponseItemDomain) :
            ProductScreenSideEffect

    }

}