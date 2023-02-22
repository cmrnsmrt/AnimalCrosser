package art.cameronsma.animalcrosser2.presentation.your_villager_listings

sealed class YourVillagerListingsEvent {
    object Refresh: YourVillagerListingsEvent()
    data class OnSearchQueryChange(val query: String): YourVillagerListingsEvent()
}
