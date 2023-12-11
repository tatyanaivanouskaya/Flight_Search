package com.example.flightsearch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flightsearch.data.dao.FlightSearchDao
import com.example.flightsearch.data.entity.Airport
import com.example.flightsearch.data.entity.Favorite

@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class FlightSearchDatabase: RoomDatabase() {
    abstract fun flightSearchDao(): FlightSearchDao

    companion object {
        @Volatile
        private var Instance: FlightSearchDatabase? = null

        fun getDatabase(context: Context): FlightSearchDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FlightSearchDatabase::class.java, "airport_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build().also { Instance = it }
            }
        }
    }
}