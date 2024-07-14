package com.example.hitoquiz.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hitoquiz.presentation.HomeScreenViewModel
import com.example.hitoquiz.presentation.home.component.HomeScreen
import com.example.hitoquiz.presentation.quiz.component.QuizScreen
import com.example.hitoquiz.presentation.quiz.component.QuizViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {

        composable(route = Routes.HomeScreen.route){
            val viewModel : HomeScreenViewModel = hiltViewModel()
            val state by viewModel.homestate.collectAsState()
            HomeScreen(
                state = state ,
                event = viewModel::onEvent,
                navController = navController
            )
        }

        composable(
            route = Routes.QuizScreen.route,
            arguments = listOf(
                navArgument(ARG_KEY_QUIZ_NUMBER){type = NavType.IntType},
                navArgument(ARG_KEY_QUIZ_CATEGORY){type = NavType.StringType},
                navArgument(ARG_KEY_QUIZ_DIFFICULTY){type = NavType.StringType},
                navArgument(ARG_KEY_QUIZ_TYPE){type = NavType.StringType}
            )
        ) {
            val numOfQuizzes = it.arguments?.getInt(ARG_KEY_QUIZ_NUMBER)
            val category = it.arguments?.getString(ARG_KEY_QUIZ_CATEGORY)
            val difficulty = it.arguments?.getString(ARG_KEY_QUIZ_DIFFICULTY)
            val type = it.arguments?.getString(ARG_KEY_QUIZ_TYPE)


            val quizviewModel : QuizViewModel = hiltViewModel()
            val state by quizviewModel.quizList.collectAsState()
           QuizScreen(
               numberOfQuiz = numOfQuizzes!!,
               quizDifficulty = difficulty!!,
               quizCategory = category!! ,
               quizType = type!!,
               event = quizviewModel::onEvent,
               state = state,
               navController
           )




        }
    }
}