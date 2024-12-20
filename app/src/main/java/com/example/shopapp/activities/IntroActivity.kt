package com.example.shopapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.example.shopapp.R // Ensure this is present
import com.example.shopapp.databinding.ActivityLoginRegisterBinding// Ensure View Binding is set up

class IntroActivity : AppCompatActivity() { // Must extend AppCompatActivity
    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a click listener for the button
        binding.startButton.setOnClickListener {
            // Define behavior for the button
        }
    }
}
