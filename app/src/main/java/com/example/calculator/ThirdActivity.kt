package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import com.example.calculator.databinding.ActivityCalculatorBinding
import com.example.calculator.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
        //binding
        private lateinit var binding : ActivityThirdBinding

        //other
        private var firstNumber = ""
        private var currentNumber = ""
        private var currentOperator = ""
        private var result = ""
        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState : Bundle?)
        {
            super.onCreate(savedInstanceState)
            binding = ActivityThirdBinding.inflate(layoutInflater)
            setContentView(binding.root)


            //functions
            fun evaluateExpression(firstNumber:String,secondNumber:String,operator:String):String
            {
                val num1  = firstNumber.toDouble()
                val num2  = secondNumber.toDouble()
                return when(operator)
                {
                    "+"-> (num1+num2).toString()
                    "-"-> (num1-num2).toString()
                    "*"-> (num1*num2).toString()
                    "/"-> (num1/num2).toString()
                    "%"-> (num1%num2).toString()
                    else ->""
                }
            }


            //NoLimitScreen
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            //initViews
            binding.apply {
                // get all buttons

                binding.layoutOne.children.filterIsInstance<Button>().forEach { button ->
                    //buttons click listener
                    button.setOnClickListener {
                        //get clicked button text
                        val buttonText = button.text.toString()
                        when {
                            buttonText.matches(Regex("[0-9]")) -> {
                                if (currentOperator.isEmpty()) {
                                    firstNumber += buttonText
                                    resultTxtView.text = firstNumber
                                } else {
                                    currentNumber += buttonText
                                    resultTxtView.text = currentNumber
                                }
                            }

                            buttonText.matches(Regex("[+%*/-]")) -> {
                                currentNumber = ""
                                if (resultTxtView.text.toString().isNotEmpty()) {
                                    currentOperator = buttonText
                                    resultTxtView.text = "0"
                                }
                            }

                            buttonText == "=" -> {
                                if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                                    workingTxtView.text =
                                        "$firstNumber$currentOperator$currentNumber"
                                    result = evaluateExpression(
                                        firstNumber,
                                        currentNumber,
                                        currentOperator
                                    )
                                    firstNumber = result
                                    resultTxtView.text = result
                                }
                            }

                            buttonText == "." -> {
                                if (currentOperator.isEmpty()) {
                                    if (!firstNumber.contains(".")) {
                                        if (firstNumber.isEmpty()) firstNumber += "0$buttonText"
                                        else firstNumber += buttonText
                                        resultTxtView.text = firstNumber
                                    }
                                } else {
                                    if (!currentNumber.contains(".")) {
                                        if (currentNumber.isEmpty()) currentNumber += "0$buttonText"
                                        else currentNumber += buttonText
                                        resultTxtView.text = currentNumber
                                    }
                                }
                            }

                            buttonText == "C" -> {
                                currentNumber = ""
                                firstNumber = ""
                                currentOperator = ""
                                //resultTxtView.text = "0"
                                workingTxtView.text = ""
                            }

                            buttonText == "AC" -> {
                                currentNumber = ""
                                firstNumber = ""
                                currentOperator = ""
                                resultTxtView.text = "0"
                                workingTxtView.text = ""
                            }
                        }
                    }

                    binding.layoutTwo.children.filterIsInstance<Button>().forEach { button ->
                        //buttons click listener
                        button.setOnClickListener {
                            //get clicked button text
                            val buttonText = button.text.toString()
                            when {
                                buttonText.matches(Regex("[0-9]")) -> {
                                    if (currentOperator.isEmpty()) {
                                        firstNumber += buttonText
                                        resultTxtView.text = firstNumber
                                    } else {
                                        currentNumber += buttonText
                                        resultTxtView.text = currentNumber
                                    }
                                }

                                buttonText.matches(Regex("[+%*/-]")) -> {
                                    currentNumber = ""
                                    if (resultTxtView.text.toString().isNotEmpty()) {
                                        currentOperator = buttonText
                                        resultTxtView.text = "0"
                                    }
                                }

                                buttonText == "=" -> {
                                    if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                                        workingTxtView.text =
                                            "$firstNumber$currentOperator$currentNumber"
                                        result = evaluateExpression(
                                            firstNumber,
                                            currentNumber,
                                            currentOperator
                                        )
                                        firstNumber = result
                                        resultTxtView.text = result
                                    }
                                }

                                buttonText == "." -> {
                                    if (currentOperator.isEmpty()) {
                                        if (!firstNumber.contains(".")) {
                                            if (firstNumber.isEmpty()) firstNumber += "0$buttonText"
                                            else firstNumber += buttonText
                                            resultTxtView.text = firstNumber
                                        }
                                    } else {
                                        if (!currentNumber.contains(".")) {
                                            if (currentNumber.isEmpty()) currentNumber += "0$buttonText"
                                            else currentNumber += buttonText
                                            resultTxtView.text = currentNumber
                                        }
                                    }
                                }

                                buttonText == "C" -> {
                                    currentNumber = ""
                                    firstNumber = ""
                                    currentOperator = ""
                                    //resultTxtView.text = "0"
                                    workingTxtView.text = ""
                                }

                                buttonText == "AC" -> {
                                    currentNumber = ""
                                    firstNumber = ""
                                    currentOperator = ""
                                    resultTxtView.text = "0"
                                    workingTxtView.text = ""
                                }
                            }
                        }

                        binding.layoutThree.children.filterIsInstance<Button>().forEach { button ->
                            //buttons click listener
                            button.setOnClickListener {
                                //get clicked button text
                                val buttonText = button.text.toString()
                                when {
                                    buttonText.matches(Regex("[0-9]")) -> {
                                        if (currentOperator.isEmpty()) {
                                            firstNumber += buttonText
                                            resultTxtView.text = firstNumber
                                        } else {
                                            currentNumber += buttonText
                                            resultTxtView.text = currentNumber
                                        }
                                    }

                                    buttonText.matches(Regex("[+%*/-]")) -> {
                                        currentNumber = ""
                                        if (resultTxtView.text.toString().isNotEmpty()) {
                                            currentOperator = buttonText
                                            resultTxtView.text = "0"
                                        }
                                    }

                                    buttonText == "=" -> {
                                        if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                                            workingTxtView.text =
                                                "$firstNumber$currentOperator$currentNumber"
                                            result = evaluateExpression(
                                                firstNumber,
                                                currentNumber,
                                                currentOperator
                                            )
                                            firstNumber = result
                                            resultTxtView.text = result
                                        }
                                    }

                                    buttonText == "." -> {
                                        if (currentOperator.isEmpty()) {
                                            if (!firstNumber.contains(".")) {
                                                if (firstNumber.isEmpty()) firstNumber += "0$buttonText"
                                                else firstNumber += buttonText
                                                resultTxtView.text = firstNumber
                                            }
                                        } else {
                                            if (!currentNumber.contains(".")) {
                                                if (currentNumber.isEmpty()) currentNumber += "0$buttonText"
                                                else currentNumber += buttonText
                                                resultTxtView.text = currentNumber
                                            }
                                        }
                                    }

                                    buttonText == "C" -> {
                                        currentNumber = ""
                                        firstNumber = ""
                                        currentOperator = ""
                                        //resultTxtView.text = "0"
                                        workingTxtView.text = ""
                                    }

                                    buttonText == "AC" -> {
                                        currentNumber = ""
                                        firstNumber = ""
                                        currentOperator = ""
                                        resultTxtView.text = "0"
                                        workingTxtView.text = ""
                                    }
                                }
                            }

                            binding.layoutFour.children.filterIsInstance<Button>()
                                .forEach { button ->
                                    //buttons click listener
                                    button.setOnClickListener {
                                        //get clicked button text
                                        val buttonText = button.text.toString()
                                        when {
                                            buttonText.matches(Regex("[0-9]")) -> {
                                                if (currentOperator.isEmpty()) {
                                                    firstNumber += buttonText
                                                    resultTxtView.text = firstNumber
                                                } else {
                                                    currentNumber += buttonText
                                                    resultTxtView.text = currentNumber
                                                }
                                            }

                                            buttonText.matches(Regex("[+%*/-]")) -> {
                                                currentNumber = ""
                                                if (resultTxtView.text.toString().isNotEmpty()) {
                                                    currentOperator = buttonText
                                                    resultTxtView.text = "0"
                                                }
                                            }

                                            buttonText == "=" -> {
                                                if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                                                    workingTxtView.text =
                                                        "$firstNumber$currentOperator$currentNumber"
                                                    result = evaluateExpression(
                                                        firstNumber,
                                                        currentNumber,
                                                        currentOperator
                                                    )
                                                    firstNumber = result
                                                    resultTxtView.text = result
                                                }
                                            }

                                            buttonText == "." -> {
                                                if (currentOperator.isEmpty()) {
                                                    if (!firstNumber.contains(".")) {
                                                        if (firstNumber.isEmpty()) firstNumber += "0$buttonText"
                                                        else firstNumber += buttonText
                                                        resultTxtView.text = firstNumber
                                                    }
                                                } else {
                                                    if (!currentNumber.contains(".")) {
                                                        if (currentNumber.isEmpty()) currentNumber += "0$buttonText"
                                                        else currentNumber += buttonText
                                                        resultTxtView.text = currentNumber
                                                    }
                                                }
                                            }

                                            buttonText == "C" -> {
                                                currentNumber = ""
                                                firstNumber = ""
                                                currentOperator = ""
                                                //resultTxtView.text = "0"
                                                workingTxtView.text = ""
                                            }

                                            buttonText == "AC" -> {
                                                currentNumber = ""
                                                firstNumber = ""
                                                currentOperator = ""
                                                resultTxtView.text = "0"
                                                workingTxtView.text = ""
                                            }
                                        }
                                    }

                                    binding.layoutFive.children.filterIsInstance<Button>()
                                        .forEach { button ->
                                            //buttons click listener
                                            button.setOnClickListener {
                                                //get clicked button text
                                                val buttonText = button.text.toString()
                                                when {
                                                    buttonText.matches(Regex("[0-9]")) -> {
                                                        if (currentOperator.isEmpty()) {
                                                            firstNumber += buttonText
                                                            resultTxtView.text = firstNumber
                                                        } else {
                                                            currentNumber += buttonText
                                                            resultTxtView.text = currentNumber
                                                        }
                                                    }

                                                    buttonText.matches(Regex("[+%*/-]")) -> {
                                                        currentNumber = ""
                                                        if (resultTxtView.text.toString()
                                                                .isNotEmpty()
                                                        ) {
                                                            currentOperator = buttonText
                                                            resultTxtView.text = "0"
                                                        }
                                                    }

                                                    buttonText == "=" -> {
                                                        if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                                                            workingTxtView.text =
                                                                "$firstNumber$currentOperator$currentNumber"
                                                            result = evaluateExpression(
                                                                firstNumber,
                                                                currentNumber,
                                                                currentOperator
                                                            )
                                                            firstNumber = result
                                                            resultTxtView.text = result
                                                        }
                                                    }

                                                    buttonText == "." -> {
                                                        if (currentOperator.isEmpty()) {
                                                            if (!firstNumber.contains(".")) {
                                                                if (firstNumber.isEmpty()) firstNumber += "0$buttonText"
                                                                else firstNumber += buttonText
                                                                resultTxtView.text = firstNumber
                                                            }
                                                        } else {
                                                            if (!currentNumber.contains(".")) {
                                                                if (currentNumber.isEmpty()) currentNumber += "0$buttonText"
                                                                else currentNumber += buttonText
                                                                resultTxtView.text = currentNumber
                                                            }
                                                        }
                                                    }

                                                    buttonText == "C" -> {
                                                        currentNumber = ""
                                                        firstNumber = ""
                                                        currentOperator = ""
                                                        //resultTxtView.text = "0"
                                                        workingTxtView.text = ""
                                                    }

                                                    buttonText == "AC" -> {
                                                        currentNumber = ""
                                                        firstNumber = ""
                                                        currentOperator = ""
                                                        resultTxtView.text = "0"
                                                        workingTxtView.text = ""
                                                    }
                                                }
                                            }
                                        }
                                }
                        }
                    }
                }
            }
        }
}