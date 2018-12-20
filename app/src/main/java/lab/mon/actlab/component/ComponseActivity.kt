package lab.mon.actlab.component

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_componse.*
import lab.mon.actlab.R
import lab.mon.actlab.component.launchmode.Actlab
import lab.mon.actlab.component.service.ServiceActivity

class ComponseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_componse)
    }

    override fun onResume() {
        super.onResume()
        componse_start_mode.setOnClickListener {
            startActivity(Intent(this,Actlab::class.java))
        }
        componse_service.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }
    }
}
