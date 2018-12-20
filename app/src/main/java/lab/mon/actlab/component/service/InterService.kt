package lab.mon.actlab.component.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class InterService : Service() {

    val DEBBUG = true
    private fun print(message: String) {
        if (DEBBUG) {
            Log.i("toto" + this::class.simpleName, message)
        }
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        print("onRebind")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        print("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        print("onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        print("onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        print("onBind")
        return Mybinder()

    }

    class Mybinder : Binder() {
        fun getString(): String {

            return "asd"
        }

    }

}