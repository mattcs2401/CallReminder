package com.mcssoft.callreminder

import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager

class CallStateListener : PhoneStateListener() {

    override fun onCallStateChanged(state: Int, phoneNumber: String?) {
        super.onCallStateChanged(state, phoneNumber)
        
        when(state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                isRinging = true
                wasRinging = false
            }
            TelephonyManager.CALL_STATE_OFFHOOK -> {
                isRinging = false
                wasRinging = true
            }
            TelephonyManager.CALL_STATE_IDLE -> {
                isRinging = false
                if(wasRinging == false) {
                    // was ringing but didn't go off hook.
                    // get number and implement call manager for notification.
                    // finally set wasRinging = true
                    wasRinging = true
                }
            }
            else -> {
                isRinging = false
            }
        }
    }

    private var isRinging: Boolean = false
    private var wasRinging: Boolean = false
}