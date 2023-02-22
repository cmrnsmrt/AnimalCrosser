package art.cameronsma.animalcrosser2.di

import art.cameronsma.animalcrosser2.data.csv.CSVParser
import art.cameronsma.animalcrosser2.data.csv.VillagerListingsParser
import art.cameronsma.animalcrosser2.data.repository.VillagerRepositoryImpl
import art.cameronsma.animalcrosser2.domain.model.VillagerListing
import art.cameronsma.animalcrosser2.domain.repository.VillagerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVillagerListingsParser( // Binds domain and data ends of database
        villagerListingsParser: VillagerListingsParser
    ): CSVParser<VillagerListing> // Returns Villager Listing database object

    @Binds
    @Singleton
    abstract fun bindsVillagerRepository( // Binds domain and data ends of repository
        villagerRepositoryImpl: VillagerRepositoryImpl
    ): VillagerRepository // Returns villager repository object
}