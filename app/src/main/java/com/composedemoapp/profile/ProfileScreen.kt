package com.composedemoapp.profile

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.composedemoapp.R

@Composable
fun ProfileScreen(

) {
    Image(painter = painterResource(id = R.drawable.ic_sign_up), contentDescription = null)
}