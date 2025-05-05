package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class firstLoginPage : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var signupLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // ✅ Check if user is already logged in
        if (auth.currentUser != null) {
            // User already logged in, go to home
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
            return // skip rest of login UI
        }

        setContentView(R.layout.activity_first_login_page)

        emailField = findViewById(R.id.loginemailfield)
        passwordField = findViewById(R.id.loginPasswordfieldlogin)
        loginButton = findViewById(R.id.loginButton)
        signupLink = findViewById(R.id.linkToSignuplogin)

        // Login button click
        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity2::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Login Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

        signupLink.setOnClickListener {
            val intent = Intent(this, login_signUp_page::class.java)
            startActivity(intent)
        }
    }

}