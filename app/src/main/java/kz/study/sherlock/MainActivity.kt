package kz.study.sherlock

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textview_info: TextView

    companion object{
        const val REQUEST_CHOOSE_THIEF = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_choose: Button = findViewById(R.id.button_choose)
        textview_info = findViewById(R.id.textview_info)
        button_choose.setOnClickListener {
            val questionIntent = Intent(this@MainActivity,
                SecondActivity::class.java)
            startActivityForResult(questionIntent, REQUEST_CHOOSE_THIEF)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CHOOSE_THIEF -> {
                    val thiefName = data?.getStringExtra(THIEF)
                    textview_info.text = thiefName.toString()
                }
                // Другие запросы
                //   REQUEST_MULTIPLE_PERMISSION -> {
                //       // Do something if success / failed
                //   }
            }
        } else{
            textview_info.text = "" // стираем текст
        }
    }
}