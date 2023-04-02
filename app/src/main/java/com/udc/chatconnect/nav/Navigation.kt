import Destination.AuthenticationOption
import Destination.Home
import Destination.Login
import Destination.Register
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions


/**
 * A set of destination used in the whole application
 */
object Destination {
    const val AuthenticationOption = "authenticationOption"
    const val Register = "register"
    const val Login = "login"
    const val Home = "home"
}

/**
 * Set of routes which will be passed to different composable so that
 * the routes which are required can be taken.
 */
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
}