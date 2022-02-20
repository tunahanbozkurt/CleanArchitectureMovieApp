package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetSavedMovies(
    private val repository: MovieRepository
) {

    operator fun invoke(): Flow<List<Movie>> {
        return repository.getSavedMovies()
    }

}