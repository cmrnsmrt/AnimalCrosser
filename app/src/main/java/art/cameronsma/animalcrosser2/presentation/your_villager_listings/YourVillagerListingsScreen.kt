package art.cameronsma.animalcrosser2.presentation.your_villager_listings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalDateTime

@Composable
@Destination
fun YourVillagerListingsScreen(
    navigator: DestinationsNavigator, // Used for navigation
    viewModel: YourVillagerListingsViewModel = hiltViewModel() // View model for page
) {
    val swipeRefreshState = rememberSwipeRefreshState( // Watches for swipe down to refresh
        isRefreshing = viewModel.state.isRefreshing // Updates when refreshing
    )
    val state = viewModel.state // Takes state of view model
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField( // Search bar
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent( // When text in input field changes update page
                    YourVillagerListingsEvent.OnSearchQueryChange(it)
                )
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Search...") // Default text
            },
            maxLines = 1,
            singleLine = true
        )
        SwipeRefresh( // Object that allows for swiping down to refresh that holds rest of page
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent( // Refresh the page when dragged down
                    YourVillagerListingsEvent.Refresh
                )
            }
        ) {
            LazyColumn( // Column that allows scrolling through items
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.villagers.size) { i -> // Loops through villagers
                    val villager = state.villagers[i] // Villager set to current villager in loop
                    if(villager.inVillage == "TRUE"){ // If villager is in your village
                        YourVillagerItem( // Displays current villager using your villager item composable
                            villager = villager,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                        Column (
                            modifier = Modifier.padding(16.dp)
                        ){
                            Button( // Add to village button
                                onClick = {
                                    val current = LocalDateTime.now() // Mark as spoken to button
                                    viewModel.setLastSpoken(current.toString(),villager.id) // Sets villager as spoken to
                                    viewModel.onEvent(
                                        YourVillagerListingsEvent.Refresh // Refreshes data after villager is marked as spoken to so change is shown
                                    ) },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(villager.bubbleCol.toColorInt())) // Sets button colour to colour from database
                            ) {
                                Text(text = "Mark as spoken with today", color = Color(villager.textCol.toColorInt())) // Sets text colour to colour from database
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button( // Button to remove from village
                                    modifier = Modifier.weight(1f),
                                    onClick = {
                                        viewModel.removeFromVillage(villager.id) // Removes from village
                                        viewModel.onEvent(
                                            YourVillagerListingsEvent.Refresh // Refreshes update
                                        )
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(villager.bubbleCol.toColorInt()) // Sets button colour to colour from database
                                    )
                                ) {
                                    Text(text = "Remove from island", color = Color(villager.textCol.toColorInt())) // Sets text colour to colour from database
                                }
                            }
                        }
                        if(i < state.villagers.size){
                            Divider(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                thickness = 4.dp
                            )
                        }
                    }
                }
            }
        }
    }
}