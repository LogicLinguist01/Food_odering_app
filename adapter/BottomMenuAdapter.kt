package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.MenuItemBinding

class BottomMenuAdapter( private  val menuItems: List<String>, private val menuPrices: List<String>, private val menuImages: List<Int>) : RecyclerView.Adapter<BottomMenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class MenuViewHolder( private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                dropdownmanuFoodname.text = menuPrices[position]
                dropdownmanuFoodTitle.text = menuItems[position]
                dropdownmanuImage.setImageResource(menuImages[position])

            }
        }

    }
}