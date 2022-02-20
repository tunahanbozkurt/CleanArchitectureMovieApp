package com.example.findsavemovies.feature.domain.repository

import com.example.findsavemovies.common.Resource
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import com.example.findsavemovies.feature.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun fetchMovie(title: String): Flow<Resource<Movie>>

    suspend fun getCacheMovie(): Movie

    suspend fun saveMovie(movie: SavedMovieEntity)

    fun getSavedMovies(): Flow<List<Movie>>

    suspend fun deleteMovie(title:String)

    suspend fun getSavedMovie(title: String): Movie
}