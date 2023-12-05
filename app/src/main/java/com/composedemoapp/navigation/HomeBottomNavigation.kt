package com.composedemoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composedemoapp.home.FeedScreen
import com.composedemoapp.profile.ProfileScreen


enum class HomeSections(
    val route: String
) {
    FEED("home/feed"),
    PRODUCT("home/product"),
    TRANSACTION("home/transaction"),
    ACCOUNT("home/account")
}


@Composable
fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeSections.FEED.route
    ) {
        composable(route = HomeSections.FEED.route) {
            FeedScreen()
        }

        composable(route = HomeSections.PRODUCT.route) {

        }

        composable(route = HomeSections.TRANSACTION.route) {

        }

        composable(route = HomeSections.ACCOUNT.route) {
            ProfileScreen()
        }
    }

}