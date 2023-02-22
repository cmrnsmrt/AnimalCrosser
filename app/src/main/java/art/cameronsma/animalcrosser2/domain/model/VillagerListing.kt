package art.cameronsma.animalcrosser2.domain.model

data class VillagerListing( // Object to be used by presentation
    val id: String,
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