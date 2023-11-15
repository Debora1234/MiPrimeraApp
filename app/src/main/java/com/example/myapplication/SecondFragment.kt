package com.example.myapplication



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    /*definimos donde estan los argumentos */


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonSecond).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        /* codigo para la funcion random */

        val count = args.myArg
        repeat(count) {
            updateUI(count)
        }

    }

    private fun updateUI(count: Int) {

        val countText = getString(R.string.textviewHeaderText, count)
        view?.findViewById<TextView>(R.id.textviewHeader)?.text = countText

        val random = java.util.Random()

        // Hago una lista, con los textview.
        val textViewList = listOf(
            view?.findViewById<TextView>(R.id.textViewRandom1),
            view?.findViewById<TextView>(R.id.textViewRandom2),
            view?.findViewById<TextView>(R.id.textViewRandom3),
            view?.findViewById<TextView>(R.id.textViewRandom4),
            view?.findViewById<TextView>(R.id.textViewRandom5),
            view?.findViewById<TextView>(R.id.textViewRandom6)
        )

        // repetimos el proceso count veces
        for (i in 0 until count) {
            // Genera un número aleatorio en el rango [1, 6] para simular un lanzamiento de dado.
            val randomNumber = random.nextInt(6) + 1

            // Asigna el resultado a cada TextView correspondiente.
            textViewList.getOrNull(i)?.text = randomNumber.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}