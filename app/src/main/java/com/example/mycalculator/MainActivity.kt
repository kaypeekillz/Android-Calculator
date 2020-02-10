package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

//        fun checkLastValue() {
//            val screenValue = screenOne.getText().toString()
//            if (screenValue.endsWith("+")){
//                solveProblem("", false)
//            }
//        }

//        val screenValue = screenOne.getText().toString()
        additionBtn.setOnClickListener {
            val screenValue = screenOne.getText().toString()
//            checkLastValue()
//            val lastValue = screenValue.substring(0, screenValue.length)
//            var lastValue = screenValue.toCharArray(0,screenValue.length -1)
            if (screenOne.getText().toString().length == 0 || screenValue.endsWith("+") || screenValue.endsWith("-")
                || screenValue.endsWith("/") || screenValue.endsWith("*")) {
                solveProblem("", false)
            } else {
                solveProblem("+", false)
            }
        }
        minusBtn.setOnClickListener {
            val screenValue = screenOne.getText().toString()
            if (screenOne.getText().toString().length == 0 || screenValue.endsWith("+") || screenValue.endsWith("-")
                || screenValue.endsWith("/") || screenValue.endsWith("*")) {
                solveProblem("", false)
            } else {
                solveProblem("-", false)
            }
        }
        multiplyBtn.setOnClickListener {
            val screenValue = screenOne.getText().toString()
            if (screenOne.getText().toString().length == 0 || screenValue.endsWith("+") || screenValue.endsWith("-")
                || screenValue.endsWith("/") || screenValue.endsWith("*")) {
                solveProblem("", false)
            } else {
                solveProblem("*", false)
            }
        }
        divideBtn.setOnClickListener {
            val screenValue = screenOne.getText().toString()
            if (screenOne.getText().toString().length == 0 || screenValue.endsWith("+") || screenValue.endsWith("-")
                || screenValue.endsWith("/") || screenValue.endsWith("*")) {
                solveProblem("", false)
            } else {
                solveProblem("/", false)
            }
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

//         if (screenOne.length() == 0) {
//        if (screenOne.getText().toString().length == 0) {
//            minusBtn.isEnabled = false
//            lastValue.isDigitsOnly()
//            screenOne.text = screenValue.substring(0, screenValue.length - 1)
//        }

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
}
