package com.example.androidsystemcomponent

import android.R
import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        val videoView = findViewById<View>(R.id.videoView1) as VideoView

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of media file
        val uri: Uri = Uri.parse(
            Environment.getExternalStorageDirectory().getPath().toString() + "/media/1.mp4"
        )

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_video, menu)
        return true
    }
}
