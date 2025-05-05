package com.example.splash.model

data class cartitems(
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int = 1
)