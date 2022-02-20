package com.example.findsavemovies.feature.data.local

import com.example.findsavemovies.feature.data.local.entity.MovieEntity
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import com.example.findsavemovies.feature.domain.data.local.LocalDataSource
import com.example.findsavemovies.feature.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val dao: MovieDao
): LocalDataSource {

    override suspend fun getLocalCacheData(): MovieEntity {
      return dao.getCacheMovie()
    }

    override suspend fun addCacheMovie(entity: MovieEntity) {
         dao.insertCacheMovie(entity)
    }

    override suspend fun deleteMovie(title: String) {
         dao.deleteSavedMovie(title)

    }

    override suspend fun deleteAllCache() {
        dao.deleteAllCache()
    }

    override suspend fun saveMovie(movie: SavedMovieEntity) {
        dao.insertSavedMovie(movie = movie)
    }

    override fun getAllSavedMovies(): Flow<List<SavedMovieEntity>> {
        return dao.getAllSavedMovies()
    }

    override suspend fun getSavedMovie(title: String): Movie {
       return dao.getSavedMovie(title = title).toMovie()
    }


}