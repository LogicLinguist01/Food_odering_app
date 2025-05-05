package com.example.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.splash.BottomSheetFragment
import com.example.splash.CartManager.addItem
import com.example.splash.R
import com.example.splash.adapter.PopularAdapter
import com.example.splash.databinding.FragmentHomeFragmentBinding
import com.google.android.play.integrity.internal.z


class home_fragment : Fragment() {

    private var _binding: FragmentHomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeFragmentBinding.inflate(inflater, container, false)

        // Bottom sheet click handler
        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "Test")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Image slider setup
        val imageList = arrayListOf(
            SlideModel(R.drawable.temp_pic1, ScaleTypes.FIT),
            SlideModel(R.drawable.temp_pic2, ScaleTypes.FIT),
            SlideModel(R.drawable.temp_pic3, ScaleTypes.FIT),
            SlideModel(R.drawable.temp_pic4, ScaleTypes.FIT),
            SlideModel(R.drawable.temp_pic5, ScaleTypes.FIT),
            SlideModel(R.drawable.donut, ScaleTypes.FIT),
            SlideModel(R.drawable.roohabja, ScaleTypes.FIT),
            SlideModel(R.drawable.temp_pic5, ScaleTypes.FIT)
        )
        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)

        // Sample food data
        val foodName = listOf("Donuts", "FruitCream", "VegMix", "orange juice","Roofja", "Ice Cream")
        val price = listOf("$5", "$7", "$8", "$10","2", "5", "$10", "$10")
        val popularFoodImages = listOf(R.drawable.imge1, R.drawable.image2, R.drawable.image3, R.drawable.orangejuice , R.drawable.roohabja, R.drawable.freshrose)

        // Setup PopularAdapter with add-to-cart callback
        val adapter = PopularAdapter(foodName, popularFoodImages, price) { name, itemPrice, image ->
            addItem(name, itemPrice, image)
            Toast.makeText(requireContext(), "$name added to cart", Toast.LENGTH_SHORT).show()
        }

        binding.recylerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerview.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
