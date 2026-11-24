package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.models.sample.sampleEvents
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme
import com.leobg.exercice02_leobg.viewModels.EventsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<Event>,
    onBook: (event: Event) -> Unit,
    favoriteIds: List<Int> = emptyList(),
    onFavorite: (Int) -> Unit,
) {
    val categories = events.map { it.category }.distinct()



    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Campus", style = MaterialTheme.typography.titleLarge) })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CategoryHeader(categories)
            LazyColumn(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(events, key = { it.id }) {
                    EventCard(
                        it,
                        { onBook(it) },
                        isFavorite = it.id in favoriteIds,
                        onFavorite = onFavorite
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun EventListScreenPreview() {

    Exercice02_leobgTheme(darkTheme = false) {
        EventListScreen(sampleEvents, {}) {}
    }
}