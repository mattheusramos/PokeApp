package com.matheus.pokeapp.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.matheus.pokeapp.ui.components.ActionCard
import com.matheus.pokeapp.R
import com.matheus.pokeapp.ui.components.TypeChip
import com.matheus.pokeapp.utils.VermelhoPrincipal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    id: Int,
    onBackClick: () -> Unit,
    viewModel: DetailsViewModel = viewModel()
) {

    LaunchedEffect(id) {
        viewModel.loadPokemon(id)
    }

    val pokemon by viewModel.pokemon.collectAsState()
    val loading by viewModel.isLoading.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pokeball_icon),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        if (loading) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = VermelhoPrincipal
                )
            }
        } else {

            pokemon?.let { details ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .background(color = Color.White)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    AsyncImage(
                        model = details.sprites.other.officialArtwork.frontDefault,
                        contentDescription = details.name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Text(
                        text = details.name.replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp),
                    )

                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        details.types.forEach { typeSlot ->
                            TypeChip(
                                type = typeSlot.type.name
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ActionCard(
                            modifier = Modifier
                                .weight(1f),
                            title = "Altura",
                            text = details.heightText,
                            icon = painterResource(id = R.drawable.height),
                        )

                        ActionCard(
                            modifier = Modifier
                                .weight(1f),
                            title = "Peso",
                            text = details.weightText,
                            icon = painterResource(id = R.drawable.peso),
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ActionCard(
                            modifier = Modifier
                                .weight(1f),
                            title = "Exp Base",
                            text = details.baseExperience,
                            icon = painterResource(id = R.drawable.exp),
                        )
                        ActionCard(
                            modifier = Modifier
                                .weight(1f),
                            title = "Tipo",
                            text = details.types.joinToString("\n") {
                                it.type.name.replaceFirstChar { c -> c.uppercase() }
                            },
                            icon = painterResource(id = R.drawable.habs),
                        )
                    }

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp, vertical = 30.dp)
                            .height(70.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = VermelhoPrincipal),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Icon(Icons.Default.Favorite, null)

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = ("Favoritar"),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        id = 25,
        onBackClick = { }
    )
}