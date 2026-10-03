package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen9 : AppCompatActivity() {
    lateinit var userName : TextView
    lateinit var userEmailAddress : TextView
    lateinit var chosenCourses : TextView
    lateinit var logOut : Button
    lateinit var homeNav : Button
    lateinit var coursesNav : Button
    lateinit var quoteNav : Button
    lateinit var profileNav : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen9)

        userName = findViewById(R.id.textViewName)
        userEmailAddress  = findViewById(R.id.textViewEmail)
        chosenCourses = findViewById(R.id.textViewMyBookings)
        logOut = findViewById(R.id.btnLogout)
        homeNav = findViewById(R.id.btnHome9)
        coursesNav = findViewById(R.id.btnCourses9)
        quoteNav = findViewById(R.id.btnQoute9)
        profileNav = findViewById(R.id.btnProfile9)

        homeNav.setOnClickListener {
            startActivity(Intent(this, screen6::class.java))
        }

        coursesNav.setOnClickListener {
            startActivity(Intent(this, screen7::class.java))
        }

        quoteNav.setOnClickListener {
            startActivity(Intent(this, screen8::class.java))
        }

        profileNav.setOnClickListener {
            // Already on profile
        }

        val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        val email = sharedPreferences.getString("loggedInEmail", "")
        if (!email.isNullOrEmpty()) {
            val name = email.substringBefore("@")
            val displayName = name.replaceFirstChar { it.uppercase() }

            userName.text = displayName
            userEmailAddress.text = email
        } else {
            userName.text = "No name"
            userEmailAddress.text = "No email"
        }

        val selectedCourses = intent.getStringArrayListExtra("selectedCourses")
        if (!selectedCourses.isNullOrEmpty()) {
            chosenCourses.text = selectedCourses.joinToString("\n") { "• $it" }
        } else {
            chosenCourses.text = "No courses selected"
        }

        logOut.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("ARE YOU SURE YOU WANT TO LOG OUT?")
                .setPositiveButton("YES") { _, _ ->
                    sharedPreferences.edit {
                        remove("loggedInEmail")
                    }

                    val intent = Intent(this, screen4::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("NO", null)
                .show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
