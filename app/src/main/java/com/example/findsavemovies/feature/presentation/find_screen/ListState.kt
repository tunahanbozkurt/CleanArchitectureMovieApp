package com.example.findsavemovies.feature.presentation.find_screen

import com.example.findsavemovies.feature.domain.model.Movie

data class ListState(
    val item: Movie? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
