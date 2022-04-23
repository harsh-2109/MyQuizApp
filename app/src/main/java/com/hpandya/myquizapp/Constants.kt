package com.hpandya.myquizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWER:String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        questionsList.add(
            Question(
                1, R.string.que1,
                R.drawable.ic_flag_of_argentina,
                "Argentina", "Australia",
                "Armenia", "Austria", 1
            )
        )

        // 2
        questionsList.add(
            Question(
                2, R.string.que1,
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
            )
        )

        // 3
        questionsList.add(
            Question(
                3, R.string.que1,
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4
            )
        )

        // 4
        questionsList.add(
            Question(
                4, R.string.que1,
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2
            )
        )

        // 5
        questionsList.add(
            Question(
                5, R.string.que1,
                R.drawable.ic_flag_of_fiji,
                "Gabon", "France",
                "Fiji", "Finland", 3
            )
        )

        // 6
        questionsList.add(
            Question(
                6, R.string.que1,
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1
            )
        )

        // 7
        questionsList.add(
            Question(
                7, R.string.que1,
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3
            )
        )

        // 8
        questionsList.add(
            Question(
                8, R.string.que1,
                R.drawable.ic_flag_of_india,
                "Ireland", "Iran",
                "Hungary", "India", 4
            )
        )

        // 9
        questionsList.add(
            Question(
                9, R.string.que1,
                R.drawable.ic_flag_of_new_zealand,
                "Australia", "New Zealand",
                "Tuvalu", "United States of America", 2
            )
        )

        // 10
        questionsList.add(
            Question(
                10, R.string.que1,
                R.drawable.ic_flag_of_kuwait,
                "Kuwait", "Jordan",
                "Sudan", "Palestine", 1
            )
        )

        return questionsList
    }
}
