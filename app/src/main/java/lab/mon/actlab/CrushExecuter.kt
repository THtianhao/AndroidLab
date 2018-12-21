package lab.mon.actlab

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class CrushExecuter() {
    var mDiskIO: Executor
    var mNetworkIO: Executor
    var mMainThread: Executor

    init {
        mDiskIO = Executors.newSingleThreadExecutor()
        mNetworkIO = Executors.newFixedThreadPool(3)
        mMainThread = MainThreadExecutor()
    }
}


private class MainThreadExecutor : Executor {
    private val mainThreadHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mainThreadHandler.post(command)
    }
}