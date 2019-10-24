package com.example.mainactivity


import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.lab4_kotlin.R

class Main2Activity : AppCompatActivity() {

    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null

    private var suger = "无糖"
    private var ice_opt = "微冰"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.radioButton1)
                suger = "无糖"
            else if (i == R.id.radioButton2)
                suger = "少糖"
            else if (i == R.id.radioButton3)
                suger = "半糖"
            else if (i == R.id.radioButton4)
                suger = "全糖"

            when(i){
                R.id.radioButton1 -> suger = "无糖"
                R.id.radioButton2 -> suger = "少糖"
                R.id.radioButton3 -> suger = "半糖"
                R.id.radioButton4 -> suger = "全糖"
            }
        }

        val onCheckedChangeListener2 = RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.radioButton5)
                ice_opt = "微冰"
            else if (i == R.id.radioButton6)
                ice_opt = "少冰"
            else if (i == R.id.radioButton7)
                ice_opt = "正常冰"
        }

        rg1 = findViewById(R.id.radioGroup)
        rg1!!.setOnCheckedChangeListener(onCheckedChangeListener)

        rg2 = findViewById(R.id.radioGroup2)
        rg2!!.setOnCheckedChangeListener(onCheckedChangeListener2)

        send_btn = findViewById(R.id.btn_send)
        send_btn!!.setOnClickListener {
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink!!.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("suger", suger)
            b.putString("drink", drink)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }
    }


}