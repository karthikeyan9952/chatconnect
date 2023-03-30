package com.udc.chatconnect.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.udc.chatconnect.models.Contact
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactsScreen(navController: NavController) {
    var contacts by remember {
        mutableStateOf(
            listOf<Contact>(
                Contact(name = "Karthik", phone = "9990909990"),
                Contact(name = "Karthik", phone = "9990909990"),
                Contact(name = "Karthik", phone = "9990909990")
            )
        )
    }

    Scaffold(topBar = {
        TopAppBar() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBackIos, contentDescription = null)
                }
                Text(
                    text = "Choose a Cotact",
                    fontFamily = manrope,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.size(height = 0.dp, width = 24.dp))
            }
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            items(contacts) { contact ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    backgroundColor = Color.White,
                    elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(52.dp),
                                shape = RoundedCornerShape(100.dp),
                                backgroundColor = Primary
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(8.dp),
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = null,
                                    tint = Color.White
                                )

                            }
                            Spacer(modifier = Modifier.size(height = 0.dp, width = 8.dp))
                            Column() {
                                Text(
                                    text = contact.name,
                                    fontFamily = manrope,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.size(height = 4.dp, width = 0.dp))
                                Text(
                                    text = contact.phone,
                                    fontFamily = manrope,
                                    fontWeight = FontWeight.Light,
                                    color = Color.Black.copy(alpha = 0.6f)
                                )
                            }
                        }
                        Icon(
                            modifier = Modifier.padding(end = 8.dp),
                            imageVector = Icons.Filled.Chat,
                            contentDescription = null,
                            tint = Primary
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun ContactsScreenPrev() {
    ContactsScreen(navController = rememberNavController())
}