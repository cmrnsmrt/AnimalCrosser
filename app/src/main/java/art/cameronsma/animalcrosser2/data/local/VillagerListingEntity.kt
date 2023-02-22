package art.cameronsma.animalcrosser2.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey

// Villager listing entity object used to send data from data to model
@Entity
data class VillagerListingEntity(
    @PrimaryKey val id: String,
    val name: String,
    val personality: String,
    val birthday: String,
    val species: String,
    val gender: String,
    val hobby: String,
    val catchphrase: String,
    val image: String,
    val bubbleCol: String,
    val textCol: String,
    val saying: String,
    val lastSpokenTo: String,
    val inVillage: String
)

