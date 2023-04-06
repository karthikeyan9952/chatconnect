package com.udc.chatconnect.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.R
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope
import com.udc.chatconnect.view.widget.Description
import com.udc.chatconnect.view.widget.PText
import com.udc.chatconnect.view.widget.Title


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppInfoView(back: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.size(0.dp))
                Text(
                    text = "App Info",
                    fontFamily = manrope,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(42.dp))
            }
        }, navigationIcon = {
            IconButton(onClick = back) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        })

    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(32.dp))
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = " Team ID : NM2023TMID11706",
                    fontSize = 16.sp,
                    fontFamily = manrope,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = " Team Leader : KARTHIKEYAN G",
                    fontSize = 14.sp,
                    fontFamily = manrope,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = " Team Members",
                    fontSize = 16.sp,
                    fontFamily = manrope,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                PText(text = "MONIKA K")
                PText(text = "VIGNESH K")
                PText(text = "SHANMUGANATHAN P")
            }
            PText(text = "Version 1.1")
        }
    }
}