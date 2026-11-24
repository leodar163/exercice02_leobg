package com.leobg.exercice02_leobg

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leobg.exercice02_leobg.components.EventListScreen
import com.leobg.exercice02_leobg.models.Event
import com.leobg.exercice02_leobg.ui.theme.Exercice02_leobgTheme

class MainActivity : ComponentActivity() {
    val eventList = listOf(
        Event(0, "Pogo sur la Seine", "Punk", 120, "Paris"),
        Event(1, "Mob publique anti-fa", "Mobilisation", 8, "Lyon"),
        Event(2, "Adieu à Teddy Riner", "funérailles politiques", capacity = 4),
        Event(3, "Grève générale", "pas content", 0, "Partout"),
        Event(4, "Laver le linge de Macron", "troll", 5000, "Elysée"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercice02_leobgTheme {
                EventListScreen(eventList) {
                    Log.d(
                        "[Campus][Reservation]",
                        "Réservé une place pour l'évènement '${it.title}'"
                    )
                }
            }
        }
    }
}