package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.calculator.ui.theme.CalculatorTheme

import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.d("Status:", "onCreate Called")

        btnClearAll.setOnClickListener {
            workingTxtView.text = ""
            resultTxtView.text = ""
        }

        btnOpenBracket.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("(")
        }

        btnCloseBracket.setOnClickListener {
            workingTxtView.text = addToWorkingTextView(")")
        }

        btnEight.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("8")
        }

        btnNine.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("9")
        }

        btnSeven.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("7")
        }

        btnSix.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("6")
        }

        btnFive.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("5")
        }

        btnFour.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("4")
        }

        btnThree.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("3")
        }

        btnTwo.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("2")
        }

        btnOne.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("1")
        }

        btnPoint.setOnClickListener {
            workingTxtView.text = addToWorkingTextView(".")
        }

        btnDivide.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("÷")  // "÷"  - ALT + 0247
        }

        btnMultiplication.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("*") // "×" - ALT + 0215
        }

        btnAddition.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("+")
        }

        btnSubtraction.setOnClickListener {
            workingTxtView.text = addToWorkingTextView("-")
        }

        btnEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToWorkingTextView(buttonValue: String): String {
        return "${workingTxtView.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = workingTxtView.text.replace(Regex("÷"), replacement = "/")
        //expression = workingTxtView.text.replace(Regex("×"), replacement = "*")
        return expression
    }

    private fun showResult() {
        try {
            var expression = getInputExpression()
            var result = Expression(expression).calculate()
            if(result.isNaN()) {
                //show error Message
                resultTxtView.text = "Error"
                resultTxtView.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                //show result
                resultTxtView.text = DecimalFormat("0.######").format(result).toString()
                resultTxtView.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }
        catch (e: Exception) {
            //show error message
            resultTxtView.text = "Error"
            resultTxtView.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}