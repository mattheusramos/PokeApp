package com.matheus.pokeapp.data.model

import com.google.gson.annotations.SerializedName
import com.matheus.pokeapp.data.model.sprites.Sprites

data class PokemonDetails(

    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,

    @SerializedName("base_experience")
    val baseExperience: String,

    val sprites: Sprites,
    val stats: List<StatsSlot>,
    val types: List<TypeSlot>

) {

    val heightText: String
        get() = "${height / 10.0} m"

    val weightText: String
        get() = "${weight / 10.0} kg"

}