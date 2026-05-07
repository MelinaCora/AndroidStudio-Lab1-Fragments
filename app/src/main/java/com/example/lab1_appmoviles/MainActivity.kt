package com.example.lab1_appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Bienvenida"

        // Referencias a los elementos del XML
        val editText = findViewById<EditText>(R.id.editTextNombre)
        val boton = findViewById<Button>(R.id.buttonContinuar)

        // Evento del botón
        boton.setOnClickListener {
            val nombre = editText.text.toString()

            // Validación simple
            if (nombre.isBlank()) {
                editText.error = "Ingresa tu nombre"
                return@setOnClickListener
            }

            // Intent para ir a la segunda pantalla
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("NOMBRE_USUARIO", nombre)

            startActivity(intent)
        }
    }
}