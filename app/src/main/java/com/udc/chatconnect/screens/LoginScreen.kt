package com.udc.chatconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.udc.chatconnect.navigation.Screens
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope
import com.udc.chatconnect.ui.theme.pacifico
import com.udc.chatconnect.widgets.TextH1

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(false)
    }

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
                    onValueChange = { value -> email = value })
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = pwd,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                    label = {
                        Text(text = "Password", fontSize = 12.sp)
                    },
                    visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isVisible = !isVisible }) {
                            Icon(
                                imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                contentDescription = ""
                            )
                        }
                    },
                    onValueChange = { value -> pwd = value })
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
                Button(modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    onClick = { navController.navigate(Screens.Contacts.route) }) {
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
                        modifier = Modifier.clickable { navController.navigate(route = Screens.Signup.route) },
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
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}

