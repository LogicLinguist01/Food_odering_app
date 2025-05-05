package com.example.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splash.R
import com.example.splash.adapter.BottomMenuAdapter
import com.example.splash.databinding.FragmentSearchFragmentBinding

class search_fragment : Fragment() { // Followed proper class naming convention

    private lateinit var binding: FragmentSearchFragmentBinding
    private lateinit var adapter: BottomMenuAdapter

    private val originalFoodNames = listOf("Burger", "Sandwich", "Momo", "Item", "Sandwich", "Momo")
    private val originalMenuPrices = listOf("$5", "$6", "$8", "$9", "$10", "$10")
    private val originalMenuImages = listOf(
        R.drawable.imge1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image2,
        R.drawable.imge1,
        R.drawable.image3
    )

    private val filteredFoodNames = mutableListOf<String>()
    private val filteredMenuPrices = mutableListOf<String>()
    private val filteredMenuImages = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchFragmentBinding.inflate(inflater, container, false)

        adapter = BottomMenuAdapter(filteredFoodNames, filteredMenuPrices, filteredMenuImages)
        binding.bottomSheetMenuRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.bottomSheetMenuRecyclerview.adapter = adapter

        setupSearchView()
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredFoodNames.clear()
        filteredMenuPrices.clear()
        filteredMenuImages.clear()

        filteredFoodNames.addAll(originalFoodNames) // Fixed missing food names update
        filteredMenuPrices.addAll(originalMenuPrices)
        filteredMenuImages.addAll(originalMenuImages)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        if (query.isNullOrBlank()) {
            showAllMenu()
            return
        }

        filteredFoodNames.clear()
        filteredMenuPrices.clear()
        filteredMenuImages.clear()

        originalFoodNames.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredFoodNames.add(foodName)
                filteredMenuPrices.add(originalMenuPrices[index])
                filteredMenuImages.add(originalMenuImages[index])
            }
        }

        adapter.notifyDataSetChanged()
    }
}