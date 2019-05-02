package com.mcssoft.callreminder.receiver;

import android.os.Bundle
import android.os.Handler;
import android.os.ResultReceiver;
import com.mcssoft.callreminder.iface.Receiver

class ServiceResultReceiver(handler: Handler) : ResultReceiver(handler) {

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        receiver?.onReceiveResult(resultCode, resultData)
    }

    fun setReceiver(receiver: Receiver) {
        this.receiver = receiver
    }

    private var receiver: Receiver? = null

}

