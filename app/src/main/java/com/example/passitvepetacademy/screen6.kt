package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen6 : AppCompatActivity() {
    lateinit var browse : Button
    lateinit var courses : Button
    lateinit var quotes : Button
    lateinit var profile : Button
    lateinit var home : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen6)

        browse = findViewById(R.id.btnBrowseCourses)
        courses = findViewById(R.id.btnCourses)
        quotes = findViewById(R.id.btnQoute)
        profile = findViewById(R.id.btnProfile)
        home = findViewById(R.id.btnHome)

        browse.setOnClickListener {
            startActivity(Intent(this, screen7::class.java))
        }
        courses.setOnClickListener {
            startActivity(Intent(this, screen7::class.java))
        }
        quotes.setOnClickListener {
            startActivity(Intent(this, screen8::class.java))
        }
        profile.setOnClickListener {
            startActivity(Intent(this, screen9::class.java))
        }
        home.setOnClickListener {
            // Already on home screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
