package art.cameronsma.animalcrosser2.presentation.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import art.cameronsma.animalcrosser2.presentation.Logo
import art.cameronsma.animalcrosser2.presentation.destinations.InfoScreenDestination
import art.cameronsma.animalcrosser2.presentation.destinations.VillagerListingsScreenDestination
import art.cameronsma.animalcrosser2.presentation.destinations.YourVillagerListingsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

// Screen to welcome user to app
@Composable
@Destination(start = true)
fun WelcomeScreen(
    navigator: DestinationsNavigator,
) {
    val state = rememberLazyListState()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn( // Column to all for scrolling to future proof in case more buttons are added
            horizontalAlignment = Alignment.CenterHorizontally,
            state = state
        ) {
            item {
                Logo() // Function to display logo
            }

            item { // Welcome
                Text("Welcome", style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.size(30.dp))
            }

            item { // Button to go to all villagers
                Button(onClick = {
                    navigator.navigate(
                        YourVillagerListingsScreenDestination()
                    )
                }) {
                    Text(text = "View your villagers")
                }

                Spacer(modifier = Modifier.size(30.dp))
            }

            item { // Button to go to your villagers
                Button(onClick = {
                    navigator.navigate(
                        VillagerListingsScreenDestination()
                    )
                }) {
                    Text(text = "View all villagers")
                }

                Spacer(modifier = Modifier.size(30.dp))
            }

            item { // Button to go to how to use app guide
                Button(onClick = {
                    navigator.navigate(
                        InfoScreenDestination()
                    )
                }) {
                    Text(text = "How to use this app")
                }

                Spacer(modifier = Modifier.size(30.dp))
            }
        }
    }
}