package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.Form;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.android.gms.maps.model.LatLng
import com.pdmcourse.spotlyfe.SpotLyfeApplication
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place
import com.pdmcourse.spotlyfe.data.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class FormViewModel (
    private val placeRepository: PlaceRepository
): ViewModel(){

    val lugares: Flow<List<PlaceEntity>> = placeRepository.getplaces()


    fun savePlace(name: String, description: String, location: LatLng) {
        viewModelScope.launch {
            val place = PlaceEntity(
                name = name,
                description = description,
                latitude = location.latitude,
                longitude = location.longitude
            )
            placeRepository.addPlacestoMap(Place)
        }
    }



    companion object{
        val Factory: ViewModelProvider.Factory=viewModelFactory{
            initializer{
                val application = (this[APPLICATION_KEY] as SpotLyfeApplication)
                FormViewModel(application.appProvider.providePlaceRepository)
            }
        }
    }
}
