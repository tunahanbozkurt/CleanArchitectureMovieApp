package com.example.findsavemovies.feature.presentation.home_screen

sealed class HomeScreenEvent{
    data class DeleteMovie(val title: String):HomeScreenEvent()
}
