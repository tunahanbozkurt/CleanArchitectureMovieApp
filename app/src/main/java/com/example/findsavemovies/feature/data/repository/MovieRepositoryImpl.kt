package com.example.findsavemovies.feature.data.repository

import com.example.findsavemovies.common.Resource
import com.example.findsavemovies.feature.domain.data.local.LocalDataSource
import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity
import com.example.findsavemovies.feature.domain.data.remote.RemoteDataSource
import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
): MovieRepository {

    override fun fetchMovie(title: String): Flow<Resource<Movie>> {
       return flow {
           emit(Resource.Loading())
           val response = remoteDataSource.fetchDataFromApi(title = title)
           if (response.isSuccessful){

               val dto = response.body()

               if (dto?.Title != null){

                   val entity = dto.toMovieEntity()

                   localDataSource.deleteAllCache()

                   localDataSource.addCacheMovie(entity)

                   val cacheData = localDataSource.getLocalCacheData()
                   emit(Resource.Success(cacheData.toMovie()))
               }
               else{
                   emit(Resource.Error(message = "Null Data"))
               }
           }
           else{
               println("error")
               emit(Resource.Error(response.errorBody().toString()))
           }
       }
    }

    override suspend fun getCacheMovie(): Movie {
        return localDataSource.getLocalCacheData().toMovie()
    }

    override suspend fun saveMovie(movie: SavedMovieEntity) {
        localDataSource.saveMovie(movie)
    }

    override fun getSavedMovies(): Flow<List<Movie>> {
       return localDataSource.getAllSavedMovies().map {
          it.map { entity ->
              entity.toMovie()
          }
       }
    }

    override suspend fun deleteMovie(title: String) {
        localDataSource.deleteMovie(title)
    }

    override suspend fun getSavedMovie(title: String): Movie {
        return localDataSource.getSavedMovie(title = title)
    }
}