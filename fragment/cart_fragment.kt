package com.example.splash.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splash.ProceedActivity
import com.example.splash.R
import com.example.splash.adapter.CartAdapter
import com.example.splash.databinding.FragmentCartFragmentBinding
import com.example.splash.model.cartitems

class cart_fragment : Fragment() {

    private lateinit var binding: FragmentCartFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartFragmentBinding.inflate(inflater, container, false)

        // Sample data for the cart as list of CartItem
        val cartItems = mutableListOf(
            cartitems("Burger", "$5", R.drawable.imge1),
            cartitems("Sandwich", "$6", R.drawable.image2),
            cartitems("Momo", "$8", R.drawable.image3),
            cartitems("Item", "$9", R.drawable.image2),
            cartitems("Sandwich", "$10", R.drawable.imge1),
            cartitems("Momo", "$10", R.drawable.image3)
        )

        // Set up the adapter with the cart item list
        val adapter = CartAdapter(cartItems as ArrayList<cartitems>)

        binding.cartFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartFragmentRecyclerView.adapter = adapter

        // Proceed button click
        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(), ProceedActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}
