package lab.mon.actlab.component.launchmode

import android.content.Intent
import android.os.Bundle
import android.view.View
import lab.mon.actlab.R

class TwoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
    }

    fun jump(v: View) {
        startActivity(Intent(this, ThreeActivity::class.java))

    }
}
