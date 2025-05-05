package com.example.splash

object CartManager {

    // Each item is stored as a Triple: (Name, Price, ImageResource)
    private val cartItems = mutableListOf<Triple<String, String, Int>>()

    // Add an item to the cart
    fun addItem(name: String, price: String, image: Int) {
        cartItems.add(Triple(name, price, image))
    }

    // Get all items in the cart
    fun getItems(): List<Triple<String, String, Int>> {
        return cartItems
    }

    // Clear the cart
    fun clearCart() {
        cartItems.clear()
    }

    // Optional: remove a specific item
    fun removeItem(index: Int) {
        if (index >= 0 && index < cartItems.size) {
            cartItems.removeAt(index)
        }
    }
}
