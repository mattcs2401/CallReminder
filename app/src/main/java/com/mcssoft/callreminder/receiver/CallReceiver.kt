package com.mcssoft.callreminder.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast
import android.os.Build

/* https://google-developer-training.github.io/android-developer-phone-sms-course/Lesson%202/2_p_2_sending_sms_messages.html
 * https://code.tutsplus.com/tutorials/how-to-make-calls-and-use-sms-in-android-apps--cms-28168
 */

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.getExtras()
        if(extras != null) {
            val sms = extras.get("pdus") as Array<*>
            for(i in sms.indices) {
                val format = extras.getString("format")

                val smsMessage = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    SmsMessage.createFromPdu(sms[i] as ByteArray, format)
                } else {
                    SmsMessage.createFromPdu(sms[i] as ByteArray)
                }

                val phone = smsMessage.originatingAddress
                val message = smsMessage.messageBody.toString()

                Toast.makeText(context, "Phone no: $phone\nMessage: $message", Toast.LENGTH_LONG).show()
            }
        }



    }
}