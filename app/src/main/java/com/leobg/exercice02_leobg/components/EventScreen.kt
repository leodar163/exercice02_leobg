package com.leobg.exercice02_leobg.components

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leobg.exercice02_leobg.viewModels.EventContent
import com.leobg.exercice02_leobg.viewModels.EventsViewModel

@Composable
fun EventScreen(viewModel: EventsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val content = uiState.content) {
        is EventContent.Success -> EventListScreen(
            events = content.events,
            favoriteIds = uiState.favoriteIds,
            onBook = {Log.d(
                "[Campus][Reservation]",
                "Réservé une place pour l'évènement '${it.title}'"
            )},
            onFavorite = {viewModel.onFavoriteClick(it)}
        )
        EventContent.Empty -> Text("Aucun évènement à afficher")
    }
}