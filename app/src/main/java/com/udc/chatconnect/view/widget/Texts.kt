package com.udc.chatconnect.view.widget

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.ui.theme.Primary
import com.udc.chatconnect.ui.theme.manrope

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
