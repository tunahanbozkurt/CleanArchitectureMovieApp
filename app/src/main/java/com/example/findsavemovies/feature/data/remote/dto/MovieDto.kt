package com.example.findsavemovies.feature.data.remote.dto

import com.example.findsavemovies.feature.data.local.entity.MovieEntity

data class MovieDto(
    val Actors: String?,
    val Awards: String?,
    val BoxOffice: String?,
    val Country: String?,
    val DVD: String?,
    val Director: String?,
    val Genre: String?,
    val Language: String?,
    val Metascore: String?,
    val Plot: String?,
    val Poster: String?,
    val Production: String?,
    val Rated: String?,
    val Ratings: List<Rating>?,
    val Released: String?,
    val Response: String?,
    val Runtime: String?,
    val Title: String?,
    val Type: String?,
    val Website: String?,
    val Writer: String?,
    val Year: String?,
    val imdbID: String?,
    val imdbRating: String?,
    val imdbVotes: String?
){
    fun toMovieEntity(): MovieEntity {
       return MovieEntity(
           title = Title,
           year = Year,
           runtime = Runtime,
           genre = Genre,
           director = Director,
           writer = Writer,
           actors = Actors,
           plot = Plot,
           language = Language,
           country = Country,
           poster = Poster,
           imdbRating = imdbRating,
           boxOffice = BoxOffice

       )
    }


}