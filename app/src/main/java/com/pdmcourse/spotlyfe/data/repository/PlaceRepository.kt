package com.pdmcourse.spotlyfe.data.repository

import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow


interface PlaceRepository {

    fun getplaces(): Flow<List<PlaceEntity>>
    suspend fun addPlacestoMap(place: Place)

}