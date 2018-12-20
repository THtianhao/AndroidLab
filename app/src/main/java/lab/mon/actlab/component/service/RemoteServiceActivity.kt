package lab.mon.actlab.component.service

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_remote_service.*
import lab.mon.actlab.R
import lab.mon.actlab.printLog

class RemoteServiceActivity : AppCompatActivity() {
    var conn: ServiceConnection? = null
    var inter: ITotoAidlInterface? = null
    fun print(message: String?) {
        printLog(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote_service)
    }

    override fun onResume() {
        super.onResume()
        remote_service_button.setOnClickListener {
            bindRemoteService()
        }
    }

    private fun bindRemoteService() {
        val intent = Intent(this, RemoteService::class.java)
        intent.setAction("com.zihao.remoteservice.RemoteService")
        conn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                inter = ITotoAidlInterface.Stub.asInterface(service)
                print(inter?.basicTypes("as"))
            }


        }
        bindService(intent, conn, BIND_AUTO_CREATE)

    }

    override fun onDestroy() {
        super.onDestroy()
        conn?.let {
            unbindService(conn)
        }
    }
}
