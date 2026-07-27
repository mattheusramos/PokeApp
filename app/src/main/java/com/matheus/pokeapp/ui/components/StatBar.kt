package com.matheus.pokeapp.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheus.pokeapp.utils.CorCard

@Composable
fun StatBar(
    label: String,
    value: Int,
    color: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp
        )

        Text(
            text = value.toString(),
            modifier = Modifier.width(36.dp),
            fontWeight = FontWeight.Bold
        )

        LinearProgressIndicator(
            progress = { value / 255f },
            modifier = Modifier
                .weight(1f)
                .height(8.dp),
            color = color,
            trackColor = CorCard
        )
    }
}