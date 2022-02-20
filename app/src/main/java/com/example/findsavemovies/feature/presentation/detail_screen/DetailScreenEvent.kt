package com.example.findsavemovies.feature.presentation.detail_screen

import com.example.findsavemovies.feature.domain.model.Movie


sealed class DetailScreenEvent{
    data class SaveMovie(val movie: Movie): DetailScreenEvent()
    data class LoadData(val title:String?): DetailScreenEvent()
}
