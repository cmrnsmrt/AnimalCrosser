package uk.ac.abertay.cmp309.animalcrosser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.abertay.cmp309.animalcrosser.screens.Home
import uk.ac.abertay.cmp309.animalcrosser.screens.Profile
import uk.ac.abertay.cmp309.animalcrosser.screens.Welcome
import uk.ac.abertay.cmp309.animalcrosser.screens.Villager
import uk.ac.abertay.cmp309.animalcrosser.ui.theme.AnimalCrosserTheme
import uk.ac.abertay.cmp309.animalcrosser.ui.theme.Purple200
import uk.ac.abertay.cmp309.animalcrosser.ui.theme.Purple700
import uk.ac.abertay.cmp309.animalcrosser.ui.theme.Teal200
import kotlin.text.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCrosserTheme() {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
            Home(navController = navController)
        }

        composable(NavRoutes.Welcome.route + "/{userName}" + "/{password}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            val password = backStackEntry.arguments?.getString("password")
            Welcome(navController = navController, userName, password)
        }

        composable(NavRoutes.Profile.route) {
            Profile(navController = navController)
        }

        composable(NavRoutes.Villager.route + "/{userName}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            Villager(navController = navController, userName)
        }
    }
}

@Composable
fun MaterialTheme(
    colors: Colors,
    typography: Typography,
    shapes: Shapes,
    content: @Composable () -> Unit
) { }
