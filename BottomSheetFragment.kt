package com.example.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splash.adapter.BottomMenuAdapter
import com.example.splash.adapter.CartAdapter
import com.example.splash.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        // Sample data for the cart
        val menuFoodName = listOf("Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo")
        val menuItemPrice = listOf("$5", "$6", "$8", "$9", "$10", "$10")
        val menuImage = listOf(
            R.drawable.imge1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image2,
            R.drawable.imge1,
            R.drawable.image3
        )

        // Set up the adapter with sample data
        val adapter = BottomMenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage)
        )

        // Configure the RecyclerView
        binding.bottomSheetMenuRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.bottomSheetMenuRecyclerview.adapter = adapter

        return binding.root
    }

    companion object {

    }
}