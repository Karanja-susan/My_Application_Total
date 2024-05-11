package com.susankaranja.myapplication.ui.theme.Screens.Registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Data.AuthViewModel
//import com.susankaranja.firebase.Data.AuthViewModel
import com.susankaranja.myapplication.Navigation.ROUTE_REGISTER

@Composable
fun RegisterScreen(navController: NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var carreg by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Register and Become Member",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =name , onValueChange ={name =it},
            label = { Text(text = "Enter full Names")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email") },

            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =phone , onValueChange ={phone=it},
            label = { Text(text = "Enter Phone Number(valid)") },
            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =carreg , onValueChange ={carreg=it},
            label = { Text(text = "Enter Car Registration Number(number plate)") },
            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =confirmpass , onValueChange = {
            confirmpass=it},
            label = { Text(text = "Enter Confirm Password") },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())




        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(20.dp))

//        Button(onClick = {
//            navController.navigate(ROUTE_REGISTER)
//        }, modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Have an Account? Click to Login")
//        }
        Text(text = "have an account?" +
                "                  click to login",
            modifier = Modifier
                .clickable {navController.navigate(ROUTE_REGISTER) })


    }



}

@Preview
@Composable
fun register() {
    RegisterScreen(rememberNavController())

}