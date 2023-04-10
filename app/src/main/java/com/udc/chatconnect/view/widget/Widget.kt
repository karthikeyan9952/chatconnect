package com.udc.chatconnect.view.widget


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope


@Composable
fun Appbar(title: String, logout: () -> Unit, about: () -> Unit) {
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
            DropdownMenu(modifier = Modifier.padding(horizontal = 14.dp),
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = about) {
                    Row {
                        Text("About", fontFamily = manrope, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Outlined.Info, contentDescription = "Logout", tint = Primary)
                    }
                }
                DropdownMenuItem(onClick = logout) {
                    Row {
                        Text("Logout", fontFamily = manrope, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Outlined.Logout, contentDescription = "Logout", tint = Primary)
                    }
                }
            }
        },
        navigationIcon = { Spacer(modifier = Modifier.size(24.dp)) }
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


fun toastMessage(text: String, context: Context) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_SHORT
    ).show()
}