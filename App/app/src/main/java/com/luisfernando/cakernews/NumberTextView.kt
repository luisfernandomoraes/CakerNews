package com.luisfernando.cakernews


import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

class NumberTextView(context: Context, number: Int) : TextView(context) {

    var number: Int = 0
        set(number) {
            field = number
            text = number.toString()
        }

    init {
        this.number = number
        setTextColor(Color.BLACK)
        setBackgroundColor(Color.WHITE)
        gravity = Gravity.CENTER
    }

    override fun toString(): String {
        return "NumberTextView: " + this.number
    }
}
