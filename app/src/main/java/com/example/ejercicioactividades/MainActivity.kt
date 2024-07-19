package com.example.ejercicioactividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextNombre: EditText = findViewById(R.id.editTextNombre)
        val editTextEdad: EditText = findViewById(R.id.editTextEdad)
        val buttonIngresar: Button = findViewById(R.id.buttonIngresar)

        buttonIngresar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val edad = editTextEdad.text.toString()

            if (nombre.isNotEmpty() && edad.isNotEmpty()) {
                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("edad", edad)
                startActivity(intent)
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
