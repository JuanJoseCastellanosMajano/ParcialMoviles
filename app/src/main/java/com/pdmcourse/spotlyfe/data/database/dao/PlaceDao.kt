package com.pdmcourse.spotlyfe.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query;
import com.pdmcourse.spotlyfe.data.database.entities.PlaceEntity
import com.pdmcourse.spotlyfe.data.model.Place
import kotlinx.coroutines.flow.Flow


@Dao
interface PlaceDao {

    @Query("SELECT * FROM places")
   fun getplaces(): Flow<List<PlaceEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlacestoMap(place: Place)

}
