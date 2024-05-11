package com.susankaranja.myapplication.ui.theme.Screens.Splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.susankaranja.myapplication.Navigation.ROUTE_HOME
import com.susankaranja.myapplication.R
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue =0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing ={
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.total),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(30.dp)
                .padding(20.dp)
        )

    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    SplashScreen(rememberNavController())
}



