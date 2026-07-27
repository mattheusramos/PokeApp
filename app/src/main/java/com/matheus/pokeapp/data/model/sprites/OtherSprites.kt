package com.matheus.pokeapp.data.model.sprites

import com.google.gson.annotations.SerializedName

data class OtherSprites(

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork

)