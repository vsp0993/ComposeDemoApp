package com.composedemoapp.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.ContentAlpha
import com.composedemoapp.R
import com.composedemoapp.drawer.ComposeDemoDrawer
import com.composedemoapp.navigation.HomeBottomNavigation
import com.composedemoapp.navigation.HomeSections
import com.composedemoapp.ui.theme.ComposeDemoAppTheme

@Composable
fun ComposeDemoHome() {
    ComposeDemoAppTheme {
        val navHostController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            modifier = Modifier.statusBarsPadding(),
            bottomBar = { DemoAppBottomNavigation(navHostController = navHostController) },
        ) { paddingValues ->
            HomeBottomNavigation(Modifier.padding(paddingValues), navController = navHostController)
        }
    }
}

@Composable
fun DemoAppBottomNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant, modifier = modifier.height(70.dp)
    ) {
        NavigationBarItem(
            selected = currentDestination(navHostController) == HomeSections.FEED.route,
            onClick = {
                navHostController.navigate(HomeSections.FEED.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = if (currentDestination(navHostController) == HomeSections.FEED.route) {
                        MaterialTheme.colorScheme.primary // Change to selected color
                    } else {
                        LocalContentColor.current.copy(alpha = ContentAlpha.medium)
                    }
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            }
        )
        NavigationBarItem(
            selected = currentDestination(navHostController) == HomeSections.PRODUCT.route,
            onClick = {
                navHostController.navigate(HomeSections.PRODUCT.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = if (currentDestination(navHostController) == HomeSections.PRODUCT.route) {
                        MaterialTheme.colorScheme.primary // Change to selected color
                    } else {
                        LocalContentColor.current.copy(alpha = ContentAlpha.medium)
                    }
                )
            },
            label = {
                Text(text = stringResource(id = R.string.product))
            }
        )
        NavigationBarItem(
            selected = currentDestination(navHostController) == HomeSections.TRANSACTION.route,
            onClick = {
                navHostController.navigate(HomeSections.TRANSACTION.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Payment,
                    contentDescription = null,
                    tint = if (currentDestination(navHostController) == HomeSections.TRANSACTION.route) {
                        MaterialTheme.colorScheme.primary // Change to selected color
                    } else {
                        LocalContentColor.current.copy(alpha = ContentAlpha.medium)
                    }
                )
            },
            label = {
                Text(text = "Transaction")
            }
        )
        NavigationBarItem(
            selected = currentDestination(navHostController) == HomeSections.ACCOUNT.route,
            onClick = {
                navHostController.navigate(HomeSections.ACCOUNT.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = if (currentDestination(navHostController) == HomeSections.ACCOUNT.route) {
                        MaterialTheme.colorScheme.primary // Change to selected color
                    } else {
                        LocalContentColor.current.copy(alpha = ContentAlpha.medium)
                    }
                )
            },
            label = {
                Text(text = "Account")
            }
        )
    }
}

@Composable
fun currentDestination(navController: NavController): String? {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    return currentBackStackEntry?.destination?.route
}