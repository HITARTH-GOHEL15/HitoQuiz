package com.example.hitoquiz.navigation

import com.example.hitoquiz.presentation.EventHomeScreen

const val ARG_KEY_QUIZ_NUMBER = "arg_quiz_number"
const val ARG_KEY_QUIZ_CATEGORY = "arg_quiz_category"
const val ARG_KEY_QUIZ_DIFFICULTY = "arg_quiz_difficulty"
const val ARG_KEY_QUIZ_TYPE = "arg_quiz_type"
sealed class Routes(val route : String) {

    object HomeScreen : Routes(route = "home_screen")
    object QuizScreen : Routes(route = "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"){

        fun passQuizParameters(numOfQuizzes: Int, category: String, difficulty : String , type: String) : String{

            return "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"
                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_NUMBER}",
                    newValue = numOfQuizzes.toString()
                )

                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_CATEGORY}",
                    newValue = category.toString()
                )

                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_DIFFICULTY}",
                    newValue = difficulty.toString()
                )

                .replace(
                    oldValue = "{$ARG_KEY_QUIZ_TYPE}",
                    newValue = type.toString()
                )
        }
    }

    object ScoreScreen : Routes(route = "score_screen")
}

