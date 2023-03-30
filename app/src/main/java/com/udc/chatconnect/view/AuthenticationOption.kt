

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.udc.chatconnect.ui.theme.ChatconnectTheme

@Composable
fun AuthenticationView(register: () -> Unit, login: () -> Unit) {
    ChatconnectTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Title(title = "⚡️ Chat Connect")
                Buttons(title = "Register", onClick = register, backgroundColor = Color.Blue)
                Buttons(title = "Login", onClick = login, backgroundColor = Color.Magenta)
            }
        }
    }
}