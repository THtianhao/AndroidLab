package lab.mon.actlab.basis.handler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_handler.*
import lab.mon.actlab.R

class HandlerActivity : AppCompatActivity() {

    val handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)
    }

    override fun onResume() {
        super.onResume()
        handler_button.setOnClickListener {

        }
    }
}
