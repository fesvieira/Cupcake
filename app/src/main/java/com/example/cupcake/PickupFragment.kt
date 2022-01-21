package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentPickupBinding
import com.example.cupcake.model.OrderViewModel


class PickupFragment : Fragment() {


    private lateinit var binding: FragmentPickupBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPickupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            nextButton.setOnClickListener { goToNextScreen() }


            radioToday.apply {
                setOnClickListener {
                    sharedViewModel.setDate(sharedViewModel.dateOptions[0])
                }
                text = sharedViewModel.dateOptions[0]
            }
            radioTomorrow.apply {
                setOnClickListener {
                    sharedViewModel.setDate(sharedViewModel.dateOptions[1])
                }
                text = sharedViewModel.dateOptions[1]
            }
            radioTwoDays.apply {
                setOnClickListener {
                    sharedViewModel.setDate(sharedViewModel.dateOptions[2])
                }
                text = sharedViewModel.dateOptions[2]
            }
            radioThreeDays.apply {
                setOnClickListener {
                    sharedViewModel.setDate(sharedViewModel.dateOptions[3])
                }
                text = sharedViewModel.dateOptions[3]
            }
            sharedViewModel.price.observe(viewLifecycleOwner, {
                subtotal.text = getString(R.string.subtotal_price, it.toString())
            })
        }
    }


    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }
}