package com.app1.quizandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()
    }

    fun openActivity(view: View){
        startActivity(Intent(this, QuizActivity::class.java))
    }

    fun playVideo(){
        val video = findViewById<VideoView>(R.id.background_video)
        val video_uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_one)
        video.setVideoURI(video_uri)
        video.start()

    }

}
