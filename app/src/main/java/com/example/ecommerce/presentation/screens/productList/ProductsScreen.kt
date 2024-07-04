package com.example.ecommerce.presentation.screens.productList

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.ecommerce.NavRoute
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.presentation.screens.productList.mvi.CollectSideEffect
import com.example.ecommerce.presentation.screens.productList.mvi.ProductsMVI
import com.example.ecommerce.ui.widgets.LoadingScreen
import com.subbu.core.logger.Logger
import kotlinx.coroutines.flow.Flow


@Composable
fun ProductsScreen() {

}
@Composable
fun ProductsScreen(navController: NavHostController) {
    val productsViewModel = hiltViewModel<ProductsViewModel>()

    val uiState by productsViewModel.uiState.collectAsState()
    val sideEffect: Flow<ProductsMVI.ProductScreenSideEffect> = productsViewModel.sideEffect
    val onAction = productsViewModel::onAction

    val context = LocalContext.current

    CollectSideEffect(sideEffect = sideEffect) {
        when (it) {
            is ProductsMVI.ProductScreenSideEffect.NavigateToProductDetailsScreen -> {
                Logger.log("product clicked : ")
                Toast.makeText(context, "navigate to  ${it.product.description}", Toast.LENGTH_SHORT).show()
                navController.navigate(NavRoute.PRODUCTDETAILS.route + "/${it.product.productId}")
            }
        }
    }
    Scaffold(topBar = {
        TopBar(title = "eCommerce App")
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            when {
                uiState.isLoading -> {
                    LoadingScreen()
                }

                uiState.errorMsg != null -> {
                    ErrorScreen(uiState.errorMsg)
                }

                uiState.productList?.isNotEmpty() == true -> {
                    ProductsListContent(state = uiState,
                        onProductItemSelected = {
                            onAction(ProductsMVI.ProductScreenAction.ClickedProduct(it))
                        })
                }
            }
        }
    }

}

@Composable
private fun ProductsListContent(
    state: ProductsMVI.ProductsScreenState,
    onProductItemSelected: (ProductListResponseDomain.ProductListResponseItemDomain) -> Unit,
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        if(!state.productList.isNullOrEmpty()){
            state.productList?.size?.let { productItem ->
                items(productItem) {
                    ProductCard(product = state.productList[it]) { selectedProduct ->
                        onProductItemSelected(selectedProduct)
                    }
                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductCard(
    product: ProductListResponseDomain.ProductListResponseItemDomain,
    modifier: Modifier = Modifier,
    productItemSelected: (ProductListResponseDomain.ProductListResponseItemDomain) -> Unit
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp), onClick = { productItemSelected(product) }) {
        Row {
            AsyncImage(
                model = "https://fastly.picsum.photos/id/1018/200/200.jpg?hmac=uHjw5VeUXsbJBBE5Ywaumr-fxWyViVwI_GRwrA3AQ2Q",
                contentDescription = " description",
                modifier = Modifier
                    .height(180.dp)
                    .width(140.dp)
                    .padding(2.dp),
                contentScale = ContentScale.Fit
            )
            Column (
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)){
                product.description?.let { ProductNameWidget(title = it) }
                product.price?.let { ProductPrice(price = "Price  Rs $it") }
            }
        }
    }
}

@Composable
private fun ErrorScreen(errorMsg: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        errorMsg?.let { Text(text = it, textAlign = TextAlign.Center) }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(title: String) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        title = { Text(text = title, textAlign = TextAlign.Center) }
    )
}

@Composable
fun ProductNameWidget(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier.padding(4.dp),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProductPrice(price: String, modifier: Modifier = Modifier) {
    Text(
        text = price,
        modifier = modifier.padding(4.dp),
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold
    )
}