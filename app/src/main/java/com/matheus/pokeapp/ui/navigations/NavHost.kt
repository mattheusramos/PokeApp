package com.matheus.pokeapp.ui.navigations

import com.matheus.pokeapp.home.HomeScreen
import com.matheus.pokeapp.login.LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.matheus.pokeapp.details.DetailScreen

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
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 1

            DetailScreen(
                id = id,
                onBackClick = { navController.popBackStack() }
            )

        }

    }
}