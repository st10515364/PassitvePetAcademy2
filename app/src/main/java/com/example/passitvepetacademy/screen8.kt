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
    lateinit var qoutes: Button
    lateinit var courses : Button
    lateinit var request : Button
    lateinit var btnBack : Button

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
        qoutes = findViewById(R.id.btnQoutes8)
        courses = findViewById(R.id.btnCourses8)
        request = findViewById(R.id.btnRequestQoute)
        btnBack = findViewById(R.id.btnBack8)

        obedience = findViewById(R.id.checkBoxObedience)
        behaviour = findViewById(R.id.checkBoxBehaviour)
        walking = findViewById(R.id.checkBoxDogWalk)
        puppyBasics = findViewById(R.id.checkBoxPuppy)

        btnBack.setOnClickListener {
            finish()
        }

        home.setOnClickListener {
            startActivity(Intent(this, screen6::class.java))
        }

        courses.setOnClickListener {
            startActivity(Intent(this, screen7::class.java))
        }

        qoutes.setOnClickListener {
            // Already on quotes screen
        }

        request.setOnClickListener {
            val selectedCourses = getSelectedCourses()
            if (selectedCourses.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("No Course Selected")
                    .setMessage("Please select at least one course.")
                    .setPositiveButton("OK", null)
                    .show()
                return@setOnClickListener
            }

            val (amount, discountAmount, finalAmount) = calculateQuote()

            subtotal.text = "Subtotal: R%.2f".format(amount)
            discount.text = "Discount: R%.2f".format(discountAmount)
            total.text = "Total: R%.2f".format(finalAmount)

            AlertDialog.Builder(this)
                .setTitle("Quote Details")
                .setMessage(
                    "Your quote has been calculated.\n\n" +
                            "Courses selected: ${selectedCourses.size}\n" +
                            "Total: R%.2f".format(finalAmount)
                )
                .setPositiveButton("OK", null)
                .show()
        }

        profile.setOnClickListener {
            val selectedCourses = getSelectedCourses()
            val intent = Intent(this, screen9::class.java)
            intent.putStringArrayListExtra("selectedCourses", selectedCourses)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getSelectedCourses(): ArrayList<String> {
        val selected = arrayListOf<String>()
        if (obedience.isChecked) selected.add("Obedience Training")
        if (walking.isChecked) selected.add("Dog Walking Services")
        if (behaviour.isChecked) selected.add("Animal Behaviour")
        if (puppyBasics.isChecked) selected.add("Puppy Basics")
        return selected
    }

    private fun calculateQuote(): Triple<Double, Double, Double> {
        var amount = 0.0
        if (obedience.isChecked) amount += 850.0
        if (walking.isChecked) amount += 500.0
        if (behaviour.isChecked) amount += 1200.0
        if (puppyBasics.isChecked) amount += 650.0

        val count = getSelectedCourses().size
        val discountAmount = when {
            count == 2 -> amount * 0.05
            count >= 3 -> amount * 0.10
            else -> 0.0
        }
        val finalAmount = amount - discountAmount
        return Triple(amount, discountAmount, finalAmount)
    }
}
