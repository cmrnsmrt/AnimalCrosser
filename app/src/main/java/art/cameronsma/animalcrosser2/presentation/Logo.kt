package art.cameronsma.animalcrosser2.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import art.cameronsma.animalcrosser2.R


// Function to load up logo image
@Composable
fun Logo() {
    val image: Painter = painterResource(id = R.drawable.logo)
    Image(painter = image,contentDescription = "")
}