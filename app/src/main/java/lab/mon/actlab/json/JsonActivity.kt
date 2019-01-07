package lab.mon.actlab.json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_json.*
import lab.mon.actlab.R

class JsonActivity : AppCompatActivity() {
    val string = "{\n" +
            "  \"use_entire_file_if_no_selection\": true,\n" +
            "  \"indent\": 2,\n" +
            "  \"sort_keys\": false,\n" +
            "  \"ensure_ascii\": false,\n" +
            "  \"line_separator\": \",\",\n" +
            "  \"value_separator\": \": \",\n" +
            "  \"keep_arrays_single_line\": false,\n" +
            "  \"max_arrays_line_length\": \"asd\",\n" +
            "  \"pretty_on_save\": false,\n" +
            "  \"validate_on_save\": true\n" +
            "}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)
    }

    override fun onResume() {
        super.onResume()
        act_json_1.setOnClickListener {

        }
        act_json_2.setOnClickListener {

        }
        act_json_3.setOnClickListener {

        }
    }

}
