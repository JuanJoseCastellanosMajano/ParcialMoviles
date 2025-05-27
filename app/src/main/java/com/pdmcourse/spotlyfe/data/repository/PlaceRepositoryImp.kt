package com.pdmcourse.spotlyfe.data.repository

import com.pdmcourse.spotlyfe.data.database.dao.PlaceDao
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaceRepositoryImp(
    private val placeDao: PlaceDao
) : PlaceRepository {

    override fun getplaces(): Flow<List<Place>> {
        return placeDao.getplaces().map { list ->
            list.map { entity ->
                Place(
                    name = entity.name,
                    remark = entity.description ?: "",
                    latitude = entity.latitude,
                    longitude = entity.longitude
                )
            }
        }
    }
    override suspend fun addPlacestoMap(place: Unit) {
        val entity = PlaceEntity(
            name = place.name,
            description = place.remark,
            latitude = place.latitude,
            longitude = place.longitude
        )
        placeDao.addPlacestoMap(place)
    }
}
