package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.CartItemBinding
import com.example.splash.model.cartitems

class CartAdapter(
    private val cartItems: ArrayList<cartitems>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: cartitems) {
            binding.apply {
                FOODNAME.text = item.name
                cartItemPrice.text = item.price
                cartImage.setImageResource(item.imageResId)
                cartItemQuantity.text = item.quantity.toString()

                miniButton.setOnClickListener {
                    if (item.quantity > 1) {
                        item.quantity--
                        cartItemQuantity.text = item.quantity.toString()
                    }
                }

                maxButton.setOnClickListener {
                    if (item.quantity < 10) {
                        item.quantity++
                        cartItemQuantity.text = item.quantity.toString()
                    }
                }

                deleteButton.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        cartItems.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, cartItems.size)
                    }
                }
            }
        }
    }
}
