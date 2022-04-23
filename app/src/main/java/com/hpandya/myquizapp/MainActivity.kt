package com.hpandya.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn_start: Button
    private lateinit var et_name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btnStart)
        et_name = findViewById(R.id.etName)

        btn_start.setOnClickListener {

            if (et_name.text.isEmpty()) {
                et_name.error = "Please Enter your name"
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text)
                startActivity(intent)
                finish()
            }
        }
    }
}
