package com.mcssoft.callreminder.ui.fragment

import android.content.Context
import android.telephony.PhoneStateListener
import androidx.fragment.app.Fragment
import android.telephony.TelephonyManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcssoft.callreminder.CallStateListener
import com.mcssoft.callreminder.R

class MainFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        phoneListener = CallStateListener()
        telephonyManager = activity?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_NONE)
    }

    private lateinit var phoneListener: CallStateListener
    private lateinit var telephonyManager: TelephonyManager
}