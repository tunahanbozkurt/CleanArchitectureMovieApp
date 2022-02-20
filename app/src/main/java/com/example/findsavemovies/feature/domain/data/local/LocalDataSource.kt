package com.example.findsavemovies.feature.domain.data.local

import com.example.findsavemovies.feature.data.local.entity.MovieEntity
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import com.example.findsavemovies.feature.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    //NON-PERMANENT
    suspend fun getLocalCacheData(): MovieEntity

    suspend fun addCacheMovie(entity: MovieEntity)

    suspend fun deleteAllCache()


    //PERMANENT
    suspend fun saveMovie(movie: SavedMovieEntity)

    fun getAllSavedMovies(): Flow<List<SavedMovieEntity>>

    suspend fun deleteMovie(title: String)

    suspend fun getSavedMovie(title: String): Movie



}
