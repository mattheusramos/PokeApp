package com.matheus.pokeapp.data.repository

import com.matheus.pokeapp.data.remote.*

class PokemonRepository(
    private val api: PokemonApi
) {
    suspend fun getPokemons() =
        api.getPokemonList()

    suspend fun getPokemons(name: String) =
        api.getPokemon(name)
}