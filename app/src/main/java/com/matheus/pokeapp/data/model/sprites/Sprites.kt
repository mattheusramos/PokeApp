package com.matheus.pokeapp.data.model.sprites

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String?,

    val other: OtherSprites
)