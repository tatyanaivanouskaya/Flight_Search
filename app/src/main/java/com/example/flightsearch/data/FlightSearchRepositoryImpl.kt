package com.example.flightsearch.data

import com.example.flightsearch.data.dao.FlightSearchDao
import com.example.flightsearch.data.repository.FlightSearchRepository

class FlightSearchRepositoryImpl (private val airportDao: FlightSearchDao): FlightSearchRepository {
    override fun getAirportList(name: String) = airportDao.getAirportList(airportName = name)
}