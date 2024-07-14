package com.example.hitoquiz.domain.usecases

import com.example.hitoquiz.common.Resource
import com.example.hitoquiz.domain.model.Quiz
import com.example.hitoquiz.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetQuizzesUsecases(
    val quizRepository: QuizRepository
) {


    operator fun invoke(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ) : Flow<Resource<List<Quiz>>> = flow {

        emit(Resource.Loading())

        try {
            emit(Resource.Success(data = quizRepository.getQuizzes(amount, category, difficulty, type)))
        }

        catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }

    }.flowOn(Dispatchers.IO)
}