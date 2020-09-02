package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun makeColored(view: View) {
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)

            R.id.button_yellow -> box_three_text.setBackgroundResource(R.color.my_yellow)
            R.id.button_red -> box_four_text.setBackgroundResource(R.color.my_red)
            R.id.button_black -> box_five_text.setBackgroundResource(R.color.my_black)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val boxOne = findViewById<TextView>(R.id.box_one_text)
        val boxTwo = findViewById<TextView>(R.id.box_two_text)
        val boxThree = findViewById<TextView>(R.id.box_three_text)
        val boxFour = findViewById<TextView>(R.id.box_four_text)
        val boxFive = findViewById<TextView>(R.id.box_five_text)
        val constraintView = findViewById<View>(R.id.constraint_layout)
        val yellowButton = findViewById<Button>(R.id.button_yellow)
        val redButton = findViewById<Button>(R.id.button_red)
        val blackButton = findViewById<Button>(R.id.button_black)

        val allViews: List<View> = listOf(boxOne, boxTwo, boxThree, boxFour, boxFive,
                                            constraintView, yellowButton, redButton, blackButton)
        for(item in allViews) {
            item.setOnClickListener {makeColored(it)}
        }
    }
}