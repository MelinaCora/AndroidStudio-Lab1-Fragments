package com.example.lab1_appmoviles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContenedorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)
        // Solo cargamos el Fragment inicial si es la primera vez.
        // Si savedInstanceState != null, el sistema ya restauro el Fragment.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PrincipalFragment())
                .commit()
        }
    }
}