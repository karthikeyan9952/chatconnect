package com.udc.chatconnect.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope

@Composable
fun TextH1(value:String) {
    Text(
        text = value,
        fontSize = 32.sp,
        fontWeight = FontWeight.SemiBold,
        color = Primary,
        fontFamily = manrope
    )
}