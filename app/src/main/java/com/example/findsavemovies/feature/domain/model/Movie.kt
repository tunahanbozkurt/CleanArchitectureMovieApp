package com.example.findsavemovies.feature.domain.model

import com.example.findsavemovies.feature.data.local.entity.SavedMovieEntity


data class Movie(
    val title:String?,
    val year:String?,
    val runtime:String?,
    val genre:String?,
    val director:String?,
    val writer:String?,
    val actors:String?,
    val plot:String?,
    val language:String?,
    val country:String?,
    val poster:String?,
    val imdbRating:String?,
    val boxOffice:String?
){

    fun toSavedMovieEntity(): SavedMovieEntity{
        return SavedMovieEntity(
            title= title ?: "N/A",
            year = year ?: "N/A",
            runtime = runtime ?: "N/A",
            genre = genre ?: "N/A",
            director = director ?: "N/A",
            writer = writer ?: "N/A",
            actors = actors ?: "N/A",
            plot = plot ?: "N/A",
            language = language ?: "N/A",
            country = country ?: "N/A",
            poster = poster ?: "N/A",
            imdbRating = imdbRating ?: "N/A",
            boxOffice = boxOffice ?: "N/A"
        )
    }


}
