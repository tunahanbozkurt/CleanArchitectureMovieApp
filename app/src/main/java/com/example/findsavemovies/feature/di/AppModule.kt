package com.example.findsavemovies.feature.di

import android.content.Context
import androidx.room.Room
import com.example.findsavemovies.common.Constants.BASE_URL
import com.example.findsavemovies.feature.data.local.AppDatabase
import com.example.findsavemovies.feature.domain.data.local.LocalDataSource
import com.example.findsavemovies.feature.data.local.LocalDataSourceImpl
import com.example.findsavemovies.feature.data.remote.*
import com.example.findsavemovies.feature.data.repository.MovieRepositoryImpl
import com.example.findsavemovies.feature.domain.data.remote.RemoteDataSource
import com.example.findsavemovies.feature.domain.repository.MovieRepository
import com.example.findsavemovies.feature.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPI(): MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,"movie-database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: MovieAPI): RemoteDataSource {
        return RemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(db: AppDatabase): LocalDataSource {
        return LocalDataSourceImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: MovieRepository, connectivityController: ConnectivityController): UseCases{
        return UseCases(
            search = Search(repository, connectivityController),
            cacheMovie = GetCacheMovie(repository),
            saveMovie = SaveMovie(repository),
            getSavedMovies = GetSavedMovies(repository),
            deleteMovie = DeleteMovie(repository),
            getSavedMovie = GetSavedMovie(repository)
        )
    }

    @Provides
    @Singleton
    fun networkConnectivity(@ApplicationContext context: Context): ConnectivityController{
        return ConnectivityController(context)
    }


}