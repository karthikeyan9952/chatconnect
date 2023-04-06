package com.udc.chatconnect.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.udc.chatconnect.navigation.Destination.AppInfo
import com.udc.chatconnect.navigation.Destination.AuthenticationOption
import com.udc.chatconnect.navigation.Destination.Home
import com.udc.chatconnect.navigation.Destination.Login
import com.udc.chatconnect.navigation.Destination.Register


object Destination {
    const val AuthenticationOption = "authenticationOption"
    const val Register = "register"
    const val Login = "login"
    const val Home = "home"
    const val AppInfo = "appInfo"
}

class Action(navController: NavHostController) {
    val home: () -> Unit = {
        navController.navigate(Home) {
            popUpTo(Login) {
                inclusive = true
            }
            popUpTo(Register) {
                inclusive = true
            }
        }
    }
    val login: () -> Unit = { navController.navigate(Login) }
    val register: () -> Unit = { navController.navigate(Register) }
    val navigateBack: () -> Unit = { navController.popBackStack() }

    val replaceLoginWithRegister: () -> Unit = {  navController.navigate(
        Login,
        NavOptions.Builder()
            .setPopUpTo(Register, inclusive = true)
            .setLaunchSingleTop(true)
            .build()
    ) }

    val replaceRegisterWithLogin: () -> Unit = {  navController.navigate(
        Register,
        NavOptions.Builder()
            .setPopUpTo(Login, inclusive = true)
            .setLaunchSingleTop(true)
            .build()
    ) }

    val gotoLanding: () -> Unit = {  navController.navigate(
        AuthenticationOption,
        NavOptions.Builder()
            .setPopUpTo(Home, inclusive = true)
            .setLaunchSingleTop(true)
            .build()
    ) }

    val forwardHomeInLogin: () -> Unit = {  navController.navigate(
        Home,
        NavOptions.Builder()
            .setPopUpTo(Login, inclusive = true)
            .setLaunchSingleTop(true)
            .build()
    ) }

    val forwardHomeInRegister: () -> Unit = {  navController.navigate(
        Home,
        NavOptions.Builder()
            .setPopUpTo(Register, inclusive = true)
            .setLaunchSingleTop(true)
            .build()
    ) }

    val goToAppInfo: () -> Unit = { navController.navigate(AppInfo) }
}