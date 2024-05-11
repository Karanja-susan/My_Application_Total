package com.susankaranja.myapplication.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Data.AuthViewModel
import com.susankaranja.myapplication.Navigation.ROUTE_INDEX
import com.susankaranja.myapplication.Navigation.ROUTE_REGISTER
import com.susankaranja.myapplication.R

@Composable
fun HomeScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Box {


            Image(
                painter = painterResource(id = R.drawable.totalstation),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Welcome to Total Energies App",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Magenta,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(30.dp))

//                Button(onClick = {
//                    val loginpage=AuthViewModel(navController,context)
//                    loginpage.login(email.text.trim(),pass.text.trim())
//                    navController.navigate(ROUTE_INDEX)
//
//                }) {
//                    Text(text = "Login")
//                }
                Text(text = "login",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable {
                            AuthViewModel(navController, context).apply {
                            }
                            val loginpage = AuthViewModel(navController, context)
                            loginpage.login(email.text.trim(), pass.text.trim())
                            navController.navigate(ROUTE_INDEX)
                        }
                        .align(AbsoluteAlignment.Right))


//                Spacer(modifier = Modifier.height(30.dp))

//                Button(onClick = {
//                    AuthViewModel(navController, context).apply {
//                        signup(email.text.trim(), pass.text.trim(), confpass = String())
//                        navController.navigate(ROUTE_REGISTER)
//
//                    }
//                }) {
//                    Text(text = "Sign Up")
//                }
                Text(text = "Sign Up",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable {
                            AuthViewModel(navController, context).apply {
                                signup(email.text.trim(), pass.text.trim(), confpass = String())
                                navController.navigate(ROUTE_REGISTER)
                            }
                        }
                        .align(AbsoluteAlignment.Left))

                Spacer(modifier = Modifier.height(35.dp))

//                Text(
//                    text = "sign up",
//                    color = Color.Yellow,
//                    textAlign = TextAlign.Center,
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier
//                        .clickable {
//                        AuthViewModel(navController, context).apply {
//                            login(email.text.trim(), pass.text.trim())
//                            navController.navigate(ROUTE_REGISTER)
//                        }
//                    }
//                )

                Spacer(modifier = Modifier.height(40.dp))

//                Text(
//                    text = "Login",
//                    color = Color.Yellow,
//                    textAlign = TextAlign.Center,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 15.sp,
//                    modifier = Modifier.clickable {
//                        AuthViewModel(navController, context).apply {
//                            login(email.text.trim(), pass.text.trim())
//                            navController.navigate(ROUTE_LOGIN)
//                        }
//                    }
//                )
                Spacer(modifier = Modifier
                    .height(25.dp)
                    .padding(25.dp))
                Text(
                    text = "We are one world's top best energy and gas station",
                    color = Color.Yellow,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier
                        .padding(5.dp)
                )


                Text(
                    text = "Register now to get a loyalty card and earn points",
                    color = Color.Yellow,
                    fontFamily = FontFamily.Default,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(5.dp)
                )

                Text(
                    text = "Get up-to-date of fuel prices including offers and discounts available",
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Yellow,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(5.dp)
                )



























            }


        }



    }
}

@Preview
@Composable
private fun HomeScreenprev() {
    HomeScreen(rememberNavController())
}
