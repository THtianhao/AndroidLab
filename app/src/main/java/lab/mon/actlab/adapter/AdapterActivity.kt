package lab.mon.actlab.adapter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adapter.*
import lab.mon.actlab.R
import lab.mon.actlab.adapter.androideight.AdapterEightActivity
import lab.mon.actlab.component.ComponseActivity

class AdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)
    }

    override fun onResume() {
        super.onResume()
        activity_acapter_eight.setOnClickListener {
            startActivity(Intent(this, AdapterEightActivity::class.java))

        }
    }
}
