package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen9 : AppCompatActivity() {
    lateinit var userName : TextView
    lateinit var userEmailAddress : TextView
    lateinit var chosenCourses : TextView
    lateinit var logOut : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen9)

        userName = findViewById(R.id.textViewName)
        userEmailAddress  = findViewById(R.id.textViewEmail)
        chosenCourses = findViewById(R.id.textViewMyBookings)
        logOut=findViewById(R.id.btnLogout)

        val sharedPreferences =
            getSharedPreferences("UserData", MODE_PRIVATE)

        val email = sharedPreferences.getString("loggedInEmail", "")
        if (!email.isNullOrEmpty()) {

            // Get the part before @
            val name = email.substringBefore("@")

            // Make first letter uppercase
            val displayName =
                name.replaceFirstChar { it.uppercase() }

            userName.text = displayName
            userEmailAddress.text = email

        }else {
            userName.text = "No name"
            userEmailAddress.text = "No email"
        }
        val selectedCourses =
            intent.getStringArrayListExtra("selectedCourses")
        if (!selectedCourses.isNullOrEmpty()) {

            chosenCourses.text =
                selectedCourses.joinToString("\n") {
                    "• $it"
                }

        }
        else {
            chosenCourses.text = "No courses selected"
        }
        logOut.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("ARE YOU SURE YOU WANT TO LOG OUT?")
                .setPositiveButton("YES") { _, _ ->


                    sharedPreferences.edit()
                        .remove("loggedInEmail")
                        .apply()
                    val intent =
                        Intent(this, screen4::class.java)

                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)

                    finish()
                }
                .setNegativeButton("NO", null)
                .show()
        }



    }
}