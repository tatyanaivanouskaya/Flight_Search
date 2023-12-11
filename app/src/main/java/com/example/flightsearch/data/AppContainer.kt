package com.example.flightsearch.data

import android.content.Context
import com.example.flightsearch.data.repository.FlightSearchRepository


interface AppContainer {
    val flightSearchRepository: FlightSearchRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val flightSearchRepository: FlightSearchRepository by lazy {
        FlightSearchRepositoryImpl(FlightSearchDatabase.getDatabase(context).flightSearchDao())
    }
}