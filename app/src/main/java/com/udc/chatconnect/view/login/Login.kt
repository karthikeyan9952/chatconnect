package com.udc.chatconnect.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.R
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.widgets.TextH1


@Composable
fun LoginView(
    home: () -> Unit,
    back: () -> Unit,
    register: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {
    val email: String by loginViewModel.email.observeAsState("")
    val password: String by loginViewModel.password.observeAsState("")
    val loading: Boolean by loginViewModel.loading.observeAsState(initial = false)
    val isVisible: Boolean by loginViewModel.isVisible.observeAsState(false)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)

    ) {
        Spacer(modifier = Modifier.size(height = 2.dp, width = 0.dp))
        Card(
            modifier = Modifier.size(240.dp),
            shape = RoundedCornerShape(300.dp),

            ) {
            Image(
                painter = painterResource(R.drawable.messages), contentDescription = null
            )
        }

        Card(
            shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextH1(value = "Login")
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = email,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    label = {
                        Text(text = "Email", fontSize = 12.sp)
                    },
                    onValueChange = { loginViewModel.updateEmail(it) })
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = password,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    label = {
                        Text(text = "Password", fontSize = 12.sp)
                    },
                    visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { loginViewModel.toggleIsVisible() }) {
                            Icon(
                                imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = ""
                            )
                        }
                    },
                    onValueChange = { loginViewModel.updatePassword(it) })
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
                Button(modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    onClick = { }) {
                    Text(text = "Login", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account?", fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.size(height = 0.dp, width = 12.dp))
                    Text(
                        modifier = Modifier.clickable(onClick = register),
                        text = "Signup",
                        fontSize = 14.sp,
                        color = Primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
            }
        }

    }

//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        if (loading) {
//            CircularProgressIndicator()
//        }
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Top
//        ) {
//            Appbar(
//                title = "Login",
//                action = back
//            )
//            TextFormField(
//                value = email,
//                onValueChange = { loginViewModel.updateEmail(it) },
//                label = "Email",
//                keyboardType = KeyboardType.Email,
//                visualTransformation = VisualTransformation.None
//            )
//            TextFormField(
//                value = password,
//                onValueChange = { loginViewModel.updatePassword(it) },
//                label = "Password",
//                keyboardType = KeyboardType.Password,
//                visualTransformation = PasswordVisualTransformation()
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//            Buttons(
//                title = "Login",
//                onClick = { loginViewModel.loginUser(home = home) },
//                backgroundColor = Color.Magenta
//            )
//        }
//    }
}

@Preview
@Composable
fun LoginPrev() {
//    LoginView(home = { /*TODO*/ }, back = { /*TODO*/ })
}