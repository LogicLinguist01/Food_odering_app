package com.example.splash

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash.databinding.ActivityLocationSelectionBinding

class location_selection : AppCompatActivity() {

    private val binding: ActivityLocationSelectionBinding by lazy {
        ActivityLocationSelectionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val daar = arrayOf("Mansa","UIC","CU","Kharar")
        val adapter = ArrayAdapter(this, R.layout.simple_expandable_list_item_1,daar)
        val autoCompleteTextView = binding.autoCompleteTextView
        autoCompleteTextView.setAdapter(adapter)

        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        }
    }
