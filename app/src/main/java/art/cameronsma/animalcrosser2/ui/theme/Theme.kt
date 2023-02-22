package art.cameronsma.animalcrosser2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = graySurface
)

private val LightColorPalette = lightColors(
    primary = darkGoldenrod,
    primaryVariant = darkGoldenrod,
    secondary = icterine,
    surface = electricBlue,
    background = electricBlue,

    )

@Composable
fun AnimalCrosser2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Sets as dark theme if system is in dark mode
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}