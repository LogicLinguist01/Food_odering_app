package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProceedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_proceed)

        val proceedButton: Button = findViewById(R.id.confirmButton)
        proceedButton.setOnClickListener {
            val intent = Intent(this, conformationSplash::class.java)
            startActivity(intent)

        }


    }
}