package lab.mon.actlab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lab.mon.actlab.adapter.AdapterActivity
import lab.mon.actlab.component.ComponseActivity
import lab.mon.actlab.viewdispath.ViewDispathActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        button6.setOnClickListener {
            startActivity(Intent(this, ComponseActivity::class.java))
        }
        adapter.setOnClickListener {
            startActivity(Intent(this, AdapterActivity::class.java))

        }
        mian_view_dispath.setOnClickListener {
            startActivity(Intent(this, ViewDispathActivity::class.java))
        }
    }
}
