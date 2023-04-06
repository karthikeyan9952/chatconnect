package com.udc.chatconnect.view.register

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.R
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.view.widget.*


@Composable
fun RegisterView(
    home: () -> Unit,
    login: () -> Unit,
    registerViewModel: RegisterViewModel = viewModel()
) {
    val email: String by registerViewModel.email.observeAsState("")
    val password: String by registerViewModel.password.observeAsState("")
    val confirmpassword: String by registerViewModel.confirmpassword.observeAsState("")
    val isVisible: Boolean by registerViewModel.isVisible.observeAsState(false)
    val isVisibleConfirm: Boolean by registerViewModel.isVisibleConfrim.observeAsState(false)
    val loading: Boolean by registerViewModel.loading.observeAsState(initial = false)
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
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextH1(value = "Signup")
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                TextFieldAuth(
                    text = email,
                    onValueChange = { registerViewModel.updateEmail(it) },
                    label = "Email"
                )
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextFieldPassword(
                    text = password,
                    onValueChange = { registerViewModel.updatePassword(it) },
                    toggleVisible = { registerViewModel.toggleIsVisible() },
                    label = "Password",
                    isVisible = isVisible
                )
                Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
                TextFieldPassword(
                    text = confirmpassword,
                    onValueChange = { registerViewModel.updateConfirmPassword(it) },
                    toggleVisible = { registerViewModel.toggleIsVisibleConfirmation() },
                    label = "Confirm Password",
                    isVisible = isVisibleConfirm
                )
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
                if (loading) Loader() else ButtonPrimary(
                    title = "Signup",
                    onClick = {
                        if (email.isEmpty()) toastMessage(
                            "Email is Empty",
                            context
                        ) else if (password.isEmpty()) toastMessage(
                            "Password is empty",
                            context
                        ) else if (password != confirmpassword) toastMessage(
                            "Passwords not matching",
                            context
                        ) else registerViewModel.registerUser(home = home)
                    })
                Spacer(modifier = Modifier.size(height = 36.dp, width = 0.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    PText(text = "Already have an account?")
                    Spacer(modifier = Modifier.size(height = 0.dp, width = 6.dp))
                    ClickableTxt(text = "Login", onClick = login)
                }
                Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
            }
        }

    }

}
