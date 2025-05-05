package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.PopularItemsBinding

class PopularAdapter(
    private val items: List<String>,
    private val images: List<Int>,
    private val prices: List<String>,
    private val onAddToCartClick: (String, String, Int) -> Unit // callback for button
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = PopularItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val currentItem = items[position]
        val currentImage = images[position]
        val currentPrice = prices[position]
        holder.bind(currentItem, currentImage, currentPrice, onAddToCartClick)
    }

    class PopularViewHolder(private val binding: PopularItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, image: Int, price: String, onAddToCartClick: (String, String, Int) -> Unit) {
            binding.textView13.text = price
            binding.textView14.text = item
            binding.popularImage.setImageResource(image)

            // Make sure the "Add to Cart" button exists in your XML with ID: addToCartButton
            binding.addCartPopular.setOnClickListener {
                onAddToCartClick(item, price, image)
            }
        }
    }
}
