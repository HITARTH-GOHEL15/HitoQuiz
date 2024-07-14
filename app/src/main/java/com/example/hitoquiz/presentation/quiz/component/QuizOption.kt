package com.example.hitoquiz.presentation.quiz.component

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.DefaultMarqueeDelayMillis
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hitoquiz.R
import com.example.hitoquiz.ui.theme.Montserrat

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuizOption(
    optionNumber: String,
    options: String,
    selected: Boolean,
    onOptionClick : () -> Unit,
    onUnselectOption :  (Int) -> Unit
) {

    val optionTextColor =
        if (selected){
            Color.Black
        }
        else {
            Color.Black
    }
    val transition = updateTransition(targetState = selected , label = "selected")

    val startColor by transition.animateColor(
        transitionSpec = {
            tween(durationMillis = DefaultMarqueeDelayMillis , easing = LinearEasing )
        }, label = "startColor"
    ) { selectedBox ->
        if(selectedBox) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.primary
        }

    }


    Box(
        modifier = Modifier
            .clickable {
                onOptionClick()
            }
            .fillMaxWidth()
            .height(75.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(
                color = startColor
            )
            .border(2.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
           if (!selected) {
               Box(
                   modifier = Modifier
                       .size(120.dp)
                       .weight(1.5f)
                       .shadow(10.dp, shape = MaterialTheme.shapes.medium)
                       .background(color = MaterialTheme.colorScheme.primary)
                       .border(2.dp , color = MaterialTheme.colorScheme.primary , shape = MaterialTheme.shapes.medium),
                   contentAlignment = Alignment.Center
               ) {
                   Text(
                       text = optionNumber,
                       fontFamily = Montserrat,
                       fontSize = 20.sp,
                       color = Color.Black,
                       textAlign = TextAlign.Center
                   )
               }
           } else {
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .clip(shape = MaterialTheme.shapes.medium)
                       .size(120.dp)
               )
           }

            Spacer(
                modifier = Modifier
                    .weight(0.6f)
                    .width(120.dp)
            )

            Text(
                text = options,
                fontFamily = Montserrat,
                fontSize = 12.sp,
                color = optionTextColor,
                maxLines = 3,
                modifier = Modifier.weight(7.1f)
            )
            if (selected) {
                Box(
                    modifier = Modifier
                        .weight(1.5f)
                        .shadow(10.dp, shape = MaterialTheme.shapes.medium)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .size(100.dp)
                        .background(color = MaterialTheme.colorScheme.primary)
                        .padding(4.dp),
                ) {
                    IconButton(onClick = {onUnselectOption(1)}) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "close" ,
                            tint = Color.Black,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(start = 4.dp , end = 4.dp)
                        )

                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .weight(1.5f)
                        .clip(shape = MaterialTheme.shapes.medium)
                        .size(120.dp)
                )
            }
        }
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.clickable(onClick: () -> Unit): Modifier = composed {
    this.clickable {

    }

}


@Preview
@Composable
fun QuizOptionPreview() {
    QuizOption(
        optionNumber = "A",
        options = "hii my name is hitarth gohel,hii my name is hitarth gohel ",
        selected = false,
        onOptionClick = {},
        onUnselectOption = {}
    )
}




