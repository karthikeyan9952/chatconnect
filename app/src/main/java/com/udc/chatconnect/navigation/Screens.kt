package com.udc.chatconnect.navigation

sealed class Screens(val route: String) {
    object Login : Screens("login_screen")
    object Signup : Screens("signup_screen")
}
