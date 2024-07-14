package com.example.hitoquiz.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hitoquiz.R
import com.example.hitoquiz.ui.theme.Montserrat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 35.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        modifier = modifier
            .statusBarsPadding()
            .background(color = Color.Black)
    )
}