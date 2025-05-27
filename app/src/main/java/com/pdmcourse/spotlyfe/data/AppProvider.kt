package com.pdmcourse.spotlyfe.data

import android.content.Context
import com.pdmcourse.spotlyfe.data.database.AppDatabase

class AppProvider(context: Context) {
  private val appDatabase = AppDatabase.getDatabase(context)

//  fun providePlaceRepository() : PlaceRepository {
//
//  }
}