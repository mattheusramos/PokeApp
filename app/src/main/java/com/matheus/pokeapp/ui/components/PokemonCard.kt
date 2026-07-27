package com.matheus.pokeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.matheus.pokeapp.data.model.PokemonResult
import com.matheus.pokeapp.utils.CorCard

@Composable
fun PokemonCard(
    pokemon: PokemonResult,
    onClick: () -> Unit
) {
    val id = pokemon.url
        .trimEnd('/')
        .substringAfterLast('/')

    val image = pokemon.imageUrl

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = CorCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

          Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "#$id",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = pokemon.name.replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

//              Row(
//                  horizontalArrangement = Arrangement.spacedBy(8.dp)
//              ) {
//                  pokemon.types.forEach {
//                      TypeChip(it.type.name)
//                  }
//              }
            }

            AsyncImage(
                model = image,
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {

    val pokemon = PokemonResult(
        name = "Pikachu",
        url = "https://pokeapi.co/api/v2/pokemon/25/"
    )

    PokemonCard(
        pokemon = pokemon,
        onClick = {}
    )

}