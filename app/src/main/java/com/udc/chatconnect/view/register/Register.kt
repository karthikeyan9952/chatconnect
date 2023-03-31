package com.udc.chatconnect.view.register

import Action
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
import androidx.compose.runtime.remember
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
import androidx.navigation.compose.rememberNavController
import com.udc.chatconnect.ui.theme.Primary
import androidx.compose.runtime.*
import com.udc.chatconnect.R


@Composable
fun RegisterView(
    home: () -> Unit,
    back: () -> Unit,
    login: () -> Unit,
    registerViewModel: RegisterViewModel = viewModel()
) {
    val email: String by registerViewModel.email.observeAsState("")
    val password: String by registerViewModel.password.observeAsState("")
    val confirmpassword: String by registerViewModel.confirmpassword.observeAsState("")
    val isVisible: Boolean by registerViewModel.isVisible.observeAsState(false)
    val isVisibleConfirm: Boolean by registerViewModel.isVisibleConfrim.observeAsState(false)
    val loading: Boolean by registerViewModel.loading.observeAsState(initial = false)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)

    ) {
        Spacer(modifier = Modifier.size(height = 2.dp, width = 0.dp))
        Card(
            modifier = Modifier
                .size(240.dp),
            shape = RoundedCornerShape(300.dp),

            ) {
            Image(
                painter = painterResource(R.drawable.messages),
                contentDescription = null
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
                Text(
                    text = "Signup",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = email,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    label = {
                        Text(text = "Email", fontSize = 12.sp)
                    },
                    onValueChange = { registerViewModel.updateEmail(it) })
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
                        IconButton(onClick = { registerViewModel.toggleIsVisible() }) {
                            Icon(
                                imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = ""
                            )
                        }
                    },
                    onValueChange = { registerViewModel.updatePassword(it) })
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = confirmpassword,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    label = {
                        Text(text = "Confirm Password", fontSize = 12.sp)
                    },
                    visualTransformation = if (isVisibleConfirm) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { registerViewModel.toggleIsVisibleConfirmation() }) {
                            Icon(
                                imageVector = if (isVisibleConfirm) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = ""
                            )
                        }
                    },
                    onValueChange = { registerViewModel.updateConfirmPassword(it) })
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
                Button(modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    onClick = { registerViewModel.registerUser(home = home) }) {
                    Text(text = "Signup", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.size(height = 0.dp, width = 12.dp))
                    Text(
                        modifier = Modifier.clickable(onClick = login),
                        text = "Login",
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
//                title = "Register",
//                action = back
//            )
//            TextFormField(
//                value = email,
//                onValueChange = { registerViewModel.updateEmail(it) },
//                label = "Email",
//                keyboardType = KeyboardType.Email,
//                visualTransformation = VisualTransformation.None
//            )
//            TextFormField(
//                value = password,
//                onValueChange = { registerViewModel.updatePassword(it) },
//                label = "Password",
//                keyboardType = KeyboardType.Password,
//                visualTransformation = PasswordVisualTransformation()
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//            Buttons(
//                title = "Register",
//                onClick = { registerViewModel.registerUser(home = home) },
//                backgroundColor = Color.Blue
//            )
//        }
//    }
}

@Preview
@Composable
fun RegPreview() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    RegisterView(
        home = actions.home,
        back = actions.navigateBack,
        login = actions.login
    )
}