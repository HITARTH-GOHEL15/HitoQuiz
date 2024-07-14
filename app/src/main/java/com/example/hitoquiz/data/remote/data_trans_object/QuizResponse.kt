package com.example.hitoquiz.data.remote.data_trans_object

import com.example.hitoquiz.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)