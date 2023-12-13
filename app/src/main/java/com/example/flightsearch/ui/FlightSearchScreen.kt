package com.example.flightsearch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchScreen(
    viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.factory)
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Flight Search"

                    )
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 8.dp, end = 8.dp)
        ) {
            SearchBox()

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox() {
    val searchText = remember { mutableStateOf("") }
    Row {
        TextField(
            value = searchText.value,
            onValueChange = { newText -> searchText.value = newText }
        )
    }

}