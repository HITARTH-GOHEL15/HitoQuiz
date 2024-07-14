package com.example.hitoquiz.presentation.quiz.component

import com.example.hitoquiz.domain.model.Quiz

data class StateQuizScreen(
    val isLoading: Boolean = false,
    val data: List<Quiz> = emptyList(),
    val error: String = ""

)