package com.hpandya.myquizapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Question(
    val id: Int,
    @StringRes
    val questions: Int,
    @DrawableRes
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
