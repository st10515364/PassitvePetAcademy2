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
    lateinit var qoutes : Button
    lateinit var profile : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen6)
         browse = findViewById(R.id.btnBrowseCourses)

         courses=
            findViewById(R.id.btnCourses)

         qoutes =
            findViewById(R.id.btnQoute)

         profile =
            findViewById(R.id.btnProfile)
        browse.setOnClickListener {
            startActivity(
                Intent(this, screen7::class.java)
            )
        }
        courses.setOnClickListener {
            startActivity(
                Intent(this, screen7::class.java)
            )
        }

        qoutes.setOnClickListener {
            startActivity(
                Intent(this, screen8::class.java)
            )
        }
        profile.setOnClickListener {
            startActivity(
                Intent(this, screen9::class.java)
            )
        }



    }
}