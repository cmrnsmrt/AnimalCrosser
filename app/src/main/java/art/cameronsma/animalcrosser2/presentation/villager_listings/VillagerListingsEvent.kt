package art.cameronsma.animalcrosser2.presentation.villager_listings

sealed class VillagerListingsEvent {
    object Refresh: VillagerListingsEvent()
    data class OnSearchQueryChange(val query: String): VillagerListingsEvent()
}
