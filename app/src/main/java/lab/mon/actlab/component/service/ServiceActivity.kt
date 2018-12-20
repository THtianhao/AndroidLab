package lab.mon.actlab.component.service

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_service.*
import lab.mon.actlab.R

class ServiceActivity : AppCompatActivity() {


    var bind = InterService.Mybinder();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

    }

    var serviceConn = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            bind = service as InterService.Mybinder
            print(bind.getString())
        }

    }

    override fun onResume() {
        super.onResume()

        startService.setOnClickListener {
            val intent = Intent(this@ServiceActivity, InterService::class.java)
            startService(intent)
        }

        stopService.setOnClickListener {
            val intent = Intent(this@ServiceActivity, InterService::class.java)
            stopService(intent)
        }

        bindService.setOnClickListener {
            val intent = Intent(this@ServiceActivity, InterService::class.java)
            bindService(intent, serviceConn, BIND_AUTO_CREATE)
        }

        unBindService.setOnClickListener {
            unbindService(serviceConn)
        }

    }
}
