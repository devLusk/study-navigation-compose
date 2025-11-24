package com.github.devlusk.navigationsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.devlusk.navigationsample.screens.FirstScreen
import com.github.devlusk.navigationsample.screens.SecondScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.FIRST_SCREEN
    ) {
        composable(Routes.FIRST_SCREEN) {
            FirstScreen { userName ->
                navController.navigate(Routes.secondScreenWithArg(userName))
            }
        }

        composable("${Routes.SECOND_SCREEN}/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            SecondScreen(userName) {
                navController.navigate(Routes.FIRST_SCREEN)
            }
        }
    }
}