package com.composedemoapp.loginsignup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composedemoapp.R
import com.composedemoapp.ui.theme.ComposeDemoAppTheme

@Composable
fun SignUpScreen(
    onCreateAccount: () -> Unit,
    onLogin: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .widthIn(max = 840.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_sign_up),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 70.dp)

            )
            Text(
                text = "Stay on top of your finance with us.",
                style = TextStyle(
                    fontSize = 34.sp,
//                fontFamily = FontFamily(Font(R.font.se)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                ),
            )

            Text(
                text = "We are your new financial Advisors to recommend the best investments for you.",
                style = TextStyle(
                    fontSize = 17.sp,
                    lineHeight = 22.sp,
//                fontFamily = FontFamily(Font(R.font.sf pro text)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF4F4F4F),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(top = 17.dp)
            )
            val login = {
                onLogin()
            }

            ElevatedButton(
                onClick = {
                    onCreateAccount()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_green)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 79.dp,
                        bottom = 3.dp
                    )
            ) {
                Text(
                    text = "Create account",
                    style = TextStyle(
                        fontSize = 17.sp,
                        //   fontFamily = FontFamily(Font(R.font.sf pro text)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                )

            }
            TextButton(onClick = {
                login()
            }) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 17.sp,
                        //  fontFamily = FontFamily(Font(R.font.sf pro text)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF31A062),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    ComposeDemoAppTheme {
        SignUpScreen(
            onCreateAccount = {},
            onLogin = {}
        )
    }
}