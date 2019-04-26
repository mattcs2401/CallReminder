package com.mcssoft.callreminder.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    /** Manually enable permissions in the app for the time being. **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mcssoft.callreminder.R.layout.activity_main)

//        if(!isSmsPermissionGranted()) {
//            requestReadAndSendSmsPermission()
//        }
    }

    //    /**
//     * Check if we have SMS permission
//     */
//    fun isSmsPermissionGranted(): Boolean {
//        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS
//        ) == PackageManager.PERMISSION_GRANTED
//    }

//    /**
//     * Request runtime SMS permission
//     */
//    private fun requestReadAndSendSmsPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
//            // You may display a non-blocking explanation here, read more in the documentation:
//            // https://developer.android.com/training/permissions/requesting.html
//        }
//        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_SMS), SMS_PERMISSION_CODE)
//    }

//    private val SMS_PERMISSION_CODE = 0
}
