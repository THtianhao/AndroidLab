package lab.mon.actlab.basis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_base.*
import lab.mon.actlab.R

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun onResume() {
        super.onResume()
        handler.setOnClickListener {
            startActivity(Intent(this, BasicActivity::class.java))
        }
    }
}
