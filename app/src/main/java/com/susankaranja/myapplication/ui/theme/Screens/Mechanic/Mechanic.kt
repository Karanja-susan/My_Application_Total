package com.susankaranja.myapplication.ui.theme.Screens.Mechanic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Navigation.ROUTE_MPESA

@Composable
fun MechanicScreen(navController: NavController) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var description by remember { mutableStateOf(TextFieldValue("")) }
        var location by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(value =location, onValueChange = {location=it},
            label = { Text(text = "State/pin your location" )},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(value =description, onValueChange = {description=it},
            label = { Text(text = "Describe your problem(the problem with your car and whatever you may need e.g new tire" )},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Button(onClick = {
//            val loginpage = AuthViewModel(navController, context).apply {
//                login(email.text.trim(),pass.text.trim())
            navController.navigate(ROUTE_MPESA)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Submit")
        }

    }
}

@Preview
@Composable
private fun Mechanicprev() {
    MechanicScreen(rememberNavController())
}