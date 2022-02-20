package com.example.findsavemovies.feature.presentation.home_screen


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.findsavemovies.feature.navigation.Screen
import com.example.findsavemovies.feature.presentation.find_screen.components.MovieItem


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavController
) {

    val items = viewModel.homeScreenList.value.list

    LazyColumn{
        if (items != null){
            items(items){ item ->
                MovieItem(
                    item = item,

                    onClick = { title ->
                              navController.navigate(Screen.DetailScreen.route + "?title=$title")
                    },
                    onLongClick = { title ->
                        viewModel.handleEvent(HomeScreenEvent.DeleteMovie(title))
                    }
                )


            }
        }

    }
}