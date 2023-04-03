package com.udc.chatconnect.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.udc.chatconnect.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// GoogleFont.Provider initialization ...

@OptIn(ExperimentalTextApi::class)
val pacificoFontName = GoogleFont("Pacifico")
@OptIn(ExperimentalTextApi::class)
val manropeFontName = GoogleFont("Manrope")


@OptIn(ExperimentalTextApi::class)
val pacifico = FontFamily(Font(googleFont = pacificoFontName, fontProvider = provider))
@OptIn(ExperimentalTextApi::class)
val manrope = FontFamily(Font(googleFont = manropeFontName, fontProvider = provider))