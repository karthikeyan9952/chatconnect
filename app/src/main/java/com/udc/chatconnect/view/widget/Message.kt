package com.udc.chatconnect.view.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope
import com.udc.chatconnect.view.home.HomeViewModel


@Composable
fun SingleMessage(
    homeViewModel: HomeViewModel = viewModel(),
    message: String,
    timestamp: String,
    isCurrentUser: Boolean,
    isLast: Boolean
) {
    val isSending: Boolean by homeViewModel.isSending.observeAsState(false)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
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
            Row(
                modifier = Modifier
                    .padding(vertical = 14.dp, horizontal = 18.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = message,
                    fontFamily = manrope,
                    textAlign = if (isCurrentUser) TextAlign.End
                    else TextAlign.Start,
                    color = if (!isCurrentUser) MaterialTheme.colors.primary else Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = timestamp,
                    fontFamily = manrope,
                    textAlign = if (isCurrentUser) TextAlign.End
                    else TextAlign.Start,
                    color = if (!isCurrentUser) MaterialTheme.colors.primary else Color.White,
                    fontSize = 10.sp
                )
            }
        }
        if (isCurrentUser && isLast && isSending) Icon(
            Icons.Outlined.Send,
            contentDescription = "Sending",
            tint = Primary
        ) else Spacer(
            modifier = Modifier.width(0.dp)
        )
    }
}

@Composable
fun SingleMessageWithDate(
    homeViewModel: HomeViewModel = viewModel(),
    message: String,
    timestamp: String,
    isCurrentUser: Boolean,
    isLast: Boolean,
    date: String
) {
    val isSending: Boolean by homeViewModel.isSending.observeAsState(false)

    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = date,
                fontFamily = manrope,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Card(
                shape = if (isCurrentUser) RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp,
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                ) else RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp,
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                ),
                backgroundColor = if (isCurrentUser) MaterialTheme.colors.primary else Color.White,
                elevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = message,
                        fontFamily = manrope,
                        textAlign = if (isCurrentUser) TextAlign.End
                        else TextAlign.Start,
                        color = if (!isCurrentUser) MaterialTheme.colors.primary else Color.White
                    )
                }
            }
            if (isCurrentUser && isLast && isSending) Icon(
                Icons.Outlined.Send,
                contentDescription = "Sending",
                tint = Primary
            ) else Spacer(
                modifier = Modifier.width(0.dp)
            )
        }
    }
}