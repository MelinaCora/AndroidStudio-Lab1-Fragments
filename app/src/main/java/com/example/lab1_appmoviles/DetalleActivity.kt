package com.example.lab1_appmoviles

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.AppCompatButton

class DetalleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOMBRE = "NOMBRE_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Detalle"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val textoSaludo = findViewById<TextView>(R.id.textSaludo)
        val textoInicial = findViewById<TextView>(R.id.textInicial)

        val nombre = intent.getStringExtra(EXTRA_NOMBRE) ?: "?"

        textoSaludo.text = "Hola, $nombre!"
        textoInicial.text = nombre.first().uppercase()

        //boton volver
        val botonVolver = findViewById<AppCompatButton>(R.id.buttonVolver)
        botonVolver.setOnClickListener {
            finish()
        }
    }

    // Flecha
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}