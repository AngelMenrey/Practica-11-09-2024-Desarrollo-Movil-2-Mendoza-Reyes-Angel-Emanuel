package com.example.practica_11_09_2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Componentes tipo botón
        val botonMedia = findViewById<Button>(R.id.btnMedia)
        val botonVideo = findViewById<Button>(R.id.btnVideo)

        // Evento para el botón Media
        botonMedia.setOnClickListener {
            val intent = Intent(applicationContext, MediaActivity::class.java)
            startActivity(intent)
        }

        // Evento para el botón Video
        botonVideo.setOnClickListener {
            val intent = Intent(applicationContext, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}
