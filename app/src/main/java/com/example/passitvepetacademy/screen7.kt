package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen7 : AppCompatActivity() {
    lateinit var home : Button
    lateinit var profile: Button
    lateinit var qoute7: Button
    lateinit var courses : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen7)

        home =findViewById(R.id.btnHome7)
        profile = findViewById(R.id.btnProfile7)
        qoute7 = findViewById(R.id.btnQoute7)
        courses=findViewById(R.id.btnCourses7)

        home.setOnClickListener {
            startActivity(
                Intent(this, screen6::class.java)
            )
        }
        profile.setOnClickListener {
            startActivity(
                Intent(this, screen9::class.java)
            )
        }
        qoute7.setOnClickListener {
            startActivity(
                Intent(this, screen8::class.java)
            )
        }
        courses.setOnClickListener {
            startActivity(
                Intent(this, screen7::class.java)
            )
        }







    }
}