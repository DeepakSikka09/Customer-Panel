package com.ecomexpress.customerpanel.ui.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.viewModel.LogInScreenViewModel
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.text

@Composable
fun VerifyScreen(navController: NavController?) {
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(Color.White)  // Replace with your desired color
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white),
            contentAlignment = Alignment.Center

    ) {


        Column(
            Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.charm_tick),
                contentDescription = "Logo",
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
                Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Password reset successful!",
                        style = heading(black1A, 21.sp)

                    )
                    Text(
                        text = "You can now use your new password to login to your account!",
                        style = text(black1A, 18.sp),
                        textAlign = TextAlign.Center

                    )

        }


        Column(
            Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            LogInButton(function = {

                navController?.navigate(ScreenEnum.Login.name)

            }, "Login")


        }

    }
}


@Composable
@Preview
fun VerifyPreview() {
    VerifyScreen(navController = null)
}

