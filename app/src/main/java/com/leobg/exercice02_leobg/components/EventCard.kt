package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leobg.exercice02_leobg.R
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme

@Composable
fun EventCard(event: Event, onBook: (event: Event) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(AbsoluteRoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                event.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.background
            )
            Badge { Text(event.category, style = MaterialTheme.typography.bodySmall) }
            if (event.location != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PinDrop,
                        contentDescription = "location icon",
                        modifier = Modifier.size(10.dp),
                        tint = MaterialTheme.colorScheme.background
                    )
                    Text(
                        event.location,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            }
            Text(
                "${stringResource(R.string.remaining_places)}: ${event.capacity}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.background
            )
            Button({ onBook(event) }) {
                Text(
                    stringResource(R.string.book),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}

@Composable
@Preview
fun EventCardPreview() {
    Exercice02_leobgTheme {
        Box(modifier = Modifier.size(400.dp, 400.dp)) {
            EventCard(event = Event(2, "titre", "categorie", capacity = 5, "Paris")) { }
        }
    }
}