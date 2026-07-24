package com.matheus.pokeapp.data.model

data class PokemonResult(
    val name: String,
    val url: String
){
    val id: Int
        get() = url
            .trimEnd('/')
            .substringAfterLast('/')
            .toInt()

    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}