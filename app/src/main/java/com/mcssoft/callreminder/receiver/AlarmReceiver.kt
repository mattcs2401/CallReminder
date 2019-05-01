package com.mcssoft.callreminder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.*
import android.os.Bundle
import com.mcssoft.callreminder.util.Constants.ALARM_TYPE_CALL

/**
 * Receiver class for any alarms that are set.
 */
class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // TODO - a notification as well ?
        // Get the notification type, i.e. missed call or missed Sms.
        extras = intent.extras
        if(extras != null && !(extras!!.isEmpty)) {
            when(extras?.getInt("KEY_ALARM_TYPE")) {
                ALARM_TYPE_CALL -> {
                    doForMissedCall(context)
                }
//                ALARM_TYPE_SMS -> {
//                    doSms()
//                }
            }
        }
    }

    private fun doForMissedCall(context: Context) {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        val mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(audioAttributes)
            setDataSource(context.applicationContext, uri)
            setLooping(false)
            prepare()
            start()
        }
    }

//    private fun doSms() {
//        if(extras != null) {
//            val sms = extras.get("pdus") as Array<*>
//            for(i in sms.indices) {
//                val format = extras.getString("format")
//
//                val smsMessage = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    SmsMessage.createFromPdu(sms[i] as ByteArray, format)
//                } else {
//                    SmsMessage.createFromPdu(sms[i] as ByteArray)
//                }
//
//                val phone = smsMessage.originatingAddress
//                val message = smsMessage.messageBody.toString()
//
//                Toast.makeText(context, "Phone no: $phone\nMessage: $message", Toast.LENGTH_LONG).show()
//            }
//        }
//        val bp = ""
//    }

    private var extras: Bundle? = null

/* https://google-developer-training.github.io/android-developer-phone-sms-course/Lesson%202/2_p_2_sending_sms_messages.html
 * https://code.tutsplus.com/tutorials/how-to-make-calls-and-use-sms-in-android-apps--cms-28168
 */
}