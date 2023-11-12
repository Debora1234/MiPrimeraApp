package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    /*método para leer el estado del tex, incrementarlo e irlo mostrando*/
    private fun countMe(view: View) {
        /*obtenemos el "estado" del text*/
        val showCountTextView = view.findViewById<TextView>(R.id.textviewFirst)
        /*obtenemos el valor del text*/
        val countSring = showCountTextView.text.toString()
        var count = countSring.toInt()
        count++
        /*mostramos el nuevo valor en el text*/
        showCountTextView.text=count.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //método para el boton de next, ir de la primer pantalla a la segunda
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        //método para escuchar cuando se pulsa el boton toast, e imprimir un cartel
        view.findViewById<Button>(R.id.toastButton).setOnClickListener {
            val myToast= Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        view.findViewById<Button>(R.id.countButton).setOnClickListener {
            countMe(view)
        }


        view.findViewById<Button>(R.id.randomButton).setOnClickListener{3
            val showCountTextView = view.findViewById<TextView>(R.id.textviewFirst)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


