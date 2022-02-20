package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.feature.domain.repository.MovieRepository

class DeleteMovie(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(title: String){
        repository.deleteMovie(title = title)
    }
}