package lab.mon.actlab.adapter.androideight

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_adapter_eight_adapter.*
import lab.mon.actlab.R
import lab.mon.actlab.TApplication
import lab.mon.actlab.printLog
import kotlin.concurrent.thread

class AdapterEightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_eight_adapter)
    }

    val handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            thread {
                val intent = Intent(TApplication.instance, AdapterEightService::class.java)
                intent.putExtra("1", "asd")
                AdapterEightService.enqueueWork(this@AdapterEightActivity, intent)
            }
            sendEmptyMessageDelayed(1,200*1000)
        }
    }
    override fun onResume() {
        super.onResume()
        adpater_eight_button.setOnClickListener {
            handler.sendEmptyMessage(1)
        }
    }
}
