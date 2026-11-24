package com.leobg.exercice02_leobg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leobg.exercice02_leobg.R
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.models.sample.sampleEvents
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme

@Composable
fun EventCard(
    event: Event,
    onBook: (event: Event) -> Unit,
    isFavorite: Boolean = false,
    onFavorite: (id: Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(AbsoluteRoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
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
        Box(
            modifier = Modifier.wrapContentWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "favorite button",
                modifier = Modifier.size(64.dp).clickable {onFavorite(event.id)}
            )
        }
    }
}

@Composable
@Preview
fun EventCardPreview() {
    Exercice02_leobgTheme(darkTheme = true) {
        Box(modifier = Modifier.size(400.dp, 400.dp)) {
            EventCard(sampleEvents[0], {}) { }
        }
    }
}