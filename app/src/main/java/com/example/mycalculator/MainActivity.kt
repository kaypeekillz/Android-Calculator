package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity: AppCompatActivity() {

//    displayValue: '0',
//    firstOperand: null,
//    waitingForSecondOperand: false,
//    operator: null,

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var displayValue = "0"
//        var firstOperand = null
//        var waitingForSecondOperand = false
//        var operator = null
//        var clear = true

        dotBtn.setOnClickListener {
            solveProblem(".", true)
        }
        zeroBtn.setOnClickListener {
            solveProblem("0", true)
        }
        oneBtn.setOnClickListener {
            solveProblem("1", true)
        }
        twoBtn.setOnClickListener {
            solveProblem("2", true)
        }
        threeBtn.setOnClickListener {
            solveProblem("3", true)
        }
        fourBtn.setOnClickListener {
            solveProblem("4", true)
        }
        fiveBtn.setOnClickListener {
            solveProblem("5", true)
        }
        sixBtn.setOnClickListener {
            solveProblem("6", true)
        }
        sevenBtn.setOnClickListener {
            solveProblem("7", true)
        }
        eightBtn.setOnClickListener {
            solveProblem("8", true)
        }
        nineBtn.setOnClickListener {
            solveProblem("9", true)
        }

        additionBtn.setOnClickListener {
            solveProblem("+", false)
        }
        minusBtn.setOnClickListener {
            solveProblem("-", false)
        }
        multiplyBtn.setOnClickListener {
            solveProblem("*", false)
        }
        divideBtn.setOnClickListener {
            solveProblem("/", false)
        }
//        plusOrMinusBtn.setOnClickListener {
//            solveProblem("+/-", false)
//        }
        percentBtn.setOnClickListener {
            solveProblem("/ 100", false)
        }

        clearBtn.setOnClickListener {
            screenOne.text = ""
            screenTwo.text = ""
        }

        backBtn.setOnClickListener {
            val string = screenOne.text.toString()
            if (string.isNotEmpty()) {
                screenOne.text = string.substring(0, string.length - 1)
            }
            screenTwo.text = ""
        }
        
//        fun updateDisplay() {
//            var display = screenOne
//            var answerDisplay = screenTwo
//            display.setText(displayValue)
//            answerDisplay.setText(displayValue)
//        }

        equalToBtn.setOnClickListener {
            try {
                val expression = ExpressionBuilder(screenOne.text.toString()).build()
//                if (screenOne.text.contains("%", false)) {
//                    screenOne.text.replace("%".toRegex(), "/ 100")
//                }
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    screenTwo.text = longResult.toString()
                } else {
                    screenTwo.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

        fun solveProblem(string: String, canClear: Boolean) {

            if (screenTwo.text.isNotEmpty()) {
                screenOne.text = ""
            }
            if (canClear) {
                screenTwo.text = ""
                screenOne.append(string)
            } else {
                screenOne.append(screenTwo.text)
                screenOne.append(string)
                screenTwo.text = ""
            }
        }

//        updateDisplay()
//    }
}
