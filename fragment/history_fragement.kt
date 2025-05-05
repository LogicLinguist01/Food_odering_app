package com.example.splash.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splash.R
import com.example.splash.adapter.BuyAgainAdapter
import com.example.splash.databinding.FragmentHistoryFragementBinding


class history_fragement : Fragment() {
    private lateinit var binding: FragmentHistoryFragementBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryFragementBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }
  private fun setupRecyclerView() {
      val buyAgainFoodName = listOf("Donuts", "FruitCream", "VegMix", "orange juice","Roofja", "Ice Cream")
      val buyAgainFoodPrice = listOf("$5", "$7", "$8", "$10","2", "5", "$10", "$10")
      val buyAgainFoodImage = listOf(R.drawable.imge1, R.drawable.image2, R.drawable.image3, R.drawable.orangejuice , R.drawable.roohabja, R.drawable.freshrose)
      buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
      binding.buyagainitem.adapter = buyAgainAdapter
      binding.buyagainitem.layoutManager = LinearLayoutManager(requireContext())
  }
    companion object {

    }
}