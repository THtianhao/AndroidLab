package lab.mon.actlab.component

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import lab.mon.actlab.R

class Actlab : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actlab)
        print("oncreate")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    val DEBBUG = true
    private fun print(message: String) {
        if (DEBBUG) {
            Log.i("toto" + this::class.simpleName, message)
        }
    }


    fun jump(v: View) {
        startActivity(Intent(this, TwoActivity::class.java))
    }
}
