package lab.mon.actlab

import android.util.Log

fun printLog(message: String?,DEBUG: Boolean = true) {
    if (DEBUG) {
        Log.i("toto", message)
    }
}