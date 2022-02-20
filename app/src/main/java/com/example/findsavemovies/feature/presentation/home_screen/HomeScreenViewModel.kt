package com.example.findsavemovies.feature.presentation.home_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findsavemovies.feature.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(
) {
   private var job: Job? = null


    var homeScreenList = mutableStateOf(HomeScreenListState())
        private set


    init {
        getSavedMovies()
    }

    fun handleEvent(event:HomeScreenEvent){
        when(event){
            is HomeScreenEvent.DeleteMovie -> {
                job?.cancel()
                job = viewModelScope.launch {
                    useCases.deleteMovie(title = event.title)
                }
            }
        }
    }


    private fun getSavedMovies(){
        job?.cancel()
        job = viewModelScope.launch {
            useCases.getSavedMovies().collect {
                homeScreenList.value = homeScreenList.value.copy(list = it)
            }
        }

    }




}