package com.udc.chatconnect.view.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope

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
                    imageVector = if (!isVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = ""
                )
            }
        },
        onValueChange = onValueChange
    )
}
