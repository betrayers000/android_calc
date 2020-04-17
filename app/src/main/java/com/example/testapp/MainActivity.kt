package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operator = ""
        var x : Long = 0

        plus_btn.setOnClickListener {
            operator = plus_btn.text.toString()
        }
        minus_btn.setOnClickListener {
            operator = minus_btn.text.toString()
        }
        multiple_btn.setOnClickListener {
            operator = multiple_btn.text.toString()
        }
        divide_btn.setOnClickListener {
            operator = divide_btn.text.toString()
        }
        for (i in 0..num_layout.childCount){
            val layout  = num_layout.getChildAt(i)
            if (layout is LinearLayout){
                for (j in 0..layout.childCount){
                    val v = layout.getChildAt(j)

                    if (v is Button){
                        v.setOnClickListener{
                            x = calc(v, x, operator)
                        }
                    }
                }
            }
        }
        reset_btn.setOnClickListener {
            x = 0L
            operator = ""
            result_viewer.text = "0"
        }
    }

    fun calc(button: Button, x : Long, operator : String) : Long{
        val y = button.text.toString().toLong()
        if (operator == ""){
            var temp : String?
            if (x == 0L){
                temp = y.toString()
            } else {
                temp = x.toString() + y.toString()
            }
            result_viewer.text = temp
            return temp.toLong()
        } else {
            val temp = operator_calc(operator, x, y)
            result_viewer.text = temp.toString()
            return temp
        }
    }

    fun operator_calc(operator : String, x : Long, y : Long) : Long{
        when (operator){
            "+" -> return x + y
            "-" -> return x - y
            "x" -> return x*y
            "/" -> return x/y
        }
        return 0
    }
}
