package com.example.findsavemovies.feature.data.remote

import com.example.findsavemovies.common.Constants.API_KEY
import com.example.findsavemovies.feature.data.remote.dto.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface MovieAPI {

    @GET
    suspend fun fetchMovie(
        @Url url:String = "",
        @Query("t") title:String,
        @Query("plot") plot:String = "full",
        @Query("apikey") apikey:String = API_KEY
    ): Response<MovieDto>




}