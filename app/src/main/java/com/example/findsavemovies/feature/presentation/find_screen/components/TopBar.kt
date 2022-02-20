package com.example.findsavemovies.feature.presentation.find_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.findsavemovies.R

@Composable
fun TopBar(
    text: String,
    onValueChange: (String) -> Unit,
    searchButton: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        TextField(
            value = text,
            onValueChange = {onValueChange(it)},
            modifier = Modifier
                .weight(12f)
                .fillMaxHeight()
                .shadow(2.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        
        )
        Image(painter = painterResource(id = R.drawable.ic_baseline_search_24),
            contentDescription = "Search",
            modifier = Modifier.weight(2f)
                .clickable { searchButton() }

        )
    }

}


