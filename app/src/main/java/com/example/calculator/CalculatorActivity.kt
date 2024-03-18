package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityCalculatorBinding
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var expression: net.objecthunter.exp4j.Expression

    var lastNumeric = false
    var lastDot = false
    var stateError = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun onAllclearClick(view: View) {
        binding.workingTxtView.text = ""
        binding.resultTxtView.text = ""
        stateError = false
        lastDot = false
        lastNumeric = false
        binding.resultTxtView.visibility = View.GONE
    }

    fun onClearClick(view: View) {
        binding.workingTxtView.text = ""
        lastNumeric = false
    }

    fun onBackClick(view: View) {
        binding.workingTxtView.text = binding.workingTxtView.text.toString().dropLast(1)
        try {
            val lastChar = binding.workingTxtView.text.toString().last()

            if (lastChar.isDigit()) {
                onEqual()
            }
        } catch (e: Exception) {
            binding.resultTxtView.text = ""
            binding.resultTxtView.visibility = View.GONE
            Log.e("Last character Error", e.toString())
        }
    }

    fun onOperatorClick(view: View) {
        if(!stateError && lastNumeric) {
            binding.workingTxtView.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }
    }

    fun onDigitClick(view: View) {
        if(stateError) {
            binding.workingTxtView.text = (view as Button).text
            stateError = false
        } else {
            binding.workingTxtView.append((view as Button).text)
        }

        lastNumeric = true
        onEqual()
    }

    fun onEqualClick(view: View) {
        onEqual()
        binding.workingTxtView.text = binding.resultTxtView.text.toString().drop(1)
    }

    fun onEqual() {
        if(lastNumeric && !stateError) {
            val txt = binding.workingTxtView.text.toString()
            expression = ExpressionBuilder(txt).build()

            try {
                val result = expression.evaluate()
                binding.resultTxtView.visibility = View.VISIBLE
                binding.resultTxtView.text = "=" + result.toString()
            } catch (ex: ArithmeticException) {
                Log.e("Evaluate Error", ex.toString())
                binding.resultTxtView.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}