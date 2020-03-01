package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //handling the multiply button press
        multiplyButton.setOnClickListener {
            if (!areFieldsEmpty()) {
                resultTextView.text =
                    (firstNumberEditText.text.toString().toFloat() * secondNumberEditText.text.toString().toFloat()).toString()
            }
        }

        //handling the divide button press
        divideButton.setOnClickListener {
            if (!areFieldsEmpty()) {
                //проверка - не является ли второе число нулем
                if (secondNumberEditText.text.toString() == "0")
                    Toast.makeText(this, "Second number cannot be 0", Toast.LENGTH_SHORT).show()
                else
                    resultTextView.text =
                        (firstNumberEditText.text.toString().toFloat() / secondNumberEditText.text.toString().toFloat()).toString()
            }
        }

    }

    //check if fields are empty
    private fun areFieldsEmpty(): Boolean {
        if (firstNumberEditText.text.toString().isEmpty() || secondNumberEditText.text.toString().isEmpty()) {
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    //handling the plus button press
    fun addNumbers(view: View) {
        if (!areFieldsEmpty()) {
            resultTextView.text =
                (firstNumberEditText.text.toString().toFloat() + secondNumberEditText.text.toString().toFloat()).toString()
        }
    }

    //handling the minus button press
    fun subtractNumbers(view: View) {
        if (!areFieldsEmpty()) {
            resultTextView.text =
                (firstNumberEditText.text.toString().toFloat() - secondNumberEditText.text.toString().toFloat()).toString()
        }
    }
}
