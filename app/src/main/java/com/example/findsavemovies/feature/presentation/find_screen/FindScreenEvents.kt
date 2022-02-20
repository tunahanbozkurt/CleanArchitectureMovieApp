package com.example.findsavemovies.feature.presentation.find_screen

sealed class FindScreenEvents{
    data class TitleInput(val title: String):FindScreenEvents()
    object Search: FindScreenEvents()


}
