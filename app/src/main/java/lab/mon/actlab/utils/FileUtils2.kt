package lab.mon.actlab.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import org.json.JSONObject
import kotlin.concurrent.thread

class FileUtils2 {

    val FailName = "unityPayFaile.txt"

    fun saveFaileToken(context: Context, faileString: String) {
        val txtString = readFileData(context, FailName)
        if (txtString.isNotEmpty()) {
            val objects = JSONObject(txtString)
            val tokenString = objects.getString("token")
            if (tokenString.isNotEmpty()) {
                objects.put("token", faileString)
                writeFileData(context, objects.toString())
            }
        } else {
            val objects = JSONObject()
            objects.put("token", faileString)
            writeFileData(context, objects.toString())
        }
    }

    fun getFaileToken(context: Context): String {
        val txtString = readFileData(context, FailName)
        if (txtString.isNotEmpty()) {
            val objects = JSONObject(txtString)
            val tokenString = objects.getString("token")
            if (tokenString.isNotEmpty()) {
                return tokenString
            }
        }
        return ""
    }


    fun writeFileData(context: Context, json: String) {
        try {
            val fos = context.openFileOutput(FailName, MODE_PRIVATE);//获得FileOutputStream
            //将要写入的字符串转换为byte数组
            val bytes = json.toByteArray()
            fos.write(bytes);//将byte数组写入文件
            fos.close();//关闭文件输出流
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readFileData(context: Context, fileName: String): String {
        var result = ""
        try {
            val fis = context.openFileInput(fileName)
            //获取文件长
            fis.buffered().reader().use {
                result = it.readText()
            }
            fis.close()
            //将byte数组转换成指定格式的字符串
        } catch (e: Exception) {
            e.printStackTrace();
        }

        return result;
    }


    fun pas(name:String="",startyear:Int=0,endyear:Int=1){
        thread {
            var name ="zhukenan"
            var finals =""
            val fileUtils2 = FileUtils2()

            for (year in 1949 until 2010){
                for (mon in 1 until 13){
                    for(day in 1 until 32){
                        var y =year.toString()
                        var m =""
                        var d =""
                        var tm =""
                        var td =""
                        if (mon<=9){
                            m ="0"+mon.toString()
                        }else{
                            m =mon.toString()
                        }
                        tm =mon.toString()
                        if (day<=9){
                            d ="0"+day.toString()
                        }else{
                            d =day.toString()
                        }
                        td=day.toString()
                        finals += name+y+m+d+"\n"
                        finals += name+y+tm+td+"\n"
                        Log.d("toto",y+m+d)
                    }
                }
            }
//            fileUtils2.writeFileData(this@Demo_Activity,finals)
            Log.d("toto","over")
        }


//        fileUtils2.writeFileData(this)
    }
}