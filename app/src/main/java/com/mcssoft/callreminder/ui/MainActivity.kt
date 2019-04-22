package com.mcssoft.callreminder.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mcssoft.callreminder.R
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.READ_SMS
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mcssoft.callreminder.R.layout.activity_main)
    }

    /**
     * Check if we have SMS permission
     */
    fun isSmsPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Request runtime SMS permission
     */
    private fun requestReadAndSendSmsPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
            // You may display a non-blocking explanation here, read more in the documentation:
            // https://developer.android.com/training/permissions/requesting.html
        }
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_SMS), SMS_PERMISSION_CODE)
    }

    private val SMS_PERMISSION_CODE = 0
}
