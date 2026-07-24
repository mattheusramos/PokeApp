package com.matheus.pokeapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheus.pokeapp.R
import com.matheus.pokeapp.login.LoginScreen
import com.matheus.pokeapp.utils.VermelhoPrincipal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onPokemonClick: () -> Unit,
    onSettingsClick: () -> Unit,
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_icon),
                        contentDescription = "Pokeball Icon",
                        modifier = Modifier
                            .size(24.dp)
                    )

                    Text(
                        text = "Pokedex",
                        fontWeight = FontWeight.Bold,
                        color = VermelhoPrincipal,
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                    )

                }
            )
        }
        // bottombar = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            // Content for the Pokemon list will go here
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onPokemonClick = {  },
        onSettingsClick = { }
    )
}