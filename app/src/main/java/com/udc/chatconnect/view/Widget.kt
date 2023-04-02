package com.udc.chatconnect.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

import com.udc.chatconnect.view.*
import com.udc.chatconnect.view.login.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun Title(title: String) {
    Text(


        text = title, fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = manrope
    )
}

@Composable
fun Description(desc: String) {
    Text(
        text = desc, fontSize = 15.sp, fontFamily = manrope
    )
}

@Composable
fun ClickableTxt(text: String, onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable(onClick = onClick),
        text = text,
        fontSize = 14.sp,
        color = Primary,
        fontWeight = FontWeight.SemiBold,
        fontFamily = manrope
    )
}

@Composable
fun PText(text: String) {
    Text(
        text = text, fontSize = 14.sp, fontFamily = manrope
    )
}

@Composable
fun LabelTxt(text: String) {
    Text(text = text, fontSize = 12.sp, fontFamily = manrope)
}

@Composable
fun TextH1(value: String) {
    Text(
        text = value,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Primary,
        fontFamily = manrope
    )
}


@Composable
fun ButtonPrimary(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12),
    ) {
        Text(
            text = title, fontFamily = manrope, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ButtonSecondary(title: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.dp, Primary),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent, contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12),
    ) {
        Text(
            text = title,
            fontFamily = manrope,
            fontSize = 16.sp,
            color = Primary,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun Appbar(title: String, action: () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = title, fontFamily = manrope, fontWeight = FontWeight.Bold)
            }
        },
        actions = {
            IconButton(onClick = { showMenu = true }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = action) {
                    Row {
                        Text("Logout", fontFamily = manrope, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Logout, contentDescription = "Logout", tint = Primary)
                    }
                }
            }
        },
        navigationIcon = { Spacer(modifier = Modifier.size(24.dp)) }
    )
}


@Composable
fun SingleMessage(message: String, isCurrentUser: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start
    ) {
        Card(
            shape = if (isCurrentUser) RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 0.dp,
                bottomStart = 32.dp,
                bottomEnd = 32.dp
            ) else RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 32.dp,
                bottomStart = 32.dp,
                bottomEnd = 32.dp
            ),
            backgroundColor = if (isCurrentUser) MaterialTheme.colors.primary else Color.White,
            elevation = 2.dp
        ) {
            Text(
                text = message,
                fontFamily = manrope,
                textAlign = if (isCurrentUser) TextAlign.End
                else TextAlign.Start,
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 18.dp),
                color = if (!isCurrentUser) MaterialTheme.colors.primary else Color.White
            )
        }
    }
}

@Composable
fun TextFieldPassword(
    text: String,
    onValueChange: (String) -> Unit,
    toggleVisible: () -> Unit,
    label: String,
    isVisible: Boolean
) {

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
        ),
        label = { LabelTxt(text = label) },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        trailingIcon = {
            IconButton(onClick = toggleVisible) {
                Icon(
                    imageVector = if (isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = ""
                )
            }
        },
        onValueChange = onValueChange
    )
}

@Composable
fun TextFieldAuth(
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        label = {
            LabelTxt(text = label)
        },
        onValueChange = onValueChange
    )
}

@Composable
fun Loader() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun TextFieldMessage(message: String, onValueChange: (String) -> Unit, send: () -> Unit) {
    TextField(
        value = message,
        onValueChange = onValueChange,
        placeholder = {
            Text("Type Your Message", fontFamily = manrope, fontSize = 14.sp)
        },
        maxLines = 1,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = send
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send Button",
                    tint = Primary
                )
            }
        },
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Primary.copy(alpha = 0.15f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            cursorColor = Primary,
        ),
    )
}


fun toastMessage(text: String, context: Context) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_SHORT
    ).show()
}