package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun tipCalc (view: View) {

        if (binding.editTextNumberDecimal.text.isNotEmpty()) {

            val billValue = binding.editTextNumberDecimal.text.toString().toFloat()

            val tipValue15 = billValue +(billValue * 0.15f)
            val tipValue20 = billValue + (billValue * 0.20f)
            val tipValue25 = billValue + (billValue * 0.25f)

            binding.TipAmounts.text = "15% - $tipValue15\n20% - $tipValue20\n25% - $tipValue25"
        } else {
            binding.TipAmounts.text = "Please enter an amount."
        }
    }

}