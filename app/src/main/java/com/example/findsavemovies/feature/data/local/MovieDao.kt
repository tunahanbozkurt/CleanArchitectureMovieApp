package com.example.findsavemovies.feature.data.local

import androidx.room.*
import com.example.findsavemovies.feature.data.local.entity.MovieEntity
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    //NON-PERMANENT
    @Query("SELECT * FROM movies")
    suspend fun getCacheMovie(): MovieEntity

    @Query("DELETE FROM movies")
    suspend fun deleteAllCache()

    @Insert
    suspend fun insertCacheMovie(movie: MovieEntity)

    //PERMANENT
    @Query("SELECT * FROM savedMovies")
    fun getAllSavedMovies(): Flow<List<SavedMovieEntity>>

    @Query("DELETE FROM savedMovies WHERE uid = :title")
    suspend fun deleteSavedMovie(title: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedMovie(movie: SavedMovieEntity)

    @Query("SELECT * FROM savedMovies WHERE uid = :title")
    suspend fun getSavedMovie(title: String): SavedMovieEntity






}