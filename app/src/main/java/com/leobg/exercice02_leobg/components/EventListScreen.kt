package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
             TopAppBar( title = {Text("Campus", fontSize = 36.sp)})
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(events, key = { it.id }) {
                EventCard(it) { onBook(it) }
            }
        }
    }
}

@Composable
@Preview
fun EventListScreenPreview() {
    val eventList = listOf(
        Event(0, "Pogo sur la Seine", "Punk", "Paris", 120),
        Event(1, "Mob publique anti-fa", "Mobilisation", "Lyon", 8),
        Event(2, "Adieu à Teddy Riner", "funérailles politiques", capacity = 4),
        Event(3, "Grève générale", "pas content", "Partout", 0),
        Event(4, "Laver le linge de Macron", "troll", "Elysée", 5000),
    )

    Exercice02_leobgTheme {
        EventListScreen(eventList) {}
    }
}