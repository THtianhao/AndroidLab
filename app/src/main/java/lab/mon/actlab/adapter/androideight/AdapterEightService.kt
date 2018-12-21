package lab.mon.actlab.adapter.androideight

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.Handler
import android.os.Message
import android.support.v4.app.JobIntentService
import android.util.Log
import lab.mon.actlab.printLog
import kotlin.concurrent.thread


class AdapterEightService : JobIntentService() {

    val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }

    companion object {
        val FIREBASE_SERVICE_ID = 1

        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, AdapterEightService::class.java, FIREBASE_SERVICE_ID, intent)
        }
    }

    override fun onHandleWork(intent: Intent) {
        val extra = intent.getStringExtra("1")
        printLog(extra)
        handler.sendEmptyMessageDelayed(1,5000)

    }
}
