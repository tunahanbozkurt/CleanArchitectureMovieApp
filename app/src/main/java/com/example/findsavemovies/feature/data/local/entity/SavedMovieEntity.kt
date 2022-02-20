package com.example.findsavemovies.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.findsavemovies.feature.domain.model.Movie

@Entity(tableName = "savedMovies")
data class SavedMovieEntity(
    val title:String,
    val year:String,
    val runtime:String,
    val genre:String,
    val director:String,
    val writer:String,
    val actors:String,
    val plot:String,
    val language:String,
    val country:String,
    val poster:String,
    val imdbRating:String,
    val boxOffice:String,
    @PrimaryKey val uid:String = title
){
    fun toMovie(): Movie{
        return Movie(
            title,
            year,
            runtime,
            genre,
            director,
            writer,
            actors,
            plot,
            language,
            country,
            poster,
            imdbRating,
            boxOffice
        )
    }
}
