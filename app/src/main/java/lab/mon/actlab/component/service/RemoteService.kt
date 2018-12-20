package lab.mon.actlab.component.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class RemoteService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return stub
    }

    val stub = object : ITotoAidlInterface.Stub() {
        override fun basicTypes(message: String?): String {
            return "asd"
        }


    }


}