package com.example.findsavemovies.feature.domain.usecase

import com.example.findsavemovies.common.Resource
import com.example.findsavemovies.feature.data.remote.ConnectivityController
import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Search(
    private val repository: MovieRepository,
    private val connectivityController: ConnectivityController
) {

    operator fun invoke(title: String?): Flow<Resource<Movie>> {
        return if (!title.isNullOrEmpty() && connectivityController.isOnline()){
            repository.fetchMovie(title = title)
        }
        else{
            flow { }
        }

    }

}