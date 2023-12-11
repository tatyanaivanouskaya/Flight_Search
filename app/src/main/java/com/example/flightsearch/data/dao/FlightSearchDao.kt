package com.example.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearch.data.entity.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightSearchDao {
    @Query(
        "SELECT * from airport WHERE iata_code LIKE '%' || :airportName || '%' OR" +
                " name LIKE '%' || :airportName || '%' "
    )
    fun getAirportList(airportName: String): Flow<List<Airport>>
}