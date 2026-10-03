package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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

            if (emailT.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Login")
                    .setMessage("Please Enter Your Email")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }

            if (!emailT.contains("@")) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid Email")
                    .setMessage("Please Enter A Valid Email Address")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }

            if (passwordT.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Login")
                    .setMessage("Please Enter Your Password")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }

            val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("loggedInEmail", "")

            val loginIsCorrect = (emailT.equals("kamo@gmail.com", ignoreCase = true) && passwordT == "@Kamo2") ||
                    (emailT.equals("emeris@gmail.com", ignoreCase = true) && passwordT == "Emeris@School1") ||
                    (savedEmail.equals(emailT, ignoreCase = true) && passwordT.isNotEmpty())

            if (loginIsCorrect) {
                sharedPreferences.edit {
                    putString("loggedInEmail", emailT)
                }

                val intent = Intent(this, screen6::class.java)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Failed")
                    .setMessage("Invalid credentials or user not available")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        register.setOnClickListener {
            startActivity(
                Intent(this, screen5::class.java)
            )
        }

        forgotPassword.setOnClickListener {
            Toast.makeText(
                this,
                "Password reset option selected",
                Toast.LENGTH_SHORT
            ).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
