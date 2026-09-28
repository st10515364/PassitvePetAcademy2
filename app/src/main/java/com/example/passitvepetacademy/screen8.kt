package com.example.passitvepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screen8 : AppCompatActivity() {
     lateinit var subtotal : TextView
     lateinit var discount: TextView
     lateinit var total: TextView
    lateinit var home : Button
    lateinit var profile: Button
    lateinit var qoute7: Button
    lateinit var courses : Button
    lateinit var request : Button

     lateinit var obedience : CheckBox
     lateinit var behaviour: CheckBox
     lateinit var walking: CheckBox
    lateinit var puppyBasics: CheckBox



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen8)

        subtotal = findViewById(R.id.textViewSubtotal)
        discount = findViewById(R.id.textViewDiscount)
        total = findViewById(R.id.textViewTotal)
        home = findViewById(R.id.btnHome8)
        profile = findViewById(R.id.btnProfile8)
        qoute7 = findViewById(R.id.btnQoutes8)
        courses = findViewById(R.id.btnCourses8)
        request = findViewById(R.id.btnRequestQoute)
        obedience = findViewById(R.id.checkBoxObedience)
        behaviour = findViewById(R.id.checkBoxBehaviour)
        walking = findViewById(R.id.checkBoxDogWalk)
        puppyBasics = findViewById(R.id.checkBoxPuppy)

        request.setOnClickListener {
            val selectedCourses = arrayListOf<String>()
            if (obedience.isChecked) {
                selectedCourses.add("Obedience Training")
            }
            if (walking.isChecked) {
                selectedCourses.add("Dog Walking Services")
            }
            if (behaviour.isChecked) {
                selectedCourses.add("Animal Behaviour")
            }
            if (puppyBasics.isChecked) {
                selectedCourses.add("Puppy Basics")
            }
            if (selectedCourses.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("No Course Selected")
                    .setMessage("Please select at least one course.")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }
            var amount = 0.0
            if (obedience.isChecked) {
                amount += 850.0
            }
            if (walking.isChecked) {
                amount += 500.0
            }
            if (behaviour.isChecked) {
                amount += 1200.0
            }
            if (puppyBasics.isChecked) {
                amount += 650.0
            }

            val numberOfCourses = selectedCourses.size

            val discountAmount: Double
            if (numberOfCourses == 2) {
                discountAmount = amount * 0.05
            } else if (numberOfCourses >= 3) {
                discountAmount = amount * 0.10
            } else {
                discountAmount = 0.0
            }

            val finalAmount = amount - discountAmount
            subtotal.text = "Subtotal: R%.2f".format(amount)
            discount.text = "Discount: R%.2f".format(discountAmount)
            total.text = "Total: R%.2f".format(finalAmount)

            AlertDialog.Builder(this)
                .setMessage(
                    "Your quote has been calculated.\n\n" +
                            "Courses That you selected: $numberOfCourses\n"
                            + "Total: R%.2f".format(finalAmount)
                )
                .setPositiveButton("OK", null)
                .show()


        }
        profile.setOnClickListener {
            val selectedCourses = arrayListOf<String>()
            if (obedience.isChecked) {
                selectedCourses.add("Obedience Training")
            }
            if (walking.isChecked) {
                selectedCourses.add("Dog Walking Services")
            }
            if (behaviour.isChecked) {
                selectedCourses.add("Animal Behaviour")
            }
            if (puppyBasics.isChecked) {
                selectedCourses.add("Puppy Basics")
            }
            val intent = Intent(this, screen9::class.java)
            intent.putStringArrayListExtra( "selectedCourses", selectedCourses )
            startActivity(intent)
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
    }