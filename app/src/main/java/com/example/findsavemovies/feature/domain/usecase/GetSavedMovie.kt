package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.repository.MovieRepository

class GetSavedMovie(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(title: String): Movie{
        return repository.getSavedMovie(title = title)
    }
}