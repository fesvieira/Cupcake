package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentFlavorBinding
import com.example.cupcake.model.OrderViewModel

class FlavorFragment : Fragment() {

    private lateinit var binding: FragmentFlavorBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentFlavorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**  Apply is a scope function in the Kotlin standard library.
         *   It executes a block of code within the context of an object.
         *   It forms a temporary scope, and in that scope, you can access
         *   the object without its name. The common use case for apply is
         *   to configure an object.         ### */

        binding.apply {
            nextButton.setOnClickListener { goToNextScreen() }

            radioVanilla.setOnClickListener {
                    sharedViewModel.setFlavor(getString(R.string.vanilla))
                }

            radioChocolate.setOnClickListener {
                    sharedViewModel.setFlavor(getString(R.string.chocolate))
                }

            radioRedVelvet.setOnClickListener {
                    sharedViewModel.setFlavor(getString(R.string.red_velvet))
                }

            radioSaltedCaramel.setOnClickListener {
                    sharedViewModel.setFlavor(getString(R.string.salted_caramel))
                }

            radioCoffee.setOnClickListener {
                    sharedViewModel.setFlavor(getString(R.string.coffee))
                }

            sharedViewModel.price.observe(viewLifecycleOwner, {
                subtotal.text = getString(R.string.subtotal_price, it.toString())
            })

        }
    }


    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

}