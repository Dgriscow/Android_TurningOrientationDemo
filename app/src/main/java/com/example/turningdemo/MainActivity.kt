package com.example.turningdemo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textBox:TextView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById<Button>(R.id.button)

        textBox = findViewById<TextView>(R.id.textView)
        //Check if phone is landscape or not
        btn.setOnClickListener {

            if (btn.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                //Phone is PORTRAIT, preform PORTRAIT OPERATIONS
                textBox.text = "Phone is Portrait!"
            }else{
                //phone is LANDSCAPE, preform LANDSCAPE operations
                textBox.text = "Phone is Landscape!"

            }

        }

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_txt", textBox.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textBox.setText(savedInstanceState.getString("saved_txt"))
    }



}