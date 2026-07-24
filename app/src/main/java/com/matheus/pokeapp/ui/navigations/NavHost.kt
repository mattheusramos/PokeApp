package com.matheus.pokeapp.ui.navigations

import com.matheus.pokeapp.home.HomeScreen
import com.matheus.pokeapp.login.LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginClick = { _, _ ->
                    navController.navigate(Screen.Home.route)
                },
                onVisitClick = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onPokemonClick = { id ->
                    navController.navigate("details/$id")
                },
                onSettingsClick = { }
            )
        }
    }
}