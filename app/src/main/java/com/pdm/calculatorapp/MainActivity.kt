package com.pdm.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.pdm.calculatorapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDelete.setOnClickListener {
            binding.etCalculations.setText(binding.etCalculations.text.dropLast(1))
        }

        binding.btnClear.setOnClickListener {
            binding.etCalculations.text.clear()
        }

        binding.btnEquals.setOnClickListener {
            when(operator){
                "Multiplication" -> {
                    binding.etCalculations.setText("${firstValue * binding.etCalculations.text.toString().toDouble()}")
                }
                "Division" -> {
                    binding.etCalculations.setText("${firstValue / binding.etCalculations.text.toString().toDouble()}")
                }
                "Addition" -> {
                    binding.etCalculations.setText("${firstValue + binding.etCalculations.text.toString().toDouble()}")
                }
                "Subtraction" -> {
                    binding.etCalculations.setText("${firstValue - binding.etCalculations.text.toString().toDouble()}")
                }
                else -> { }
            }
        }

        binding.btnPercentage.setOnClickListener {
            binding.etCalculations.setText("${binding.etCalculations.text.toString().toDouble() / 100}")
        }

    }

    fun numberButtonClicked(view: View) {
        val button = view as Button

        when(button.id){
            //ADDED Condition for decimal
            binding.btnDecimal.id->{
                if (!binding.etCalculations.text.contains('.')){
                    binding.etCalculations.text.append(".")
                }
            }
            binding.btnZero.id  -> { binding.etCalculations.text.append("0") }
            binding.btnOne.id   -> { binding.etCalculations.text.append("1") }
            binding.btnTwo.id   -> { binding.etCalculations.text.append("2") }
            binding.btnThree.id -> { binding.etCalculations.text.append("3") }
            binding.btnFour.id ->  { binding.etCalculations.text.append("4") }
            binding.btnFive.id ->  { binding.etCalculations.text.append("5") }
            binding.btnSix.id ->   { binding.etCalculations.text.append("6") }
            binding.btnSeven.id -> { binding.etCalculations.text.append("7") }
            binding.btnEight.id -> { binding.etCalculations.text.append("8") }
            binding.btnNine.id ->  { binding.etCalculations.text.append("9") }
            else -> { Toast.makeText(this,"else",Toast.LENGTH_SHORT).show() }
        }
    }

    fun operatorClicked(view: View){
        val button = view as Button

        operator = when(button.id){
            binding.btnMultiplication.id -> { "Multiplication" }
            binding.btnDivision.id -> { "Division" }
            binding.btnAddition.id -> { "Addition" }
            binding.btnSubtraction.id -> { "Subtraction" }
            else -> { "" }
        }

        firstValue = binding.etCalculations.text.toString().toDouble()

        binding.etCalculations.text.clear()

    }
}



































