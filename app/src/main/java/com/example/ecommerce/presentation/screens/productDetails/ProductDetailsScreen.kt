package com.example.ecommerce.presentation.screens.productDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.ecommerce.data.domainModels.products.ProductListResponseDomain
import com.example.ecommerce.presentation.screens.productDetails.mvi.BeerDetailsScreenIntent
import com.example.ecommerce.ui.widgets.LoadingScreen

@Composable
fun ProductDetailsScreen(selectedBeerId: Int?, navController: NavHostController) {
    val productDetailsViewModel = hiltViewModel<ProductDetailsViewModel>()
    val state = productDetailsViewModel.state.collectAsState().value

    LaunchedEffect(key1 =  Unit ){
        productDetailsViewModel.processIntent(
            BeerDetailsScreenIntent.LoadBeerDetails,
            selectedBeerId
        )
    }
    Scaffold(topBar = {
        ToolBar(title = "Product Details") {
            navController.popBackStack()
        }
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            when {
                state.isLoading -> {
                    LoadingScreen()
                }

                state.productDetails != null -> {
                    ProductDetailsScreenContent(state.productDetails)
                }

                state.errorMessage != null -> {
                    ErrorScreen(state.errorMessage)
                }

            }
        }
    }
}

@Composable
fun ProductDetailsScreenContent(product: ProductListResponseDomain.ProductListResponseItemDomain) {
    Column (modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        product.image?.let { ProductDetailsImage(backDropUrl = it) }
        product.name?.let { ProductDetailsTitle(title = it) }
        product.price?.let { TagLineText(text = it.toString()) }
        product.description?.let { ProductDetailsDescription(title = it) }

    }
}

@Composable
fun ProductDetailsImage(
    backDropUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    AsyncImage(
        model = backDropUrl,
        contentDescription = contentDescription,
        modifier = modifier.padding(16.dp),
        contentScale = contentScale
    )
}

@Composable
fun ProductDetailsTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProductDetailsDescription(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier.padding(16.dp),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun TagLineText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.padding(4.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ToolBar(
    title: String,
    onNavigationClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Navigation icon"
                )
            }
        },
        title = { Text(text = title, textAlign = TextAlign.Center) }
    )
}


@Composable
private fun ErrorScreen(errorMsg: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        errorMsg?.let { Text(text = it, textAlign = TextAlign.Center) }
    }
}