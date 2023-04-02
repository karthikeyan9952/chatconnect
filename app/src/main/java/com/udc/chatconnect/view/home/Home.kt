package com.udc.chatconnect.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.Constants
import com.udc.chatconnect.view.Appbar
import com.udc.chatconnect.view.SingleMessage
import com.udc.chatconnect.view.TextFieldMessage


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeView(
    homeViewModel: HomeViewModel = viewModel(),
    landing: () -> Unit
) {
    val message: String by homeViewModel.message.observeAsState(initial = "")
    val messages: List<Map<String, Any>> by homeViewModel.messages.observeAsState(
        initial = emptyList<Map<String, Any>>().toMutableList()
    )
    val context = LocalContext.current

    Scaffold(
        topBar = {
            Appbar(
                title = "ChatConnect",
                action = { homeViewModel.logoutUser(landing = landing, context = context) })
        },
        bottomBar = {
            TextFieldMessage(
                message = message,
                onValueChange = { homeViewModel.updateMessage(it) },
                send = { homeViewModel.addMessage() })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            reverseLayout = true
        ) {
            items(messages) { message ->
                val isCurrentUser = message[Constants.IS_CURRENT_USER] as Boolean
                SingleMessage(
                    message = message[Constants.MESSAGE].toString(),
                    isCurrentUser = isCurrentUser
                )
            }
        }
    }
}

