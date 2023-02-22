package art.cameronsma.animalcrosser2.data.mapper

import art.cameronsma.animalcrosser2.data.local.VillagerListingEntity
import art.cameronsma.animalcrosser2.domain.model.VillagerListing

// Functions used to transfer data from model object to database object
fun VillagerListingEntity.toVillagerListing(): VillagerListing{
    return VillagerListing(
        id = id,
        name = name,
        personality = personality,
        birthday = birthday,
        species = species,
        gender = gender,
        hobby = hobby,
        catchphrase = catchphrase,
        image = image,
        bubbleCol = bubbleCol,
        textCol = textCol,
        saying = saying,
        lastSpokenTo = lastSpokenTo,
        inVillage = inVillage
    )
}

// Functions used to transfer data from database object to model object
fun VillagerListing.toVillagerListingEntity(): VillagerListingEntity{
    return VillagerListingEntity(
        id = id,
        name = name,
        personality = personality,
        birthday = birthday,
        species = species,
        gender = gender,
        hobby = hobby,
        catchphrase = catchphrase,
        image = image,
        bubbleCol = bubbleCol,
        textCol = textCol,
        saying = saying,
        lastSpokenTo = lastSpokenTo,
        inVillage = inVillage
    )
}


