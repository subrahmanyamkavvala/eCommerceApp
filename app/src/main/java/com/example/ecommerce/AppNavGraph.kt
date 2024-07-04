package com.example.ecommerce

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerce.presentation.screens.productDetails.ProductDetailsScreen
import com.example.ecommerce.presentation.screens.productList.ProductsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.PRODUCTS.route) {
        composable(route = NavRoute.PRODUCTS.route) {
            ProductsScreen(navController)
        }
        composable(route = NavRoute.PRODUCTDETAILS.route + "/{product_id}") { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getString("product_id")
            ProductDetailsScreen(productid = productId, navController = navController)
        }

    }
}


enum class NavRoute(val route: String) {
    PRODUCTS("products"),
    PRODUCTDETAILS("productDetails")
}