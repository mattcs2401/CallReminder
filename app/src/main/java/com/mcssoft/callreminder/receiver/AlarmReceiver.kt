package com.mcssoft.callreminder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mcssoft.callreminder.CallAlarmManager

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Display notification about missed call.

        val phoneNumber = intent.extras.getString("PHONE_NUMBER")

        val bp = ""
    }
}