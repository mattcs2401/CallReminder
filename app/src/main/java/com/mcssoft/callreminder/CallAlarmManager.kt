package com.mcssoft.callreminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.mcssoft.callreminder.receiver.AlarmReceiver
import com.mcssoft.callreminder.util.Constants
import com.mcssoft.callreminder.util.SingletonHolder

class CallAlarmManager private constructor(context: Context) {

    private var context: Context? = null              // this should be application context, not activity context etc.
    private var alarmManager : AlarmManager? = null

    init {
        if(this.context == null) {
            this.context = context
            alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        }
    }

    companion object : SingletonHolder<CallAlarmManager, Context>(::CallAlarmManager)

    fun setAlarm(phoneNumber: String) {
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.putExtra(Constants.KEY_ALARM_TYPE, Constants.ALARM_TYPE_CALL)
        intent.putExtra(Constants.KEY_PH_NO, phoneNumber)

        val alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

        alarmManager?.setInexactRepeating(AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + Constants.ONE_MINUTE, Constants.ONE_MINUTE, alarmIntent)
    }

    fun cancelAlarm(alarmIntent: PendingIntent) {
        alarmManager?.cancel(alarmIntent)
    }

}