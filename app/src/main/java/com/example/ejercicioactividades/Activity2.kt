package com.example.ejercicioactividades

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        val textNombre: TextView = findViewById(R.id.textNombre)
        val textEdad: TextView = findViewById(R.id.textEdad)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getStringExtra("edad")

        textNombre.text = "Nombre: $nombre"
        textEdad.text = "Edad: $edad"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
