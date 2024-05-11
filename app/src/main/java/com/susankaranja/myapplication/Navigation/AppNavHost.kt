package com.susankaranja.myapplication.Navigation

//import com.susankaranja.myapplication.HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.susankaranja.loginregform.MyIndexList
import com.susankaranja.myapplication.ui.theme.Screens.Home.HomeScreen
import com.susankaranja.myapplication.ui.theme.Screens.Login.LoginScreen
import com.susankaranja.myapplication.ui.theme.Screens.Mechanic.MechanicScreen
import com.susankaranja.myapplication.ui.theme.Screens.Mpesa.MpesaScreen
import com.susankaranja.myapplication.ui.theme.Screens.Order.OrderScreen
import com.susankaranja.myapplication.ui.theme.Screens.Registration.RegisterScreen
import com.susankaranja.myapplication.ui.theme.Screens.Splash.SplashScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASHSCREEN) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController )

        }
        composable(ROUTE_ORDER){
            OrderScreen(navController)

        }
        composable(ROUTE_MECHANIC){
            MechanicScreen(navController)

        }
        composable(ROUTE_MPESA){
            MpesaScreen(navController)

        }
        composable(ROUTE_SPLASHSCREEN){
            SplashScreen(navController)
        }
        composable(ROUTE_INDEX){
            MyIndexList(navController)
        }
    }
}

//@Composable
//fun LoginScreen(navController: NavHostController) {
//
//}