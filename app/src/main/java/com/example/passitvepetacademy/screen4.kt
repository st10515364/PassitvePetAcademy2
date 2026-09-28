package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen4 : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var register: Button
    lateinit var forgotPassword: Button
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen4)
        email = findViewById(R.id.edtEmail)
        password = findViewById(R.id.edtPassword)
        register = findViewById(R.id.btnRegister)
        forgotPassword = findViewById(R.id.btnForgotPassword)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener {
            val emailT = email.text.toString().trim()
            val passwordT = password.text.toString()


            // checking whether if the fields are empty
            if (emailT.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Login")
                    .setMessage("Please Enter Your Email")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener

            }
            if (!emailT.lowercase().endsWith("@gmail.com")) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid Email")
                    .setMessage("Please Enter A Valid Gmail Address")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }
            val loginIsCorrect = (emailT.equals("kamo@gmail.com", ignoreCase = true)
                    && passwordT == "@Kamo2") ||
                    (emailT.equals("emeris@gmail.com", ignoreCase = true)
                            && passwordT == "Emeris@School1")


            if (loginIsCorrect) {
                val sharedPreferences =
                    getSharedPreferences("User Data",MODE_PRIVATE)
                sharedPreferences.edit()
                    .putString("LoggedInEmail",emailT)


                val intent = Intent(this, screen5::class.java)
                startActivity(intent)
                finish()


            } else {

                AlertDialog.Builder(this)
                    .setTitle("Login Failed")
                    .setMessage("User not available")
                    .setPositiveButton("OK", null)
                    .show()
                }



        }
        register.setOnClickListener {
            startActivity(
                Intent(this, screen5::class.java)
            )}
        forgotPassword.setOnClickListener {
            Toast.makeText(
                this,
                "Password reset option selected",
                Toast.LENGTH_SHORT
            ).show()
        }


    }















    }



