package art.cameronsma.animalcrosser2.presentation.villager_listings

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

// Screen to show all available villagers from API
@Destination
@Composable
fun VillagerListingsScreen(
    navigator: DestinationsNavigator, // Used for navigation
    viewModel: VillagerListingsViewModel = hiltViewModel() // View model for page
) {
    val swipeRefreshState = rememberSwipeRefreshState( // Watches for swipe down to refresh
        isRefreshing = viewModel.state.isRefreshing // updates when refreshing
    )
    val state = viewModel.state // Takes state of view model
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField( // Search bar
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent( // When text in input field changes update page
                    VillagerListingsEvent.OnSearchQueryChange(it)
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
                    VillagerListingsEvent.Refresh
                )
            }
        ) {
            LazyColumn( // Column that allows scrolling through items
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.villagers.size) { i -> // Loops through villagers
                    val villager = state.villagers[i] // Villager set to current villager in loop
                    VillagerItem( // Displays current villager using villager item composable
                        villager = villager,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    Column (
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                            ){
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button( // Add to village button
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 5.dp),
                                onClick = {
                                    viewModel.addToVillage(villager.id) // Tells view model to perform add to village
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(villager.bubbleCol.toColorInt())) // Sets button colour to colour from database
                            ) {
                                Text(text = "Add to island", color = Color(villager.textCol.toColorInt())) // Sets text colour to colour from database
                            }
                            Button( // Remove from village button
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 5.dp),
                                onClick = {
                                    viewModel.removeFromVillage(villager.id) // Tells view model to perform remove from village
                                },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(villager.bubbleCol.toColorInt()) // Sets button colour to colour from database
                                )
                            ) {
                                Text(text = "Remove from island", color = Color(villager.textCol.toColorInt())) // Sets text colour to colour from database
                            }
                        }
                    }
                    if(i < state.villagers.size){ // Adds spacer between objects but not after final object
                        Spacer(modifier = Modifier.height(8.dp))
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