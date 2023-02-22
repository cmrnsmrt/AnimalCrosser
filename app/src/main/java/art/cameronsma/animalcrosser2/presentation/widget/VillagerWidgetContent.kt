package art.cameronsma.animalcrosser2.presentation.widget

import androidx.compose.runtime.Composable
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import art.cameronsma.animalcrosser2.R

// Overall content
@Composable
fun VillagerWidgetContent(
    modifier: GlanceModifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VillagerWidgetLayout(
            modifier = GlanceModifier
                .fillMaxSize()
                .defaultWeight()
        )
    }
}

// Layout
@Composable
fun VillagerWidgetLayout(
    modifier: GlanceModifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Images of villagers loaded into Res
        Image(
            provider = ImageProvider(
                resId = R.drawable.img1
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.img2
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.img3
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            provider = ImageProvider(
                resId = R.drawable.img4
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.img5
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.img6
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .defaultWeight()
        )
    }
}