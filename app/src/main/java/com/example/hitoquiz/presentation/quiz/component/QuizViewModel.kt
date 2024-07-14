package com.example.hitoquiz.presentation.quiz.component

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hitoquiz.common.Resource
import com.example.hitoquiz.domain.usecases.GetQuizzesUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val getQuizzesUsecases: GetQuizzesUsecases): ViewModel() {


  private  val _quizList = MutableStateFlow(StateQuizScreen())
    val quizList: StateFlow<StateQuizScreen> = _quizList


    fun onEvent(event: EventQuizScreen) {
        when(event){
            is EventQuizScreen.GetQuizzes -> {
                getQuizzes(event.numofQuestions, event.category, event.difficulty, event.type)

            }

            else -> {}

        }
    }

    private fun getQuizzes(amount: Int, category: Int, difficulty: String, type: String) {
        viewModelScope.launch {
            getQuizzesUsecases(amount, category, difficulty, type).collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        _quizList.value = StateQuizScreen(error = resource.message.toString())
                    }
                    is Resource.Loading -> {
                        _quizList.value = StateQuizScreen(isLoading = true)
                    }
                    is Resource.Success -> {
                        for(quiz in resource.data) {
                            Log.d("quiz" , quiz.toString())
                        }
                        _quizList.value = StateQuizScreen(data = resource.data)
                    }
                    else -> {

                    }
                }
            }
        }
    }
}