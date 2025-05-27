package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.repository.PlaceRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SavedPlacesViewModel(
    private val placeRepository: PlaceRepository
) : ViewModel() {

    private val lugar = MutableStateFlow<List<PlaceEntity>>(emptyList())

    var places: StateFlow<List<PlaceEntity>> = lugar.asStateFlow()

    init {
        fetchPlaces()
    }

    fun fetchPlaces() {
        viewModelScope.launch {
            placeRepository.getplaces()
                .catch { e ->

                }
                .collect { list ->
                    places.value = list
                }
        }
    }


        companion object {
            val Factory: ViewModelProvider.Factory = viewModelFactory {
                initializer {
                    val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ParcialMoviles
                    val repository: PlaceRepository = application.appProvider.providePlaceRepository
                    SavedPlacesViewModel(repository)
                }
            }
        }
}