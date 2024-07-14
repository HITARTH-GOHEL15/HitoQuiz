package com.example.hitoquiz.domain.repository

import com.example.hitoquiz.domain.model.Quiz

interface QuizRepository {

    suspend fun getQuizzes(amount: Int, category: Int, difficulty: String, type: String): List<Quiz>

}