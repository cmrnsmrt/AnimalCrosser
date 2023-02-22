package art.cameronsma.animalcrosser2.data.csv

import art.cameronsma.animalcrosser2.domain.model.VillagerListing
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

// Parses the list output of the CSV parser then converts to object to be used in database
@Singleton
class VillagerListingsParser @Inject constructor(): CSVParser<VillagerListing> {

    override suspend fun parse(stream: InputStream): List<VillagerListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line ->
                    val id = line.getOrNull(0) // Maps lines into temporary variables
                    val name = line.getOrNull(1)
                    val personality = line.getOrNull(2)
                    val birthday = line.getOrNull(3)
                    val species = line.getOrNull(4)
                    val gender = line.getOrNull(5)
                    val hobby = line.getOrNull(6)
                    val catchphrase = line.getOrNull(7)
                    val image = line.getOrNull(8)
                    val bubbleCol = line.getOrNull(9)
                    val textCol = line.getOrNull(10)
                    val saying = line.getOrNull(11)
                    VillagerListing(
                        id = id ?: return@mapNotNull null, // Maps lines into VillagerListing object
                        name = name ?: return@mapNotNull null,
                        personality = personality ?: return@mapNotNull null,
                        birthday = birthday ?: return@mapNotNull null,
                        species = species ?: return@mapNotNull null,
                        gender = gender ?: return@mapNotNull null,
                        hobby = hobby ?: return@mapNotNull null,
                        catchphrase = catchphrase ?: return@mapNotNull null,
                        image = image ?: return@mapNotNull null,
                        bubbleCol = bubbleCol ?: return@mapNotNull null,
                        textCol = textCol ?: return@mapNotNull null,
                        saying = saying ?: return@mapNotNull null,
                        lastSpokenTo = "",
                        inVillage = ""
                    )
                }
                .also{
                    csvReader.close() // Close CSV reader
                }
        }
    }
}