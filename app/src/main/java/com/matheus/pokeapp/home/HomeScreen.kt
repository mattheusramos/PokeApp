package com.matheus.pokeapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.matheus.pokeapp.R
import com.matheus.pokeapp.utils.*
import com.matheus.pokeapp.ui.components.PokemonCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onPokemonClick: (Int) -> Unit,
){

    val pokemons by viewModel.pokemons.collectAsState()
    val search by viewModel.search.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pokeball_icon),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Pokedex",
                            color = VermelhoPrincipal,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        when {
            loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(color = Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(
                        color = VermelhoPrincipal
                    )
                }
            }

            error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(error ?: "")
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(color = Color.White),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    item {
                        OutlinedTextField(
                            value = search,
                            onValueChange = viewModel::onSearchChange,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text("Pesquisar Pokémon")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            },
                            shape = RoundedCornerShape(30.dp),
                            singleLine = true
                        )
                    }


                    items(pokemons) { pokemon ->
                        val id = pokemon.url
                            .trimEnd('/')
                            .substringAfterLast('/')
                            .toInt()

                        PokemonCard(
                            pokemon = pokemon,
                            onClick = {
                                onPokemonClick(id)
                            }
                        )

                    }

                }
            }

        }
    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onPokemonClick = {  },
    )
}