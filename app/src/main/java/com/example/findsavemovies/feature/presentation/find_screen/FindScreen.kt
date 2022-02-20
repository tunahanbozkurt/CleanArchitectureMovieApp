package com.example.findsavemovies.feature.presentation.find_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.findsavemovies.feature.navigation.Screen
import com.example.findsavemovies.feature.presentation.find_screen.components.MovieItem
import com.example.findsavemovies.feature.presentation.find_screen.components.TopBar


@Composable
fun FindScreen(
    navController: NavController,
    viewModel: FindScreenViewModel = hiltViewModel()
) {

    Scaffold(topBar = {
        TopBar(
            text = viewModel.searchBarState.value.text,
            onValueChange = {viewModel.uiEvents(FindScreenEvents.TitleInput(it))},
            searchButton = { viewModel.uiEvents(FindScreenEvents.Search) }
        )
    }) {

        MovieItem(
            item = viewModel.listState.value.item,
            isLoading = viewModel.listState.value.isLoading,
            onLongClick = {

            },
            onClick = {
                navController.navigate(Screen.DetailScreen.route)
            }
        )


    }
}