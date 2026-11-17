package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leobg.exercice02_leobg.models.Event

@Composable
fun EventCard(event: Event, onBook: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(event.title, fontSize = 20.sp)
            Text(event.category, fontSize = 12.sp, color = Color.Gray)
            if (event.location != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PinDrop,
                        contentDescription = "location icon",
                        modifier = Modifier.size(10.dp)
                    )
                    Text(event.location, fontSize = 12.sp)
                }
            }
            Text("places restantes: ${event.capacity}", fontSize = 12.sp)
            Button(onBook) {
                Text("Réserver", fontSize = 12.sp)
            }
        }
    }
}

@Composable
@Preview
fun EventCardPreview() {
    Exercice02_leobgTheme {
        Box(modifier = Modifier.size(400.dp, 400.dp)) {
            EventCard(event = Event(2, "titre", "categorie", "Paris", capacity = 5)) { }
        }
    }
}