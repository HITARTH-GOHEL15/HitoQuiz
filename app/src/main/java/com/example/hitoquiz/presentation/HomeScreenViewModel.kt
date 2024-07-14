package com.example.hitoquiz.presentation

import androidx.lifecycle.ViewModel
import com.example.hitoquiz.domain.usecases.GetQuizzesUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(): ViewModel() {
    private val _homestate = MutableStateFlow(StateHomeScreen())
    val homestate = _homestate

    fun onEvent(event: EventHomeScreen) {
        when(event) {
            is EventHomeScreen.SetQuizCategory -> {
                _homestate.value = homestate.value.copy(
                    category = event.category
                )
            }

            is EventHomeScreen.SetNumberOfQuizzes -> {
                _homestate.value = homestate.value.copy(
                    numberOfQuiz = event.numberOfQuizzes
                )
            }
            is EventHomeScreen.SetQuizDifficulty -> {
                _homestate.value = homestate.value.copy(
                    difficulty = event.difficulty
                )
            }

            is EventHomeScreen.SetQuizType -> {
                _homestate.value = homestate.value.copy(
                    type = event.type
                )
            }
        }
    }
}