package com.example.hitoquiz.presentation.quiz.component

sealed class EventQuizScreen {

    data class GetQuizzes(
        val numofQuestions: Int,
        val category: Int,
        val difficulty: String,
        val type: String
    ) : EventQuizScreen()
}