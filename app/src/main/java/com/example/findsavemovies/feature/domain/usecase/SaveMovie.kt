package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import com.example.findsavemovies.feature.domain.repository.MovieRepository

class SaveMovie(private val repository: MovieRepository) {

    suspend operator fun invoke(movie: SavedMovieEntity){
        repository.saveMovie(movie = movie)
    }
}