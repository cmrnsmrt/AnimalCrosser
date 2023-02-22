package art.cameronsma.animalcrosser2.di

import android.app.Application
import androidx.room.Room
import art.cameronsma.animalcrosser2.data.local.VillagerDatabase
import art.cameronsma.animalcrosser2.data.remote.VillagerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

// Data insertion

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVillagerApi(): VillagerApi { // Inserts villager API retrofit builder into villager API
        return Retrofit.Builder()
            .baseUrl(VillagerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesVillagerDatabase(app: Application): VillagerDatabase { // Inserts room database builder into database object
        return Room.databaseBuilder(
            app,
            VillagerDatabase::class.java,
            "villagerdb.db"
        ).build()
    }
}