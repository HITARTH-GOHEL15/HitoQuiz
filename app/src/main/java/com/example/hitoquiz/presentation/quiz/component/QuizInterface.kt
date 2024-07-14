package com.example.hitoquiz.presentation.quiz.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hitoquiz.ui.theme.Montserrat


@Composable
fun QuizInterface(
    qNumber: Int,
    onButtonClicked: (Int) -> Unit,
    modifier: Modifier
) {


    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(top = 146.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$qNumber.",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineLarge,
                    fontFamily = Montserrat,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "questions",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineLarge,
                    fontFamily = Montserrat,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                    )
            }

            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                val options = listOf(
                    "A" to "Answer 1",
                    "B" to "Answer 2",
                    "C" to "Answer 3",
                    "D" to "Answer 4",
                )

                Column {
                    options.forEachIndexed { index , (optionNumber , optionText) ->
                        if (optionText.isNotEmpty()) {
                            QuizOption(
                                optionNumber = optionNumber ,
                                options = optionText,
                                selected = false,
                                onOptionClick = { onButtonClicked(index)},
                                onUnselectOption = { onButtonClicked(-1) }
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun QuizInterfacePreview() {
    QuizInterface(
        qNumber = 1,
        onButtonClicked = {},
        modifier = Modifier
    )
}


