package com.composedemoapp.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.composedemoapp.navigation.LoginNavHost
import com.composedemoapp.ui.theme.ComposeDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoAppTheme {
                // A surface container using the 'background' color from the theme
                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(mainViewModel = mainViewModel)
            }
        }
    }

    @Composable
    fun MainScreen(
        mainViewModel: MainViewModel
    ) {
        Surface() {

            val transitionState =
                remember { MutableTransitionState(mainViewModel.shownSplash.value) }
            val transition = updateTransition(transitionState, label = "splashTransition")
            val splashAlpha by transition.animateFloat(
                transitionSpec = { tween(durationMillis = 100) }, label = "splashAlpha"
            ) {
                if (it == SplashState.Shown) 1f else 0f
            }

            val contentAlpha by transition.animateFloat(
                transitionSpec = { tween(durationMillis = 300) }, label = "contentAlpha"
            ) {
                if (it == SplashState.Shown) 0f else 1f
            }
            val contentTopPadding by transition.animateDp(
                transitionSpec = { spring(stiffness = Spring.StiffnessLow) },
                label = "contentTopPadding"
            ) {
                if (it == SplashState.Shown) 100.dp else 0.dp
            }


            Box {
                SplashScreen(
                    modifier = Modifier.alpha(splashAlpha),
                    onTImeOut = {
                        transitionState.targetState = SplashState.Completed
                        mainViewModel.shownSplash.value = SplashState.Completed
                    }
                )

                MainContent(
                    modifier = Modifier.alpha(contentAlpha),
                    topPadding = contentTopPadding,
                    viewModel = mainViewModel
                )
            }
        }
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    viewModel: MainViewModel
) {
    Column(modifier = modifier) {
        Spacer(Modifier.padding(top = topPadding))
        LoginNavHost()
    }
}

enum class SplashState { Shown, Completed }