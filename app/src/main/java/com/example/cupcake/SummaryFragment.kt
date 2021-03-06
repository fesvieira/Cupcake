package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cupcake.databinding.FragmentSummaryBinding
import com.example.cupcake.model.OrderViewModel

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentSummaryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sendButton.setOnClickListener { sendOrder() }
            sharedViewModel.quantity.observe(viewLifecycleOwner, {
                textQuantity.text = it.toString()
            })

            sharedViewModel.flavor.observe(viewLifecycleOwner, {
                textFlavor.text = it.toString()
            })

            sharedViewModel.date.observe(viewLifecycleOwner, {
                textDate.text = it.toString()
            })

            sharedViewModel.price.observe(viewLifecycleOwner, {
                textTotal.text = getString(R.string.total_price, it.toString())
            })

        }
    }


    private fun sendOrder() {
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
    }

}