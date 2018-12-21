package lab.mon.actlab

import android.app.Application

class TApplication:Application(){


    companion object {
        lateinit var instance: TApplication
    }
    lateinit var mAppExecutors: CrushExecuter

    override fun onCreate() {
        super.onCreate()
        instance = this@TApplication
        mAppExecutors = CrushExecuter()
    }

}