package com.matheus.pokeapp.ui.navigations

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Details : Screen("details/{id}")
}