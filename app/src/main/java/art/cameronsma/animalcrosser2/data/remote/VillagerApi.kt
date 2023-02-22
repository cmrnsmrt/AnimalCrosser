package art.cameronsma.animalcrosser2.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface VillagerApi {

    // gets villagers from provided API module
    @GET("villagers")
    suspend fun getListings(): ResponseBody

    companion object {
        const val BASE_URL = "https://mayar.abertay.ac.uk/~1901578/villagers/"
    }

}