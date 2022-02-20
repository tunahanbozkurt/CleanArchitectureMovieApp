package com.example.findsavemovies.feature.domain.data.remote

import com.example.findsavemovies.feature.data.remote.dto.MovieDto
import retrofit2.Response

interface RemoteDataSource {

    suspend fun fetchDataFromApi(title: String): Response<MovieDto>

}