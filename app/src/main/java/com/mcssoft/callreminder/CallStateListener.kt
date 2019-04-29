package com.mcssoft.callreminder

import android.content.Context
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import com.mcssoft.callreminder.util.Constants

class CallStateListener(private var context: Context) : PhoneStateListener() {

    override fun onCallStateChanged(state: Int, phoneNumber: String) {
        super.onCallStateChanged(state, phoneNumber)
        
        when(state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                isRinging = true
            }
            TelephonyManager.CALL_STATE_OFFHOOK -> {
                isOffHook = true

                // check call alarm state
            }
            TelephonyManager.CALL_STATE_IDLE -> {
                // App start thru here initially
                isIdle = true

                // if ringing flag was set but not the off hook flag.
                if(isRinging && !isOffHook) {
                    // start call alarm.
                    CallAlarmManager.getInstance(context).setAlarm(Constants.TEST_PHONE_NUMBER)

                    // reset the ringing and off hook flags.
                    reset()
                } else if (isRinging && isOffHook) {
                    // was previously ringing and did go off hook, reset the ringing and off hook flags.
                    reset()
                }

            }
            else -> {
                // TBA
            }
        }
    }

    private fun reset() {
        isRinging = false
        isOffHook = false
    }

    private var isRinging: Boolean = false
    private var isOffHook: Boolean = false
    private var isIdle: Boolean = false
}