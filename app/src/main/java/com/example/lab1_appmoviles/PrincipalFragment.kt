package com.example.lab1_appmoviles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class PrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return inflater.inflate(
            R.layout.fragment_principal,
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
            ?.title = "Bienvenida"


        // Referencias XML
        val editText =
            view.findViewById<EditText>(R.id.editTextNombre)

        val boton =
            view.findViewById<AppCompatButton>(R.id.buttonContinuar)

        // Evento botón
        boton.setOnClickListener {

            // Leer texto
            val nombre = editText.text.toString()

            // Validación
            if (nombre.isBlank()) {

                editText.error = "Ingresa tu nombre"

                return@setOnClickListener
            }

            // Crear DetalleFragment
            val detalleFragment = DetalleFragment()

            // Crear Bundle
            val bundle = Bundle()

            bundle.putString(
                "NOMBRE_USUARIO",
                nombre
            )

            // Mandar datos al Fragment
            detalleFragment.arguments = bundle

            // Navegar al Fragment
            parentFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    detalleFragment
                )
                .addToBackStack(null)
                .commit()
        }
    }
}