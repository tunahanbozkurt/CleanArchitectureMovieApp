package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.repository.MovieRepository

class GetCacheMovie(
   private val repository: MovieRepository
) {

    suspend operator fun invoke(): Movie {
        return repository.getCacheMovie()
    }
}