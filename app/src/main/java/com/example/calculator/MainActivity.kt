package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.calculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun inputIsNotEmpty(): Boolean {
        var b = true;
        if (binding.workingTxtView1.text.toString().trim().isEmpty()) {
            binding.workingTxtView1.error = "Required"
            binding.workingTxtView1.requestFocus()
            b = false;
        }
        if (binding.workingTxtView2.text.toString().trim().isEmpty()) {
            binding.workingTxtView2.error = "Required"
            binding.workingTxtView2.requestFocus()
            b = false;
        }
        return b;
    }

    fun onAddClick(view: View) {
        if (inputIsNotEmpty()) {
            var inputdata1 = binding.workingTxtView1.text.toString().trim().toBigDecimal()
            var inputdata2 = binding.workingTxtView2.text.toString().trim().toBigDecimal()
            binding.resultTxtView.text = inputdata1.add(inputdata2).toString()
        }
       //binding.resultTxtView.setOnClickListener(viewModel.userClicked())
    }

    fun onSubtractClick(view: View) {
        if (inputIsNotEmpty()) {
            var inputdata1 = binding.workingTxtView1.text.toString().trim().toBigDecimal()
            var inputdata2 = binding.workingTxtView2.text.toString().trim().toBigDecimal()
            binding.resultTxtView.text = inputdata1.subtract(inputdata2).toString();
        }
    }

    fun onMultiplyClick(view: View) {
        if (inputIsNotEmpty()) {
            var inputdata1 = binding.workingTxtView1.text.toString().trim().toBigDecimal()
            var inputdata2 = binding.workingTxtView2.text.toString().trim().toBigDecimal()
            binding.resultTxtView.text = inputdata1.multiply(inputdata2).toString()
        }
    }

    fun onDivideClick(view: View) {
        if (inputIsNotEmpty()) {
            var inputdata1 = binding.workingTxtView1.text.toString().trim().toBigDecimal()
            var inputdata2 = binding.workingTxtView2.text.toString().trim().toBigDecimal()

            if (inputdata2.compareTo(BigDecimal.ZERO) == 0) {
                binding.workingTxtView2.error = "invalid input"
            } else {
//                binding.resultTxtView.text =
//                    inputdata1.divide(inputdata2, 2, RoundingMode.HALF_UP).toString();
                binding.resultTxtView.text = (inputdata1 / inputdata2).toString()
            }
        }
    }
}