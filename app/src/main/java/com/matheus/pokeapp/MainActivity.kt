package com.matheus.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.matheus.pokeapp.ui.navigations.*
import com.matheus.pokeapp.utils.PokeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokeAppTheme {
                AppNavigation()
            }
        }
    }
}
