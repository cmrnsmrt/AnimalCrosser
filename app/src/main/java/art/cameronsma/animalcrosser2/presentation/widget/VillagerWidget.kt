package art.cameronsma.animalcrosser2.presentation.widget

import androidx.compose.runtime.Composable
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.background
import androidx.glance.layout.fillMaxSize
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import art.cameronsma.animalcrosser2.ui.theme.graySurface
import art.cameronsma.animalcrosser2.ui.theme.mintGreen

// Class for widget that displays pictures of villager in your village

class VillagerWidget : GlanceAppWidget() {

    override var stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    // Uses android glance library

    @Composable
    override fun Content() {
        VillagerWidgetContent(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(
                    day = mintGreen,
                    night = graySurface
                )
                .appWidgetBackground()
        )
    }
}

class VillagerWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = VillagerWidget()
}

