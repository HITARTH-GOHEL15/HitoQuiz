package com.example.hitoquiz.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.hitoquiz.presentation.EventHomeScreen
import com.example.hitoquiz.presentation.StateHomeScreen
import com.example.hitoquiz.ui.theme.Montserrat
import com.example.hitoquiz.util.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropDownMenu(
    menuName: String,
    constantlist: List<String>,
    onValueChange: (String) -> Unit,
    text: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        var isExpanded by remember {
            mutableStateOf(false)
        }


        Text(
            text = menuName,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = Montserrat,
            fontWeight = FontWeight.W200
        )

        Spacer(modifier = Modifier.padding(6.dp))

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = it
            }
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.clip(shape = MaterialTheme.shapes.extraLarge)
            ) {
                constantlist.forEachIndexed {  index: Int, text: String ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = text,
                                fontFamily = Montserrat,
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                        onClick = {
                            onValueChange(constantlist[index])
                            isExpanded = false
                        }
                    )
                }

            }
        }

    }

}

@Preview
@Composable
fun AppDropDownMenuPreview(){
}