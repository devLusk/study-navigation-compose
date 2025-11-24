package com.github.devlusk.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.devlusk.navigationsample.screens.FirstScreen
import com.github.devlusk.navigationsample.screens.SecondScreen
import com.github.devlusk.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "firstscreen"
    ) {
        composable("firstscreen") {
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }
        composable("secondscreen") {
            SecondScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}