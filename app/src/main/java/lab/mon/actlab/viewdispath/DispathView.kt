package lab.mon.actlab.viewdispath

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import lab.mon.actlab.printLog

class DispathView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        printLog(this::class.simpleName + " = dispatchTouchEvent")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        printLog(this::class.simpleName + " = onTouchEvent")
        return super.onTouchEvent(event)
    }
}