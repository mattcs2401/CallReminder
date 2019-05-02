package com.mcssoft.callreminder.ui.fragment

import android.content.Context
import android.telephony.PhoneStateListener
import androidx.fragment.app.Fragment
import android.telephony.TelephonyManager
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mcssoft.callreminder.CallAlarmManager
import com.mcssoft.callreminder.listener.CallStateListener
import com.mcssoft.callreminder.R
import com.mcssoft.callreminder.iface.Receiver
import com.mcssoft.callreminder.receiver.ServiceResultReceiver
import kotlinx.android.synthetic.main.fragment_main.*

/*
https://github.com/google-developer-training/android-fundamentals-phone-sms
 */
class MainFragment: Fragment(), View.OnClickListener, Receiver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        phoneListener = CallStateListener(activity!!.applicationContext)
        telephonyManager = activity?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE)

        cancelButton = id_btn_cancel
        cancelButton.setOnClickListener(this)

        serviceResultReceiver = ServiceResultReceiver(Handler())
        serviceResultReceiver.setReceiver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_NONE)
    }

    override fun onClick(view: View) {
        CallAlarmManager.getInstance(activity!!.applicationContext).cancelAlarm()
    }

    /**
     * Interface: Receiver.onReceiveResult()
     */
    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {

        val bp = ""
    }

    private lateinit var cancelButton: Button
    private lateinit var phoneListener: CallStateListener
    private lateinit var telephonyManager: TelephonyManager
    private lateinit var serviceResultReceiver: ServiceResultReceiver
}