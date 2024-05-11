package com.susankaranja.myapplication.ui.theme.Screens.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Data.AuthViewModel
import com.susankaranja.myapplication.Navigation.ROUTE_INDEX
import com.susankaranja.myapplication.Navigation.ROUTE_REGISTER

@Composable
fun LoginScreen(navController: NavController) {
   var email by remember { mutableStateOf(TextFieldValue("")) }
   var pass by remember { mutableStateOf(TextFieldValue("")) }
   var context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Login here",
            color = Color.Magenta,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(value =email, onValueChange = {email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Create, contentDescription = "")},
            label = { Text(text = "Enter Email Address",
                color = Color.Black
            ) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =pass , onValueChange = {pass=it},
            leadingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "pass")},
            label = { Text(text = "Enter Password",
                color = Color.Black) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_INDEX)
            val loginpage = AuthViewModel(navController, context).apply {
                login(email.text.trim(),pass.text.trim())
            }
        }, modifier = Modifier
            .fillMaxWidth()
            ,
            )
        {
            navController.navigate(ROUTE_INDEX)
            Text(text = "login",
                color = Color.Cyan,


            )
        }
        Text(text = "Don't have an account?"+
                " Click to register",
            modifier = Modifier
                .clickable {navController.navigate(ROUTE_REGISTER)},
            textAlign = TextAlign.Left)
    }
}

@Preview
@Composable
private fun Loginpage() {
    LoginScreen(rememberNavController())
}