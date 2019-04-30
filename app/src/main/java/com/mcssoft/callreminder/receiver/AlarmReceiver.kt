package com.mcssoft.callreminder.receiver

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.RingtoneManager
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.mcssoft.callreminder.R
import com.mcssoft.callreminder.util.Constants.ALARM_TYPE_CALL

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
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

        val audioAttr = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        val soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttr)
            .build()

        val spId = soundPool.load(uri.toString(), 1)

        val playId = soundPool.play(spId, 1.0F, 1.0F, 1, 0, 1.0F)


        val bp = ""
//        /**
//         * "Compat" methods used primarily as this project has min SDK version of 22.
//         * The key is the NavDeepLinkBuilder method to create the PendingIntent (see createIntent()).
//         * See: https://proandroiddev.com/android-jetpack-navigation-to-the-rescue-fe588271d36
//         *      https://developer.android.com/training/notify-user/build-notification
//         */
//        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        //If on Oreo then Notification requires a notification channel.
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            val channel = NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        val notification = createNotification(context, uri)
//
//        NotificationManagerCompat.from(context).notify(10, notification)

//        val phoneNumber = extras?.getString("KEY_PH_NO")
//        val bp = ""
    }

    private fun createNotification(context: Context, uri: Uri) : Notification {
        return NotificationCompat.Builder(context, "default")
            .setSound(uri)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.DEFAULT_VIBRATE.toString())
            .build()
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