package com.example.hitoquiz.presentation.quiz.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hitoquiz.presentation.common.ButtonBox
import com.example.hitoquiz.ui.theme.Montserrat
import com.example.hitoquiz.util.Constants


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    numberOfQuiz : Int,
    quizDifficulty : String,
    quizCategory : String,
    quizType : String,
    event : (EventQuizScreen) -> Unit,
    state : StateQuizScreen,
    navController: NavController

) {

    LaunchedEffect(key1 = Unit) {
        val difficulty =
            when (quizDifficulty) {
                "Medium" -> "medium"
                "Hard" -> "hard"
                else -> "easy"
            }
        val type = when (quizType) {
            "Multiple Choice" -> "multiple"
            else -> "boolean"
        }
        event(
            EventQuizScreen.GetQuizzes(
                numberOfQuiz,
                Constants.categoriesMap[quizCategory]!!,
                difficulty,
                type
            )
        )
    }

    val layoutDirection = LocalLayoutDirection.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = quizCategory,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = Montserrat,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 75.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Questions : $numberOfQuiz",
                style = MaterialTheme.typography.labelLarge,
                fontFamily = Montserrat,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = quizDifficulty,
                style = MaterialTheme.typography.labelLarge,
                fontFamily = Montserrat,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 8.dp, bottom = 9.dp)
            )

        }
        Spacer(modifier = Modifier.padding(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(color = MaterialTheme.colorScheme.primary)

        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Column {
            QuizInterface(qNumber = 1, onButtonClicked = {}, modifier = Modifier)

            Spacer(modifier = Modifier.padding(top = 16.dp))

            Row(
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth(),
            ) {
                ButtonBox1(
                    modifier = Modifier.padding(start = 8.dp, top = 100.dp),
                    text = "Previous",
                    onClick = {}
                )
                Spacer(modifier = Modifier.padding(60.dp))
                ButtonBox1(
                    modifier = Modifier.padding(end = 8.dp, top = 100.dp),
                    text = "Next",
                    onClick = {}
                )
            }



        }
    }
}


