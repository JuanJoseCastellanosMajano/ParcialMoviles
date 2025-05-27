package com.pdmcourse.spotlyfe.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class PlaceEntity (
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val name: String,
  val description: String,
  val latitude: Double,
  val longitude: Double
)