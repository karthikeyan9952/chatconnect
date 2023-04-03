package com.udc.chatconnect.view.home


import android.content.Context
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.udc.chatconnect.Constants
import com.udc.chatconnect.view.toastMessage
import java.lang.IllegalArgumentException
import java.util.*

class HomeViewModel : ViewModel() {
    init {
        getMessages()
    }

    private val _message = MutableLiveData("")
    val message: LiveData<String> = _message

    private var _messages = MutableLiveData(emptyList<Map<String, Any>>().toMutableList())
    val messages: LiveData<MutableList<Map<String, Any>>> = _messages

    private val _isSending = MutableLiveData(false)
    val isSending: LiveData<Boolean> = _isSending

    private val auth: FirebaseAuth = Firebase.auth

    /**
     * Update the message value as user types
     */
    fun updateMessage(message: String) {
        _message.value = message
    }

    /**
     * Send message
     */
    fun addMessage() {
        val message: String = _message.value ?: throw IllegalArgumentException("message empty")
        if (message.isNotEmpty()) {
            _isSending.value = true
            _message.value = ""
            Firebase.firestore.collection(Constants.MESSAGES).document().set(
                hashMapOf(
                    Constants.MESSAGE to message,
                    Constants.SENT_BY to Firebase.auth.currentUser?.uid,
                    Constants.SENT_ON to System.currentTimeMillis()
                )
            ).addOnSuccessListener {
                _isSending.value = false
            }
        }
    }

    /**
     * Get the messages
     */
    private fun getMessages() {
        Firebase.firestore.collection(Constants.MESSAGES)
            .orderBy(Constants.SENT_ON)
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w(Constants.TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val list = emptyList<Map<String, Any>>().toMutableList()

                if (value != null) {
                    for (doc in value) {
                        val data = doc.data
                        data[Constants.IS_CURRENT_USER] =
                            Firebase.auth.currentUser?.uid.toString() == data[Constants.SENT_BY].toString()

                        list.add(data)
                    }
                }

                updateMessages(list)
            }
    }

    /**
     * Update the list after getting the details from firestore
     */
    private fun updateMessages(list: MutableList<Map<String, Any>>) {
        _messages.value = list.asReversed()
    }

    fun logoutUser(landing: () -> Unit, context: Context) {
        auth.signOut()
        landing()
        toastMessage("Logout Successful", context)
    }

    fun convertLongToTime(time: Long): String {
        val today = Date()
        val date = Date(time)
        var hour: Int = date.hours
        var minutes: Int = date.minutes
        var suffix: String = ""

        if (hour > 11) {
            suffix = "PM"
            if (hour > 12)
                hour -= 12
        } else {
            suffix = "AM"
            if (hour == 0)
                hour = 12
        }

        val t = if (minutes < 10) "$hour:0$minutes $suffix" else "$hour:$minutes $suffix"

        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate = sdf.format(date)

        val diff: Long = today.time - date.time
        val seconds = diff / 1000
        val minute = seconds / 60
        val hours = minute / 60
        val days = hours / 24

        println("*************")
        println(days)
        println("*************")

        return if (days == 0L) "Today  $t" else if (days == 1L) "Yesterday  $t" else "$formattedDate  $t"

    }

}
