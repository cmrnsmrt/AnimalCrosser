package uk.ac.abertay.cmp309.animalcrosser

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Welcome : NavRoutes("welcome")
    object Profile : NavRoutes("profile")
    object Villager : NavRoutes("villager")
}