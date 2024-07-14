package com.example.hitoquiz.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hitoquiz.ui.theme.Montserrat


@Composable
fun ButtonBox(
    onButtonClick: () -> Unit
) {

    OutlinedButton(
        onClick = onButtonClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(16.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Text(
            text = "Generate Quiz",
            style = MaterialTheme.typography.displayLarge,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = Montserrat,
        )
    }
}