package lab.mon.actlab.interProcess

import android.content.ComponentName
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inter_process.*
import lab.mon.actlab.R
import android.content.pm.PackageManager
import android.content.Context


class InterProcess : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inter_process)
    }

    override fun onResume() {
        super.onResume()


        act_inter_process1.setOnClickListener {
            if (isAppInstalled(this, "com.abc.test")) {
                val compoen = ComponentName("com.abc.test", "com.abc.test.MainActivity");
                val intent = Intent()
                intent.action = "android.intent.action.MAIN";
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
                intent.setComponent(compoen)
                val byte = ByteArray(500 * 1024)
                val string = String(byte)
                intent.putExtra("data", string)
                startActivity(intent)
            }

        }
        act_inter_process2.setOnClickListener {

        }
    }

    fun isAppInstalled(context: Context, packageName: String): Boolean {
        val pm = context.getPackageManager()
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }

    }

}
