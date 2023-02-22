package art.cameronsma.animalcrosser2.domain.repository

import art.cameronsma.animalcrosser2.domain.model.VillagerListing
import art.cameronsma.animalcrosser2.util.Resource
import kotlinx.coroutines.flow.Flow

interface VillagerRepository { // Domain repository interface

    suspend fun getVillagerListings( // Connected to data by repository module
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<VillagerListing>>>

    suspend fun addToVillage( // Connected to data by repository module
        id: String
    )

    suspend fun setLastSpoken( // Connected to data by repository module
        date: String,
        id: String
    )

    suspend fun removeFromVillage( // Connected to data by repository module
        id: String
    )
}