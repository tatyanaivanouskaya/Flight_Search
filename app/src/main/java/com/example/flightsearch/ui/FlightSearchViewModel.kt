package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.data.entity.Airport
import com.example.flightsearch.data.repository.FlightSearchRepository
import kotlinx.coroutines.flow.Flow

class FlightSearchViewModel(
    private val flightSearchRepository: FlightSearchRepository
) : ViewModel() {

    fun getAirportList(airportName: String): Flow<List<Airport>> =
        flightSearchRepository.getAirportList(name = airportName)

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                FlightSearchViewModel(
                    flightSearchApplication().container.flightSearchRepository,
                )
            }
        }
    }
}

fun CreationExtras.flightSearchApplication(): FlightSearchApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightSearchApplication)