package com.example.lab1_appmoviles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class DetalleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_detalle,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        (activity as AppCompatActivity)
            .supportActionBar
            ?.setDisplayHomeAsUpEnabled(true)

        // Flecha volver
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Referencias
        val textoSaludo = view.findViewById<TextView>(R.id.textSaludo)
        val textoInicial = view.findViewById<TextView>(R.id.textInicial)

        // Recibir datos
        val nombre = arguments?.getString("NOMBRE_USUARIO") ?: "?"

        // Mostrar saludo
        textoSaludo.text = "Hola, $nombre!"

        // Mostrar inicial
        textoInicial.text = nombre.first().uppercase()

        // Botón volver
        val botonVolver = view.findViewById<AppCompatButton>(R.id.buttonVolver)

        botonVolver.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}