package com.leobg.exercice02_leobg.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leobg.exercice02_leobg.R
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.models.sample.sampleEvents
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: Event,
    isFavorite: Boolean = false,
    onBook: (event: Event) -> Unit,
    onFavorite: (Int) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(title = { Text(event.title, style = MaterialTheme.typography.titleLarge) })
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Badge { Text(event.category, style = MaterialTheme.typography.bodySmall) }

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
                    Text(
                        event.location, style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Text(
                text = "${stringResource(R.string.remaining_places)} : ${event.capacity}",
                style = MaterialTheme.typography.bodySmall
            )
            OutlinedCard() {
                Text(event.description, modifier = Modifier.padding(12.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button({ onBook(event) }) {
                    Text(
                        stringResource(R.string.book), style = MaterialTheme.typography.bodySmall
                    )
                }

                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "favorite button",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable { onFavorite(event.id) },
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)//ça marche pas...
fun EventDetailScreenPreview() {
    Exercice02_leobgTheme(darkTheme = true) {
        EventDetailScreen(
            sampleEvents[0].copy(description = "En avant les amis pour une aventure de fifou dans un event de QUA.LI.TE"),
            false,
            {}) {}
    }
}