package art.cameronsma.animalcrosser2.data.repository

import art.cameronsma.animalcrosser2.data.csv.CSVParser
import art.cameronsma.animalcrosser2.data.local.VillagerDatabase
import art.cameronsma.animalcrosser2.data.mapper.toVillagerListing
import art.cameronsma.animalcrosser2.data.mapper.toVillagerListingEntity
import art.cameronsma.animalcrosser2.data.remote.VillagerApi
import art.cameronsma.animalcrosser2.domain.model.VillagerListing
import art.cameronsma.animalcrosser2.domain.repository.VillagerRepository
import art.cameronsma.animalcrosser2.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

// Implements repository functions by using database and API
@Singleton
class VillagerRepositoryImpl @Inject constructor(
    private val api: VillagerApi, // Villager API object
    private val db: VillagerDatabase, // Villager database object
    private val villagerListingsParser: CSVParser<VillagerListing>,
): VillagerRepository { // Returns repository object

    private val dao = db.dao

    override suspend fun setLastSpoken( // Function to set last time spoken to for specific id
        date: String,
        id: String
    ){
        dao.updateLastSpoken(date, id) // Calls update function used in view models
    }

    override suspend fun addToVillage( // Function mark villager as member of village for specific id
        id: String
    ){
        dao.addToVillage(id) // Call update function used in view models
    }

    override suspend fun removeFromVillage( // Function to remove villager from village for specific id
        id: String
    ){
        dao.removeFromVillage(id) // Calls update function used in view models
    }

    override suspend fun getVillagerListings( // Function to return villager listing of specific id
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<VillagerListing>>> { // Returns data flow for list of database objects
        return flow {
            emit(Resource.Loading(true)) // Tells resource object to load data remotely from Api
            val localListing = dao.searchVillagerListing(query)
            emit(Resource.Success( // Tells resource object that data load is successful
                data = localListing.map { it.toVillagerListing() }
            ))

            val isDbEmpty = localListing.isEmpty() && query.isBlank() // Is database empty check
            val shouldJusLoadFromCache = !isDbEmpty && !fetchFromRemote // Id data is not to be loaded remotely and database is empty
            if(shouldJusLoadFromCache) {
                emit(Resource.Loading(false)) // Tells resource object to load data locally from database
                return@flow // Returns data to flow
            }
            val remoteListings = try {
                val response = api.getListings() // Gets data from API
                villagerListingsParser.parse(response.byteStream()) // Parses data from response body
            } catch(e: IOException) { // Exception catcher
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data")) // Tells resource object error occurred
                null // returns null
            } catch (e: HttpException){ // Exception catcher
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data")) // Tells resource object error occurred
                null // returns null
            }

            remoteListings?.let { listings -> // Puts data loaded from remote API into local database
                dao.clearVillagerListings() // Clear entry from database
                dao.insertVillagerListings( // Inserts entry to database
                    listings.map { it.toVillagerListingEntity() }
                )
                emit(Resource.Loading(false)) // Tells resource object to load data locally from database
                emit(Resource.Success( // Tells resource object data load was successful
                    data = dao
                        .searchVillagerListing("")
                        .map { it.toVillagerListing()}
                ))
            }
        }
    }
}