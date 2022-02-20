package com.example.findsavemovies.feature.presentation.detail_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findsavemovies.feature.domain.model.Movie
import com.example.findsavemovies.feature.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private var job: Job? = null

    var detailState = mutableStateOf(DetailScreenState())
        private set



    fun handleEvent(event: DetailScreenEvent){
        when(event){
            is DetailScreenEvent.SaveMovie -> {
                viewModelScope.launch {
                    saveMovie(event.movie)
                }
            }
            is DetailScreenEvent.LoadData -> {
               if (event.title?.isNotEmpty() == true){
                   getSavedMovie(event.title)
               }
                else{
                    getCacheMovie()
                }
            }
        }

    }


    private suspend fun saveMovie(movie: Movie){
        useCases.saveMovie(movie.toSavedMovieEntity())
    }

    private fun getCacheMovie(){
        viewModelScope.launch {
            val cacheData = useCases.cacheMovie()
            detailState.value = detailState.value.copy(
                movie = cacheData
            )

        }

    }

    private fun getSavedMovie(title:String){
        job?.cancel()

        job = viewModelScope.launch {
            val movie = useCases.getSavedMovie(title)
           detailState.value = detailState.value.copy(
               movie = movie
           )

        }
    }

}



