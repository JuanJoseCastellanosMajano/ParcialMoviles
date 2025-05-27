package com.pdmcourse.spotlyfe.ui.screens.SavedPlaces.Form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable

fun SelectLocationMap(
    initialPosition: LatLng=LatLng(13.679024407659101,-89.23578718993471),

) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialPosition, 16f)
    }

    var uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }

    val markerState = rememberMarkerState(position = initialPosition)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(300.dp)
    ){
        GoogleMap(
            modifier = Modifier.fillMaxWidth(),
            cameraPositionState =  cameraPositionState,
            uiSettings = uiSettings,
            onMapClick = { newLatLng->
                markerState.position =newLatLng
                onLocationChanged(newLatLng)
                Log.d("SelectLocationMap", "New location selected: $newLatLng")
            }
        ){
            Marker(state = markerState)
        }
    }
}