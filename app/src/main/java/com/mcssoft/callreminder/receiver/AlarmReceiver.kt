package com.mcssoft.callreminder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mcssoft.callreminder.CallAlarmManager

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            CallAlarmManager.getInstance(context).setAlarm()
        }
    }
}