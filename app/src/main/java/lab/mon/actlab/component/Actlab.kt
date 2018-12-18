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

    override fun onStart() {
        super.onStart()
        print("onStart")
    }

    override fun onResume() {
        super.onResume()
        print("onResume")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        print("onNewIntent")
    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        print("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestory")
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
