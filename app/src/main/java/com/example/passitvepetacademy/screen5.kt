package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen5 : AppCompatActivity() {
    lateinit var userName : EditText
    lateinit var emailAddress : EditText
    lateinit var phoneNumber : EditText
    lateinit var password : EditText
    lateinit var confirmP : EditText
    lateinit var agree : CheckBox
    lateinit var signUp : Button
    lateinit var login : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen5)

         userName = findViewById(R.id.edtName)
         emailAddress = findViewById(R.id.edtEmailAddress)
         phoneNumber = findViewById(R.id.edtPhoneNumber)
         password = findViewById(R.id.edtPasswordCreate)
         confirmP = findViewById(R.id.edtComfirmPassword)
         agree = findViewById(R.id.checkBoxAgree)
         signUp = findViewById<Button>(R.id.btnSignup)
         login = findViewById(R.id.btnBackToLogin)

        signUp.setOnClickListener {
            val nameT = userName.text.toString().trim()
            val emailT = emailAddress.text.toString().trim()
            val phoneT = phoneNumber.text.toString().trim()
            val passwordT = password.text.toString()
            val confirmT = confirmP.text.toString()

            if (nameT.isEmpty()) {
                userName.error = "Enter your name"
                return@setOnClickListener
            }

            if (emailT.isEmpty()) {
                emailAddress.error = "Enter your email"
                return@setOnClickListener
            }
            if (phoneT.isEmpty()) {
                phoneNumber.error = "Enter your phone number"
                return@setOnClickListener
            }
            if (passwordT.isEmpty()) {
                password.error = "Enter a password"
                return@setOnClickListener
            }
            if (passwordT != confirmT) {
                confirmP.error = "Passwords do not match"
                return@setOnClickListener
            }
            if (!agree.isChecked) {
                Toast.makeText(
                    this,
                    "Please accept the Terms & Conditions",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }
            Toast.makeText(
                this,
                "Account created successfully",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(
                Intent(this, screen6::class.java)
            )
            finish()








        }
        login.setOnClickListener {
            startActivity(
                Intent(this, screen4::class.java)
            )
        }









    }
}