package com.example.androidsystemcomponent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    fun callSecondActivity(view: View?) {
        val i = Intent(applicationContext, SecondActivity::class.java)
        i.putExtra("Value1", "Android By Javatpoint")
        i.putExtra("Value2", "Simple Tutorial")
        // Set the request code to any code you like, you can identify the
        // callback via this code
        startActivity(i)
    }
}
