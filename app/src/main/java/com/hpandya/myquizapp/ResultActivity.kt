package com.hpandya.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.CorrectionInfo
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tvUsername:TextView
    private lateinit var tvScore:TextView
    private lateinit var btnFinish:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvUsername= findViewById(R.id.tv_name)
        tvScore= findViewById(R.id.tv_score)
        btnFinish= findViewById(R.id.btn_Finish)

        tvUsername.text = intent.getStringExtra(Constants.USER_NAME)
        val mTotalQuestions= intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val mCorrectAnswers= intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        tvScore.text = "Your Score $mCorrectAnswers out of $mTotalQuestions"
        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}