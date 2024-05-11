package com.susankaranja.loginregform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Data.AuthViewModel
import com.susankaranja.myapplication.Navigation.ROUTE_MECHANIC
import com.susankaranja.myapplication.Navigation.ROUTE_ORDER
import com.susankaranja.myapplication.R
import com.susankaranja.myapplication.ui.theme.MyApplicationTheme
import androidx.navigation.NavHostController as NavHostController1

class CustomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    MyIndexList(navController = rememberNavController())

                }
            }
        }
    }
}

data class CakesModel(val name:String, val image : Int)

@Composable
fun ListRow(model: CakesModel,navController:NavHostController1) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(
        modifier = Modifier
        .height(15.dp),
//        horizontalAlignment = AbsoluteAlignment.Right
    ) {
        Button(onClick = {
            val mechanicpage = AuthViewModel(navController, context).apply {
                mechanic(email.text.trim(), pass.text.trim())
            }
            navController.navigate(ROUTE_MECHANIC)
        }, modifier = Modifier.fillMaxSize()) {
            Text(text = "Ask for a Mechanic")


        }
        Spacer(modifier = Modifier
            .height(20.dp))
    Column(
         horizontalAlignment = AbsoluteAlignment.Left,
          modifier = Modifier
              .height(15.dp)
            ) {

                Button(onClick = {
                    val orderpage = AuthViewModel(navController, context).apply {
                        order(email.text.trim(), pass.text.trim())
                    }
                    navController.navigate(ROUTE_ORDER)
                }, modifier = Modifier.fillMaxSize()) {
                    Text(text = "Order Now")
                }
            }

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Cyan)
    ) {

        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Magenta
        )

        Button(
            onClick = {
                navController.navigate(ROUTE_MECHANIC)
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Bottom)
        ) {
            Text(text = "Ask for a mechanic")
        }
        Button(
            onClick = {
                navController.navigate(ROUTE_ORDER)
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Bottom)
        ) {
            Text(text = "Order")
        }

    }

}

val CakeList  = mutableListOf<CakesModel>().apply {
    add(CakesModel("Get all of our services at a touch of a button", R.drawable.total))
    add(CakesModel("Has your car broken down in the middle of the road?Don't worry,we've got you covered.You can now ask for a mechanic wherever you are whenever you need one.",R.drawable.totalmechanics))
    add(CakesModel("You can also book for your car services from your smartphone. ",R.drawable.mechanic))
    add(CakesModel("Run out of Cooking gas?Don't worry you can now order Total cooking gas anytime any place and will be delivered at your doorstep.",R.drawable.gasdelivery))
    add(CakesModel("Order Now at Fair prices",R.drawable.gas6kg))
    add(CakesModel("Order Now ata Fair Prices",R.drawable.gas13))
    add(CakesModel("Register now to earn points an get a loyalty card.You also get notifications of updates on cooking gas and fuel prices including discounts.",R.drawable.loyaltycard))
    add(CakesModel("Order for lubricants an acids now.",R.drawable.lubricant))
    add(CakesModel("Total Energies,WE'VE GOT YOU COVERED!",R.drawable.totallogo2))



}

@Composable
fun MyIndexList(navController: NavHostController1) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        items(CakeList) { model ->
            ListRow(model = model,navController)
        }
    }
}

@Preview
@Composable
fun CustomPrev() {
    MyIndexList(rememberNavController())
}