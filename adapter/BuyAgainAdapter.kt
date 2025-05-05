package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.BuyrecentfooditemsBinding

class BuyAgainAdapter(
    private val buyAgainFoodName: List<String>,
    private val buyAgainFoodPrice: List<String>,
    private val buyAgainFoodImage: List<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding =
            BuyrecentfooditemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainFoodName.size

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(
            buyAgainFoodName[position],
            buyAgainFoodPrice[position],
            buyAgainFoodImage[position]
        )
    }

    class BuyAgainViewHolder(private val binding: BuyrecentfooditemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.HistoryCardfoodTitle.text = foodName
            binding.HistoryCardViewFoodname.text = foodPrice
            binding.Historyimage.setImageResource(foodImage)
        }

    }
}
