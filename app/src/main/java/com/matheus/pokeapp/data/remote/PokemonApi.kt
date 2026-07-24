package com.matheus.pokeapp.data.remote

import retrofit2.http.*
import com.matheus.pokeapp.data.model.*

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    )

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): PokemonDetails
}

