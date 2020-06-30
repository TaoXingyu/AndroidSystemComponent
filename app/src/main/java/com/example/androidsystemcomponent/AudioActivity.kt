package com.example.androidsystemcomponent

import android.R
import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class AudioActivity : AppCompatActivity() {
    var start: Button? = null
    var pause: Button? = null
    var stop: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Activity_audio)
        start = findViewById<View>(R.id.button1) as Button
        pause = findViewById<View>(R.id.button2) as Button
        stop = findViewById<View>(R.id.button3) as Button
        //creating media player
        val mp = MediaPlayer()
        try {
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            mp.setDataSource(
                Environment.getExternalStorageDirectory().getPath().toString() + "/Music/maine.mp3"
            )
            mp.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        start.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                mp.start()
            }
        })
        pause.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                mp.pause()
            }
        })
        stop.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                mp.stop()
            }
        })
    }
}
