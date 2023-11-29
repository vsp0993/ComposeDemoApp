package com.composedemoapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composedemoapp.home.ComposeDemoHome
import com.composedemoapp.loginsignup.CreateAccountScreen
import com.composedemoapp.loginsignup.LoginScreen
import com.composedemoapp.loginsignup.SignUpScreen
import com.composedemoapp.loginsignup.SignUpViewModel
import com.composedemoapp.loginsignup.SignUpViewModelFactory
import com.composedemoapp.navigation.Destinations.CREATE_ACCOUNT_ROUTE
import com.composedemoapp.navigation.Destinations.HOME_ROUTE
import com.composedemoapp.navigation.Destinations.LOGIN_ROUTE
import com.composedemoapp.navigation.Destinations.WELCOME_ROUTE

object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val CREATE_ACCOUNT_ROUTE = "create_account"
    const val LOGIN_ROUTE = "login"
    const val HOME_ROUTE = "home"
}

@Composable
fun LoginNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE,
    ) {
        composable(route = WELCOME_ROUTE) {
            CreateAccountLoginRoute(
                onNavigateToCreateAccount = {
                    navController.navigate(CREATE_ACCOUNT_ROUTE)
                },
                onNavigateToLogin = {
                    navController.navigate(LOGIN_ROUTE)
                }
            )
        }

        composable(CREATE_ACCOUNT_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            CreateAccountScreen(
                email = startingEmail,
                onSignUpSubmitted = {fullName,email,password ->
                    navController.navigate(HOME_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(LOGIN_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            LoginScreen(
                email = startingEmail,
                onSignInSubmitted = {email,password ->
                    navController.navigate(HOME_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(HOME_ROUTE){
            ComposeDemoHome()
        }
    }
}


@Composable
fun CreateAccountLoginRoute(
    onNavigateToCreateAccount: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    val signUpViewModel: SignUpViewModel = viewModel(factory = SignUpViewModelFactory())
    SignUpScreen(
        onCreateAccount = {
            signUpViewModel.goToCreateAccountScreen(
                onNavigateToCreateAccount = onNavigateToCreateAccount
            ) },
        onLogin = { signUpViewModel.goToLoginScreen(onNavigateToLogin) }
    )
}