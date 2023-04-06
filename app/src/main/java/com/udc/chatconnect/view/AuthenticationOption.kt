import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udc.chatconnect.R
import com.udc.chatconnect.ui.theme.ChatconnectTheme
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.view.widget.ButtonPrimary
import com.udc.chatconnect.view.widget.ButtonSecondary
import com.udc.chatconnect.view.widget.Description
import com.udc.chatconnect.view.widget.Title

@Composable
fun AuthenticationView(register: () -> Unit, login: () -> Unit) {
    ChatconnectTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.chat_icon_2),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(
                                Primary
                            ),
                            modifier = Modifier.height(46.dp)
                        )
                        Title(title = "Chat Connect")
                        Description(desc = "A Real-Time Chat And Communication App")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ButtonSecondary(title = "Signup", onClick = register)
                    Spacer(modifier = Modifier.height(12.dp))
                    ButtonPrimary(title = "Login", onClick = login)
                }
            }
        }
    }
}

@Preview
@Composable
fun AuthPrev() {
    AuthenticationView(register = { /*TODO*/ }) {

    }
}
