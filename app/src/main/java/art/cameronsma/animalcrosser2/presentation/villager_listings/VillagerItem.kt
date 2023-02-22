package art.cameronsma.animalcrosser2.presentation.villager_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import art.cameronsma.animalcrosser2.domain.model.VillagerListing
import coil.compose.rememberAsyncImagePainter

@Composable
fun VillagerItem( // Called whenever a villagers detail is displayed
    villager: VillagerListing, // Takes villager data object as input
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f) // Full width
        ) {
            Text( // Name
                text = villager.name,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image( // Villager image
                    painter = rememberAsyncImagePainter(villager.image), // Pulled from url provided by API data
                    contentDescription = null,
                    modifier = Modifier
                        .size(140.dp)
                        .border(width = 4.dp, color = Color(villager.bubbleCol.toColorInt()), shape = RoundedCornerShape(40.dp)) // Creates rounded border
                        .clip(RoundedCornerShape(40.dp)) // Rounds corners of image
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text( // Birthday
                        text = "Birthday: ${villager.birthday}",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text( // Gender
                        text = "Gender: ${villager.gender}",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text( // Species
                        text = "Species: ${villager.species}",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text( // Personality
                        text = "Personality: ${villager.personality}",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text( // Hobby
                        text = "Hobby: ${villager.hobby}",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text( // Catchphrase
                        text = "Catchphrase: '${villager.catchphrase}'",
                        fontStyle = FontStyle.Normal,
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}