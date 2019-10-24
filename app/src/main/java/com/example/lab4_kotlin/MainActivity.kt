package com.example.mainactivity
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lab4_kotlin.R

class MainActivity : AppCompatActivity() {

    private var btn: Button? = null
    private var tv_meal: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onClickListener = View.OnClickListener {
            startActivityForResult(Intent(this@MainActivity,
                Main2Activity::class.java), 1)
        }

        tv_meal = findViewById(R.id.tv_meal)

        btn = findViewById(R.id.btn_choice)
        btn!!.setOnClickListener(onClickListener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == 1) {
            if (resultCode == 101) {
                val b = data.extras
                val str1 = b!!.getString("drink")
                val str2 = b.getString("suger")
                val str3 = b.getString("ice")

                tv_meal!!.text = "饮料：$str1\n\n甜度：$str2\n\n冰块：$str3\n\n"
            }
        }
    }
}





