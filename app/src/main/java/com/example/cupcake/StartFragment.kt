package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.model.OrderViewModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    // Shared view model call
    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate and associate fragment context to binding variable
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set buttons function
        binding.apply {
            orderOneCupcake.setOnClickListener { orderCupcake(1) }
            orderSixCupcakes.setOnClickListener { orderCupcake(6) }
            orderTwelveCupcakes.setOnClickListener { orderCupcake(12) }
        }
    }

    /* Set the standard flavor, update quantity variable according to button pressed
     * goes to next fragment */
    private fun orderCupcake(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }

        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }

}