package com.leobg.exercice02_leobg.viewModels

import androidx.lifecycle.ViewModel
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.models.sample.sampleEvents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed class EventContent {
    data class Success(val events: List<Event>) : EventContent()
    data object Empty : EventContent()
}

data class EventUIState(
    val content: EventContent,
    val favoriteIds: List<Int> = emptyList(),
)

class EventsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        EventUIState(content = EventContent.Success(sampleEvents))
    )

    val uiState = _uiState.asStateFlow()

    fun onFavoriteClick(eventId: Int) {
        _uiState.update {
            it.copy(
                favoriteIds = if (eventId in it.favoriteIds)
                    it.favoriteIds - eventId
                else
                    it.favoriteIds + eventId
            )
        }
    }
}