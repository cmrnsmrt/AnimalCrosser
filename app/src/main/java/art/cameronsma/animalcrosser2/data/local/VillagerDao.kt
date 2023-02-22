package art.cameronsma.animalcrosser2.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Database interface object
// Uses android room to use mySQL statements
@Dao
interface VillagerDao {

    // Insert into database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVillagerListings(
        villagerListingEntity: List<VillagerListingEntity>
    )

    // Delete from database
    @Query("DELETE FROM villagerlistingentity")
    suspend fun clearVillagerListings()

    // Select from database where id is equal to input
    @Query(
        """
            SELECT *
            FROM villagerlistingentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == id
        """
    )
    suspend fun searchVillagerListing(query: String): List<VillagerListingEntity>

    // Select from database where id is equal to input
    @Query(
        """
            SELECT *
            FROM villagerlistingentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == id 
        """
    )
    suspend fun searchYourVillagerListing(query: String): List<VillagerListingEntity>

    // Mark as in users village where id is equal to input
    @Query(
        """
            UPDATE villagerlistingentity
            SET inVillage = 'TRUE'
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == id
        """
    )
    suspend fun addToVillage(query: String)

    // Mark as not in users village where id is equal to input
    @Query(
        """
            UPDATE villagerlistingentity
            SET inVillage = 'FALSE'
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == id
        """
    )
    suspend fun removeFromVillage(query: String)

    // Updates time last spoken to where id is equal to input
    @Query(
        """
            UPDATE villagerlistingentity
            SET lastSpokenTo = :date
            WHERE UPPER(:id) == id
        """
    )
    suspend fun updateLastSpoken(date: String, id: String)
}

