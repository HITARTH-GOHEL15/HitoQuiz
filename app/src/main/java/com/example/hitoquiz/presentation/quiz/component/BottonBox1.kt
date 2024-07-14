package com.example.hitoquiz.presentation.quiz.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hitoquiz.ui.theme.Montserrat

@SuppressLint("Range")
@Composable
fun ButtonBox1(
    modifier: Modifier,
    text : String,
    onClick: () -> Unit

    ) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
            .width(120.dp)
            .background(color = MaterialTheme.colorScheme.primary)
            .border(0.5.dp , color = MaterialTheme.colorScheme.primary)
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .height(40.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontFamily = Montserrat,
            fontSize = 15.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun ButtonBoxPreview() {
    ButtonBox1(
        modifier = Modifier,
        text = "Previous",
        onClick = {}
    )
}