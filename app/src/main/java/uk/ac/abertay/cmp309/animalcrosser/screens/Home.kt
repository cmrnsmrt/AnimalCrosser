package uk.ac.abertay.cmp309.animalcrosser.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.abertay.cmp309.animalcrosser.NavRoutes
import uk.ac.abertay.cmp309.animalcrosser.R

@Composable
fun Home(navController: NavHostController) {

    var userName by remember { mutableStateOf("") }
    val onUserNameChange = { text : String ->
        userName = text
    }

    MaterialTheme{
        Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFFA7E78F)))

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                logo()

                CustomTextField(
                    title = "Enter your email address",
                    textState = userName,
                    onTextChange = onUserNameChange
                )

                Spacer(modifier = Modifier.size(30.dp))

                val password = remember { mutableStateOf(TextFieldValue())}

                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )

                Spacer(modifier = Modifier.size(30.dp))

                Button(onClick = {
                    navController.navigate(NavRoutes.Welcome.route + "/$userName" + "/$password")
                }) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Composable
fun logo() {
    val image: Painter = painterResource(id = R.drawable.logo)
    Image(painter = image,contentDescription = "")
}

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        label = { Text(title)},
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
    )
}
