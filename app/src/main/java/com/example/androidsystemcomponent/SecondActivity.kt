package com.example.androidsystemcomponent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extras = intent.extras
        val value1 = extras!!.getString("Value1")
        val value2 = extras!!.getString("Value2")
        Toast.makeText(
            applicationContext, """Values are:
 First value: $value1
 Second Value: $value2""", Toast.LENGTH_LONG
        ).show()
    }
    fun callFirstActivity(view: View?) {
        val i = Intent(applicationContext, FirstActivity::class.java)
        startActivity(i)
    }
}
