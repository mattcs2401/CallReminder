package com.mcssoft.callreminder.service

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService
import com.mcssoft.callreminder.receiver.ServiceResultReceiver

class CallService() : JobIntentService() {

    /**
     * Convenience method to queue work.
     */
    fun enqueWork(context: Context, workerReceiver: ServiceResultReceiver) {
        val intent = Intent(context, CallService::class.java).apply {
            putExtra("RECEIVER", workerReceiver)
            setAction("SOME_ACTION")
        }
        enqueueWork(context, CallService::class.java, 123, intent)
    }

    override fun onHandleWork(workIntent: Intent) {
        // TBA
    }
}