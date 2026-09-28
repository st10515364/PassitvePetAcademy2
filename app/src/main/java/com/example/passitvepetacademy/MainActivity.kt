package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        buttonNext = findViewById(R.id.btnNext)


        buttonNext.setOnClickListener {
            val intent = Intent(this, screen2::class.java)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)




    }
}