package com.example.findsavemovies.feature.domain.usecase

data class UseCases(
    val search: Search,
    val cacheMovie: GetCacheMovie,
    val saveMovie: SaveMovie,
    val getSavedMovies: GetSavedMovies,
    val deleteMovie: DeleteMovie,
    val getSavedMovie: GetSavedMovie
)
