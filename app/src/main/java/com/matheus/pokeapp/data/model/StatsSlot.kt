package com.matheus.pokeapp.data.model

import com.google.gson.annotations.SerializedName

data class StatsSlot(

    @SerializedName("base_stat")
    val baseStat: Int,

    val stat: PokemonStat
)