package com.composedemoapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.composedemoapp.R
import com.composedemoapp.ui.theme.ComposeDemoAppTheme
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onTImeOut: () -> Unit) {

    val currentTimeOut by rememberUpdatedState(newValue = onTImeOut)

    LaunchedEffect(Unit) {
        delay(SplashWaitTime)
        currentTimeOut()
    }
    Image(
        painter = painterResource(id = R.drawable.ic_crane_drawer),
        contentDescription = null,
        modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview
@Composable
fun SplashScreenPreview(){
    ComposeDemoAppTheme {
        SplashScreen{}
    }
}