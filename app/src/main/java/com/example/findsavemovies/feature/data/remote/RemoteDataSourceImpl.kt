package com.example.findsavemovies.feature.data.remote

import com.example.findsavemovies.feature.data.remote.dto.MovieDto
import com.example.findsavemovies.feature.domain.data.remote.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val api: MovieAPI
): RemoteDataSource {

    override suspend fun fetchDataFromApi(title: String): Response<MovieDto> {
        return api.fetchMovie(title = title)
    }
}