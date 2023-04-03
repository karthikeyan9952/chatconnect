package com.udc.chatconnect.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.R
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.view.*


@Composable
fun LoginView(
    home: () -> Unit,
    pop: () -> Unit,
    register: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {
    val email: String by loginViewModel.email.observeAsState("")
    val password: String by loginViewModel.password.observeAsState("")
    val loading: Boolean by loginViewModel.loading.observeAsState(initial = false)
    val isVisible: Boolean by loginViewModel.isVisible.observeAsState(false)
    val context = LocalContext.current


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
                modifier = Modifier.padding(8.dp),
                painter = painterResource(R.drawable.messages), contentDescription = null
            )
        }

        Card(
            shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextH1(value = "Login")
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                TextFieldAuth(
                    text = email,
                    onValueChange = { loginViewModel.updateEmail(it) },
                    label = "Email"
                )
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextFieldPassword(
                    text = password,
                    onValueChange = { loginViewModel.updatePassword(it) },
                    toggleVisible = { loginViewModel.toggleIsVisible() },
                    label = "Password",
                    isVisible = isVisible
                )
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
                if (loading) Loader() else ButtonPrimary(
                    title = "Login",
                    onClick = {
                        if (email.isEmpty()) toastMessage(
                            "Email is empty",
                            context
                        ) else if (password.isEmpty()) toastMessage(
                            "Password is empty",
                            context
                        ) else loginViewModel.loginUser(home = home)
                    })
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    PText(text = "Don't have an account?")
                    Spacer(modifier = Modifier.size(height = 0.dp, width = 6.dp))
                    ClickableTxt(text = "Signup", onClick = register)
                }
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
            }
        }

    }

}
