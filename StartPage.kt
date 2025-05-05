package com.example.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splash.databinding.ActivityStartPageBinding

class  StartPage : AppCompatActivity() {
    private val binding: ActivityStartPageBinding by lazy {
        ActivityStartPageBinding.inflate((layoutInflater))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            val intent = Intent (this , MainActivity2 :: class.java)
            startActivity(intent)
        }

    }
}