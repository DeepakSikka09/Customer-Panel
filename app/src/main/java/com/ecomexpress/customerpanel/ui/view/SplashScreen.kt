package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.viewModel.SplashScreenViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

/* Note:
* The LaunchedEffect is a Composable function that allows side effects to be performed once when the composable is first displayed. In this case, it creates a coroutine that waits for 3000 milliseconds (3 seconds) using the delay function and then navigates to the login screen by calling navController.navigate(Screen.LogInScreen.route).*/

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashScreenViewModel) {
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(Color.White)  // Replace with your desired color
    }
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(ScreenEnum.Login.name){
            popUpTo(ScreenEnum.SplashScreen.name){
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen_bg1),
            contentDescription = null,
            Modifier.align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.splash_screen_bg2),
            contentDescription = null,
            Modifier.align(Alignment.BottomStart)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}


