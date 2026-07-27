package com.matheus.pokeapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.matheus.pokeapp.utils.*

@Composable
fun TypeChip(
    type: String
) {
    Surface(
        color = getTypeColor(type).copy(alpha = .2f),
        shape = RoundedCornerShape(50)
    ) {

        Text(
            text = type.replaceFirstChar { it.uppercase() },
            color = getTypeColor(type),
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 6.dp
            ),
            fontWeight = FontWeight.Bold
        )
    }
}

fun getTypeColor(type: String): Color {
    return when(type.lowercase()) {
        "grass" -> Grass
        "fire" -> Fire
        "water" -> Water
        "electric" -> Electric
        "bug" -> Bug
        "poison" -> Poison
        "normal" -> Normal

        else -> Color.Gray
    }
}
