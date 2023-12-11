package com.example.flightsearch.data.repository

import com.example.flightsearch.data.entity.Airport
import kotlinx.coroutines.flow.Flow

interface FlightSearchRepository {

    fun getAirportList(name: String): Flow<List<Airport>>
}