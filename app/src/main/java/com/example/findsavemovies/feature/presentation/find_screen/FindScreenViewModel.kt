package com.example.findsavemovies.feature.presentation.find_screen


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findsavemovies.common.Resource
import com.example.findsavemovies.feature.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FindScreenViewModel @Inject constructor(
   private val useCases: UseCases
):ViewModel()

 {

    private var job:Job? = null

    var searchBarState = mutableStateOf(SearchBarState())
        private set


    var listState = mutableStateOf(ListState())
        private set

    fun uiEvents(event: FindScreenEvents){
        when(event){
            is FindScreenEvents.TitleInput -> {
               searchBarState.value = searchBarState.value.copy(
                    text = event.title
               )
            }
            is FindScreenEvents.Search -> {
                getMovie(title = searchBarState.value.text)
            }

        }
    }

    private fun getMovie(title: String?){
        job?.cancel()

        job =  useCases.search(title = title).onEach { resource ->
            when(resource){
                is Resource.Success -> {
                    listState.value = listState.value.copy(
                        item = resource.data,
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    listState.value = listState.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Error -> {
                    listState.value = listState.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)




    }


}