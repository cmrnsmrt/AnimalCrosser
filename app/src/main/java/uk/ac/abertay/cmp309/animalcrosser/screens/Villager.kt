package uk.ac.abertay.cmp309.animalcrosser.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uk.ac.abertay.cmp309.animalcrosser.NavRoutes

@Composable
fun Villager(navController: NavHostController, userName: String?) {

    MaterialTheme{
        Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFFA7E78F)))

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                logo()

                Spacer(modifier = Modifier.size(30.dp))
            }
        }
    }

}
