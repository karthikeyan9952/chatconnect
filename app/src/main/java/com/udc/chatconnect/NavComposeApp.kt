package com.udc.chatconnect

import Action
import AuthenticationView
import Destination.AuthenticationOption
import Destination.Home
import Destination.Login
import Destination.Register
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.udc.chatconnect.ui.theme.ChatconnectTheme
import com.udc.chatconnect.view.home.HomeView
import com.udc.chatconnect.view.login.LoginView
import com.udc.chatconnect.view.register.RegisterView

@Composable
fun NavComposeApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    ChatconnectTheme {
        NavHost(
            navController = navController,
            startDestination =
            if (FirebaseAuth.getInstance().currentUser != null)
                Home
            else
                AuthenticationOption
        ) {
            composable(AuthenticationOption) {
                AuthenticationView(
                    register = actions.register,
                    login = actions.login
                )
            }
            composable(Register) {
                RegisterView(
                    home = actions.home,
                    back = actions.navigateBack,
                    login = actions.login
                )
            }
            composable(Login) {
                LoginView(
                    home = actions.home,
                    back = actions.navigateBack,
                    register = actions.register
                )
            }
            composable(Home) {
                HomeView()
            }
        }
    }
}