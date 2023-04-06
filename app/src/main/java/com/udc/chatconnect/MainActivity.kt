package com.udc.chatconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import com.udc.chatconnect.navigation.NavComposeApp
import com.udc.chatconnect.view.widget.toastMessage

class MainActivity : ComponentActivity() {
    private var backPressedTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            NavComposeApp()
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        }else{
            toastMessage("Tap again to exit app", context = applicationContext)
        }
        backPressedTime = System.currentTimeMillis()
    }
}
