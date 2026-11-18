package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events: List<Event>, onBook: (event: Event) -> Unit) {
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
                    EventCard(it) { onBook(it) }
                }
            }
        }
    }
}

@Composable
@Preview
fun EventListScreenPreview() {
    val eventList = listOf(
        Event(0, "Pogo sur la Seine", "Punk", 120, "Paris"),
        Event(1, "Mob publique anti-fa", "Mobilisation", 8, "Lyon"),
        Event(2, "Adieu à Teddy Riner", "funérailles politiques", capacity = 4),
        Event(3, "Grève générale", "pas content", 0, "Partout"),
        Event(4, "Laver le linge de Macron", "troll", 5000, "Elysée"),
    )

    Exercice02_leobgTheme {
        EventListScreen(eventList) {}
    }
}