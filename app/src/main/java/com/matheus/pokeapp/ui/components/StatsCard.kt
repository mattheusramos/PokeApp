package com.matheus.pokeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheus.pokeapp.R
import com.matheus.pokeapp.utils.*

@Composable
fun ActionCard(
    title: String,
    text: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = CorCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = title,
                tint = VermelhoPrincipal,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                color = VermelhoPrincipal,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = text,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActionCardPreview() {
    ActionCard (
        title = "Altura",
        text = "2,07m",
        icon = painterResource(id = R.drawable.height),
        modifier = Modifier
            .height(144.dp)
            .width(167.dp)
    )
}