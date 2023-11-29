package com.composedemoapp.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.composedemoapp.R
import com.composedemoapp.ui.theme.ComposeDemoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeDemoHome() {
    ComposeDemoAppTheme {
        Scaffold(
            bottomBar = { DemoAppBottomNavigation() }
        ) { paddingValues ->
            HomeScreen(Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

}

@Composable
fun DemoAppBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant, modifier = modifier.height(70.dp)
    ) {
        NavigationBarItem(selected = true, onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = Color(0xFF31A062)
                )
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            }
        )
        NavigationBarItem(selected = false, onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = R.string.product))
            }
        )
        NavigationBarItem(selected = true, onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Payment,
                    contentDescription = null,
                )
            },
            label = {
                Text(text = "Transaction")
            }
        )
        NavigationBarItem(selected = true, onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Account")
            }
        )
    }
}