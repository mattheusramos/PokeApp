package com.matheus.pokeapp.data.repository

import com.matheus.pokeapp.data.remote.*

class PokemonRepository(
    private val api: PokemonApi
) {
    suspend fun getPokemonList() =
        api.getPokemonList()

    suspend fun getPokemons(id: Int) =
        api.getPokemon(id)
}