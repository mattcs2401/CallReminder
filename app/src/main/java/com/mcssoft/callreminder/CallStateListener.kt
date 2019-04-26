package com.mcssoft.callreminder

import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager

class CallStateListener : PhoneStateListener() {

    override fun onCallStateChanged(state: Int, phoneNumber: String?) {
        super.onCallStateChanged(state, phoneNumber)
        
        when(state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                val bp = ""
            }
            TelephonyManager.CALL_STATE_OFFHOOK -> {
                val bp = ""
            }
            TelephonyManager.CALL_STATE_IDLE -> {
                val bp = ""
            }
            else -> {
                val bp = ""
            }
        }
    }
}