package com.mcssoft.callreminder.iface

import android.os.Bundle

interface Receiver {
    fun onReceiveResult(resultCode: Int, resultData: Bundle)
}