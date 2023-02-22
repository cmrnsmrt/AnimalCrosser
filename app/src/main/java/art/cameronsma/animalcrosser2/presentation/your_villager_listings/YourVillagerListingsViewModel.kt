package art.cameronsma.animalcrosser2.presentation.your_villager_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import art.cameronsma.animalcrosser2.domain.repository.VillagerRepository
import art.cameronsma.animalcrosser2.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YourVillagerListingsViewModel @Inject constructor(
    private val repository: VillagerRepository
): ViewModel() {
    var state by mutableStateOf(YourVillagerListingsState())

    private var searchJob: Job? = null

    init{
        getYourVillagerListings(fetchFromRemote = false) // Gets villager data from local database on load
        // DEBUGGING: ABOVE CAN BE CHANGED TO TRUE TO FORCE DATA TO RELOAD FROM API
    }

    fun onEvent(event: YourVillagerListingsEvent) {
        when(event) {
            is YourVillagerListingsEvent.Refresh -> { // On refresh reload data
                getYourVillagerListings(fetchFromRemote = false)

            }
            is YourVillagerListingsEvent.OnSearchQueryChange -> { // On search query changing reload data matching search term
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L) // Wait until search term hasn't been changed for half a second to stop too many updates
                    getYourVillagerListings(fetchFromRemote = false)
                }
            }

        }
    }

    fun setLastSpoken( // Function to set last spoken to as current date time
        date: String,
        id: String
    ){
        viewModelScope.launch{
            repository
                .setLastSpoken(date, id)
        }
    }

    fun removeFromVillage( // Function to remove villager from village
        id: String
    ){
        viewModelScope.launch{
            repository
                .removeFromVillage(id)
        }
    }

    private fun getYourVillagerListings( // Get village with id
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    ){
        viewModelScope.launch {
            repository
                .getVillagerListings(fetchFromRemote, query) // Requests data
                .collect { result ->
                    when(result) {
                        is Resource.Success -> { // If loading is success get data
                            result.data?.let { listings ->
                                state = state.copy(
                                    villagers = listings // Outputs data
                                )
                            }
                        }
                        is Resource.Error -> Unit // If loading is error output unit
                        is Resource.Loading -> {  // If data is loading
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }

    }

}