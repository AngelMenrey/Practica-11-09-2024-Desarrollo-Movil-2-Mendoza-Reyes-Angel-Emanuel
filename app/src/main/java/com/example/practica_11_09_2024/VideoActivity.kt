package com.example.practica_11_09_2024

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    private var videoView: VideoView? = null
    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        //Componentes
        videoView = findViewById(R.id.videoView)
        mediaController = MediaController( this)
        mediaController !!. setAnchorView(videoView)

        //Reproducir un video en especifico
        val uri = Uri.parse( "android.resource://" + packageName + "/" + R.raw.rosa)
        videoView !!. setVideoURI(uri)
        videoView !!. requestFocus()
        videoView !!. start()
        Toast.makeText( this, "Reproduciendo...", Toast.LENGTH_SHORT).show()
        videoView !!. setMediaController(mediaController)
    }
}