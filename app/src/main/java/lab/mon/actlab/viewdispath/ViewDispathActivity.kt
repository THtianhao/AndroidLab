package lab.mon.actlab.viewdispath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import lab.mon.actlab.R
import lab.mon.actlab.printLog

class ViewDispathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_dispath)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        printLog(this::class.simpleName+ " = dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        printLog(this::class.simpleName+ " = onTouchEvent")
        return super.onTouchEvent(event)

    }

}
