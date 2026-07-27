package com.matheus.pokeapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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

        "grass" -> Color(0xFF4CAF50)

        "fire" -> Color(0xFFFF7043)

        "water" -> Color(0xFF42A5F5)

        "electric" -> Color(0xFFFFCA28)

        "bug" -> Color(0xFF8BC34A)

        "poison" -> Color(0xFFAB47BC)

        "normal" -> Color(0xFFBDBDBD)

        else -> Color.Gray
    }
}
