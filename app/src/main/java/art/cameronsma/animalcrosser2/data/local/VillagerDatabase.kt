package art.cameronsma.animalcrosser2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// Creates database entity
@Database(
    entities = [VillagerListingEntity::class],
    version = 1
)

abstract class VillagerDatabase: RoomDatabase() {
    abstract val dao: VillagerDao
}