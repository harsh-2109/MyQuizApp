package com.hpandya.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: Button

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_flag_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        defaultOptionView()

        // Setting onClickListener
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar.progress = mCurrentPosition
        ivImage.setImageResource(question.image)
        tvProgress.text = "$mCurrentPosition/${progressBar.max}"
        tvQuestion.text = resources.getText(question.questions)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) btnSubmit.text =
            "Finish" else btnSubmit.text = "Submit"
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        tvOptionOne.let {
            options.add(0, it)
        }
        tvOptionTwo.let {
            options.add(1, it)
        }
        tvOptionThree.let {
            options.add(2, it)
        }
        tvOptionFour.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
//            option.setTextColor(Color.parseColor("#ff0000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(view: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum

        view.setTextColor(Color.parseColor("#363a43"))
        view.typeface = Typeface.DEFAULT_BOLD
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tvOptionFour, 4)
            }
            R.id.btn_submit -> {
                // TODO "Implement button submit"
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    answerView(mSelectedOptionPosition, R.drawable.correct_option_border_bg)
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
}
