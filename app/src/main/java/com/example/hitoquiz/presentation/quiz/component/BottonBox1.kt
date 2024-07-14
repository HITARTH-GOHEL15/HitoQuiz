package com.example.hitoquiz.presentation.quiz.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonBox1(
    modifier: Modifier = Modifier,
    text : String,
    padding : Dp = 8.dp,
    backgroundColor : Color = MaterialTheme.colorScheme.primary,
    textColor : Color = Color.Black,
    fraction : Float = 1f,
    onClick: () -> Unit

    ) {
    Box(
        modifier = modifier
            .padding(padding)
            .clickable { onClick() }
            .fillMaxWidth(fraction)
            .background(backgroundColor)
            .height(40.dp)
            .clip(shape = MaterialTheme.shapes.medium)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 15.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}