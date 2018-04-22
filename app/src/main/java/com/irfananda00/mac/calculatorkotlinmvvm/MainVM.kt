package com.irfananda00.mac.calculatorkotlinmvvm

import android.databinding.BaseObservable
import android.databinding.ObservableField

/**
 * Created by mac on 4/22/18.
 */
class MainVM : BaseObservable() {

    var text = ObservableField<String>("")
    var value = ObservableField<String>()
    private val calculator = Calculator()

    fun type(number: Int){
        if (number == 0) {
            if (text.get() != "")
                text.set(text.get() + number)
        }else if (text.get() == "")
            text.set(number.toString())
        else
            text.set(text.get() + number)
    }

    fun equals(){
        if (calculator.isOperatorExist(text.get()!!)) {
            value.set(calculator.doFormula(text.get()!!).toString())
        }
    }

    fun delete(){
        text.set("")
        value.set("")
    }

    fun divide(){
        equals()
        if (text.get() != "") {
            text.set(text.get() + "÷")
        }
    }

    fun multiply(){
        equals()
        if (text.get() != "") {
            text.set(text.get() + "x")
        }
    }

    fun substract(){
        equals()
        if (text.get() != "") {
            text.set(text.get() + "-")
        }
    }

    fun add(){
        equals()
        if (text.get() != "") {
            text.set(text.get() + "+")
        }
    }

}