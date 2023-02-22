package art.cameronsma.animalcrosser2.presentation.info

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import art.cameronsma.animalcrosser2.presentation.Logo
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


// Screen to show user information
@Composable
@Destination
fun InfoScreen(
    navigator: DestinationsNavigator, // Used for navigation
) {
    val state = rememberLazyListState() // Holds Lazy column position
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("http://acnhapi.com/doc")) } // Used to open data source

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        LazyColumn( // Allows for scrolling through items
            horizontalAlignment = Alignment.CenterHorizontally,
            state = state
        ) {

            item { // Each object must be put in an object to allow scrolling
                Logo() // Logo.kt composable to display logo image
            }

            item {
                Text("Welcome to AnimalCrosser", // Title
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(16.dp))
            }

            item {
                Text("What is this app?", // Heading
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item { // Body
                Text("AnimalCrosser is an Animal Crossing New Horizons villager tracking app." +
                            " It was designed to allow you to view all of the available villagers in" +
                            " the game and keep track of which ones you have on your island. AnimalCrosser" +
                            " will also remind you when to speak to villagers you haven't talked to in a while" +
                            " abd remind you of any up and coming birthdays.",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            item { // Heading
                Text("How do I add a villager to my island?",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item { // Body
                Text("To add a new villager to your island navigate to the page 'View all villagers' " +
                            " from the welcome screen, then search using the search bar and click 'Add to island'" +
                            " button.",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            item { // Heading
                Text("How do I remove a villager to my island?",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(8.dp))
            }

            item { // Body
                Text("To add a new villager to your island navigate to the page 'View all villagers' " +
                            " from the welcome screen, then search using the search bar and click 'Remove from island'" +
                            " button.",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            item { // Heading
                Text("How do I keep track of my villagers?",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item { // Body
                Text(
                    "Navigate to the page 'View my villagers' from the welcome screen, all of the villagers" +
                            " that you have on your island appear here. Simply click 'mark as spoken to' each time you" +
                            "talk to them and AnimalCrosser will do the rest.",
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            }

            item {
                Spacer(modifier = Modifier.size(50.dp))
                Button(onClick = {
                    context.startActivity(intent) // When clicked, open browser with data set
                }) {
                    Text(text = "Go to data source")
                }
                Spacer(modifier = Modifier.size(250.dp))
            }

        }
    }
}