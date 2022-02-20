package com.example.findsavemovies.feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.findsavemovies.feature.data.local.entity.MovieEntity
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity

@Database(entities = [MovieEntity::class,SavedMovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}