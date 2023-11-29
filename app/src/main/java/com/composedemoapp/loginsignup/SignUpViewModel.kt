package com.composedemoapp.loginsignup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignUpViewModel : ViewModel() {

    fun goToCreateAccountScreen(
        onNavigateToCreateAccount: () -> Unit,
    ) {
        onNavigateToCreateAccount()
    }

    fun goToLoginScreen(
        onNavigateToLoginScreen:() ->Unit
    ){
        onNavigateToLoginScreen()
    }
}



class SignUpViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}