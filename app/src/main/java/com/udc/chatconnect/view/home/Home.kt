package com.udc.chatconnect.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.Constants
import com.udc.chatconnect.view.Appbar
import com.udc.chatconnect.view.SingleMessage
import com.udc.chatconnect.view.SingleMessageWithDate
import com.udc.chatconnect.view.TextFieldMessage
import java.text.SimpleDateFormat
import java.util.*


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
    var tmpDate =SimpleDateFormat("MM/dd/yyyy").parse("10/10/2023")

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
            itemsIndexed(messages) { index, message ->
                val isCurrentUser = message[Constants.IS_CURRENT_USER] as Boolean
                val timeStamp = message[Constants.SENT_ON].toString().toLong()

                SingleMessageWithDate(
                    message = message[Constants.MESSAGE].toString(),
                    timestamp = homeViewModel.convertLongToTime(timeStamp),
                    isCurrentUser = isCurrentUser,
                    isLast = index == 0,
                    date = homeViewModel.convertLongToTime(timeStamp)
                )

            }
        }
    }
}

