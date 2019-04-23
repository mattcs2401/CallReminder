package com.mcssoft.callreminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import com.mcssoft.callreminder.util.SingletonHolder

class CallAlarmManager private constructor(context: Context) {

    private var context: Context? = null
    private var alarmManager : AlarmManager? = null

    init {
        if(this.context == null) {
            this.context = context
            alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        }
    }

    companion object : SingletonHolder<CallAlarmManager, Context>(::CallAlarmManager)

    fun setAlarm() {
        // TBA
    }

    fun cancelAlarm(alarmIntent: PendingIntent) {
        alarmManager?.cancel(alarmIntent)
    }

}