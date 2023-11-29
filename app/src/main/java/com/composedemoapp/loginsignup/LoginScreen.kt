package com.composedemoapp.loginsignup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composedemoapp.R
import com.composedemoapp.common.TopAppBar
import com.composedemoapp.ui.theme.ComposeDemoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    email: String?,
    onSignInSubmitted: (email: String, password: String) -> Unit,
    onNavUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                topAppBarText = "Login",
                onNavUp = onNavUp,
            )
        },
        content = { contentPadding ->
            SignInScreen(
                contentPadding = contentPadding,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .widthIn(max = 840.dp)
            ) {
                Column {
                    SignInContent(
                        email = email,
                        onSignInSubmitted = onSignInSubmitted
                    )
                }
            }

        }
    )
}

@Composable
fun SignInContent(
    email: String?,
    onSignInSubmitted: (email: String, password: String) -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val passwordFocusRequest = remember { FocusRequester() }
        Spacer(modifier = Modifier.height(8.dp))

        val emailState = remember { EmailState(email) }
        Email(emailState, onImeAction = { passwordFocusRequest.requestFocus() })

        Spacer(modifier = Modifier.height(16.dp))
        val passwordState = remember { PasswordState() }

        val onSubmit = {
            if (emailState.isValid && passwordState.isValid) {
                onSignInSubmitted(emailState.text, passwordState.text)
            }
        }
        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            imeAction = ImeAction.Done,
            onImeAction = { onSubmit() },
            modifier = Modifier.focusRequester(passwordFocusRequest)
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(
//            onClick = {
//                onSignUpSubmitted(
//                    fullNameState.text,
//                    emailState.text,
//                    passwordState.text
//                )
//            },
            onClick = { onSubmit() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = emailState.isValid &&
                    passwordState.isValid
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }


}


@Preview(widthDp = 1024)
@Composable
fun LoginScreenPreview() {
    ComposeDemoAppTheme {
        CreateAccountScreen(
            email = null,
            onSignUpSubmitted = { _, _, _ -> },
            onNavUp = {},
        )
    }
}

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        item {
            Spacer(modifier = Modifier.height(44.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                content()
            }
        }
    }
}