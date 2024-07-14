package com.example.hitoquiz.presentation.home.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hitoquiz.navigation.Routes
import com.example.hitoquiz.presentation.EventHomeScreen
import com.example.hitoquiz.presentation.StateHomeScreen
import com.example.hitoquiz.presentation.common.AppDropDownMenu
import com.example.hitoquiz.presentation.common.ButtonBox
import com.example.hitoquiz.util.Constants


@Composable
fun HomeScreen(
    state: StateHomeScreen,
    event: (EventHomeScreen) -> Unit,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
       TopAppBar()
       Spacer(modifier = Modifier.padding(16.dp))


        AppDropDownMenu(constantlist = Constants.numbersAsString, text = state.numberOfQuiz.toString() , menuName = "Number of Questions :" , onValueChange = {event(EventHomeScreen.SetNumberOfQuizzes(it.toInt()))})


        AppDropDownMenu(constantlist = Constants.categories, text = state.category , menuName = "Category :", onValueChange = {event(EventHomeScreen.SetQuizCategory(it))})


        AppDropDownMenu(constantlist = Constants.difficulty, text = state.difficulty , menuName = "Difficulty :", onValueChange = {event(EventHomeScreen.SetQuizDifficulty(it))})




        AppDropDownMenu(constantlist = Constants.type, text = state.type , menuName = "Type :" , onValueChange = {event(EventHomeScreen.SetQuizType(it))})


        Spacer(modifier = Modifier.padding(16.dp))

        ButtonBox {
            navController.navigate(
                route = Routes.QuizScreen.passQuizParameters(state.numberOfQuiz,state.category,state.difficulty,state.type)
            )
        }

    }
}