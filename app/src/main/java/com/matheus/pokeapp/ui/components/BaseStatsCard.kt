package com.matheus.pokeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matheus.pokeapp.data.model.StatsSlot
import com.matheus.pokeapp.utils.CorCard

@Composable
fun BaseStatsCard(
    stats: List<StatsSlot>
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = CorCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                "Status Base",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            stats.forEach {

                StatBar(
                    label = when(it.stat.name){

                        "hp" -> "HP"
                        "attack" -> "Ataque"
                        "defense" -> "Defesa"
                        "special-attack" -> "Atq. Esp."
                        "special-defense" -> "Def. Esp."
                        "speed" -> "Rapidez"

                        else -> it.stat.name
                    },

                    value = it.baseStat,

                    color = statsColor(it.stat.name)

                )
            }

        }

    }
}

private fun statsColor(name: String): Color {
    return when(name) {
        "hp" -> Color(0xFFF44336)

        "attack" -> Color(0xFFFF9800)

        "defense" -> Color(0xFF3F7AE0)

        "special-attack" -> Color(0xFFFF9800)

        "special-defense" -> Color(0xFF5C9DFF)

        "speed" -> Color(0xFFE91E63)

        else -> Color.Gray
    }
}
