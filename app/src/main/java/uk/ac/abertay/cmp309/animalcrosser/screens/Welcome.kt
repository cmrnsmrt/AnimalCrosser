package uk.ac.abertay.cmp309.animalcrosser.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import uk.ac.abertay.cmp309.animalcrosser.NavRoutes

@Composable
fun Welcome(navController: NavHostController, userName: String?, password: String?) {

    MaterialTheme{
        Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFFA7E78F)))

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Welcome, $userName", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.size(30.dp))

                Button(onClick = {
                    navController.navigate(NavRoutes.Profile.route){
                        popUpTo(NavRoutes.Home.route)
                    }
                }) {
                    Text(text = "Set up your Profile")
                }
            }
        }
    }

}
