package com.example.practica_11_09_2024

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MediaActivity : AppCompatActivity() {
    private var play: Button? = null
    private var stop: Button? = null
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        // Componentes
        play = findViewById(R.id.btnReproducir)
        stop = findViewById(R.id.btnDetener)

        // Listener para reproducir el audio
        play?.setOnClickListener {
            if (mediaPlayer == null) {
                // Inicializa MediaPlayer solo si no está ya inicializado
                mediaPlayer = MediaPlayer().apply {
                    setAudioStreamType(AudioManager.STREAM_MUSIC)
                    val uri = Uri.parse("android.resource://$packageName/${R.raw.rosa}")

                    try {
                        setDataSource(this@MediaActivity, uri)
                        prepare()
                        start()
                        Toast.makeText(this@MediaActivity, "Reproduciendo...", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(this@MediaActivity, "Error al reproducir", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
            } else {
                Toast.makeText(this@MediaActivity, "El audio ya está reproduciéndose", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener para detener el audio
        stop?.setOnClickListener {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                mediaPlayer!!.stop()
                mediaPlayer!!.reset()  // Reinicia el MediaPlayer
                mediaPlayer!!.release()  // Libera los recursos
                mediaPlayer = null  // Pone el objeto a null para permitir una nueva reproducción
                Toast.makeText(this@MediaActivity, "Audio detenido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MediaActivity, "No hay audio en reproducción", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Asegura que MediaPlayer sea liberado al cerrar la actividad
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
