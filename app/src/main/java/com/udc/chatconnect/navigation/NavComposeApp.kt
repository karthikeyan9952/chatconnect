package com.udc.chatconnect.navigation

import AuthenticationView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.udc.chatconnect.navigation.Destination.AppInfo
import com.udc.chatconnect.navigation.Destination.AuthenticationOption
import com.udc.chatconnect.navigation.Destination.Home
import com.udc.chatconnect.navigation.Destination.Login
import com.udc.chatconnect.navigation.Destination.Register
import com.udc.chatconnect.ui.theme.ChatconnectTheme
import com.udc.chatconnect.view.AppInfoView
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
                    home = actions.forwardHomeInRegister,
                    login = actions.replaceLoginWithRegister
                )
            }
            composable(Login) {
                LoginView(
                    home = actions.forwardHomeInLogin,
                    register = actions.replaceRegisterWithLogin,
                    pop = actions.navigateBack
                )
            }
            composable(Home) {
                HomeView(landing = actions.gotoLanding, appInfo = actions.goToAppInfo)
            }
            composable(AppInfo) {
                AppInfoView(back = actions.navigateBack)
            }
        }
    }
}

