package com.example.findsavemovies.feature.presentation.home_screen

import com.example.findsavemovies.feature.domain.model.Movie

data class HomeScreenListState(
    val list: List<Movie>? = null
)
