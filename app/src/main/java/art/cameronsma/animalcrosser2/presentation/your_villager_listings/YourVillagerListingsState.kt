package art.cameronsma.animalcrosser2.presentation.your_villager_listings

import art.cameronsma.animalcrosser2.domain.model.VillagerListing

data class YourVillagerListingsState( // Villager object used in presentation layer
    val villagers: List<VillagerListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
