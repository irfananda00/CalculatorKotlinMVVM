package com.irfananda00.mac.calculatorkotlinmvvm

import android.util.Log

/**
 * Created by mac on 4/22/18.
 */
class Calculator {

    fun isOperatorExist(formula: String): Boolean{
        for (char in formula){
            if (char == '÷' || char == 'x' || char == '-' || char == '+') {
                return true
            }
        }
        return false
    }

    fun doFormula(formula: String): Int{
        var num1 = 0
        var num2 = 0
        var value = 0
        var numTemp = ""
        var currentOperator = ""
        for (char in formula){
            if (Character.isDigit(char))
                numTemp += char
            else {
                if (num1 == 0)
                    num1 = Integer.valueOf(numTemp)!!
                else
                    num2 = Integer.valueOf(numTemp)!!
                numTemp = ""
                if (currentOperator != "") {
                    when (currentOperator) {
                        "÷" -> value = divide(num1, num2)
                        "x" -> value = multiply(num1, num2)
                        "-" -> value = substract(num1, num2)
                        "+" -> value = add(num1, num2)
                    }
                    num1 = value
                    num2 = 0
                    numTemp = ""
                    currentOperator = ""
                }
                currentOperator = char.toString()
            }
        }
        if (num1 == 0)
            num1 = Integer.valueOf(numTemp)!!
        else
            num2 = Integer.valueOf(numTemp)!!
        if (currentOperator != "") {
            when (currentOperator) {
                "÷" -> value = divide(num1, num2)
                "x" -> value = multiply(num1, num2)
                "-" -> value = substract(num1, num2)
                "+" -> value = add(num1, num2)
            }
        }
        return value
    }

    fun divide(num1: Int, num2: Int): Int {
        return num1 / num2
    }

    fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }

    fun substract(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

}