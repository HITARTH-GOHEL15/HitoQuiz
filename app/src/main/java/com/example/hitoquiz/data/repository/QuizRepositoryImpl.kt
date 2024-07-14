package com.example.hitoquiz.data.repository

import com.example.hitoquiz.data.remote.data_trans_object.QuizApi
import com.example.hitoquiz.domain.model.Quiz
import com.example.hitoquiz.domain.repository.QuizRepository

class QuizRepositoryImpl(
   private val quizApi: QuizApi
) : QuizRepository{
    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }
}