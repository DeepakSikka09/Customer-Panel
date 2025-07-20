package com.ecomexpress.customerpanel.ui.view



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

@Composable
fun LogInScreen(navController: NavController?, viewModel: LogInScreenViewModel) {
    // Collect the username and password Flows
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val systemUiController = rememberSystemUiController()
    var visualTransformation by remember {
        mutableStateOf(VisualTransformation.None)
    }
    var isEyeClicked by remember {
        mutableStateOf(false)
    }
    var isValid by remember {
        mutableStateOf(true)
    }
    val context = LocalContext.current
    val colorStops = listOf(
        Color.White,
        Color(color = 0xFFE9F1FF),


         )

    val brush = Brush.verticalGradient(colors = colorStops)

    SideEffect {
        systemUiController.setStatusBarColor(Color.White)  // Replace with your desired color
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(start = 40.dp, top = 40.dp, bottom = 30.dp)
        )
        if (!isValid){
            ValidationMessage(true)
        }else{
            ValidationMessage(false)
        }
        Column(
            Modifier
                .padding(top=30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),verticalArrangement = Arrangement.Center) {
            CustomTextField(
                data = username,
                onChange = { viewModel.setUsername(it) },
                keyBoardType = KeyboardType.Text,
                isError = false,
                labelText = "Enter user id",
                visualTransformation = VisualTransformation.None
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomTextField(data = password, onChange = {viewModel.setPassword(it)}, keyBoardType = KeyboardType.Text, isError =false , labelText ="Enter password" , visualTransformation = if (isEyeClicked) VisualTransformation.None else PasswordVisualTransformation(mask = '*'), isIcon = true, iconId = R.drawable.eye,iconClicked={
                isEyeClicked=!isEyeClicked
            })
            Spacer(modifier = Modifier.height(15.dp))
            ForgotPasswordText(navController)

            Spacer(modifier = Modifier.height(15.dp))
            LogInButton(function = {
                if (username.length>5){
                    isValid=true
                    navController?.navigate(ScreenEnum.Home.name)
                }else{
                    isValid=false
                }
            }, "Login")
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "New to Ecom Express?",
                    color = grey4F
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Sign Up Now",
                    color = blueE0,
                    modifier = Modifier.padding(start = 4.dp),
                    style = subheading(greyFF, 16.sp),
                    textDecoration = TextDecoration.Underline
                )

            }

        }

    }
}


@Composable
fun ForgotPasswordText(navController: NavController?) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding()
        ) {
            Text(
                text = "Forgot Password?",
                style = subheading(blueE0, 16.sp), textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController?.navigate(ScreenEnum.ForgotPassword.name)

                }

            )
        }
    }
}

@Composable
fun ValidationMessage(showData:Boolean){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .padding(start = 20.dp, end = 20.dp)) {
        if (showData){
            Image(painter = painterResource(id = R.drawable.warning_icon), contentDescription ="" )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "You are not registered with us. Enter\ncorrect username or click on sign up now",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1A1A1A),
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

        }



    }
}

@Composable
@Preview
fun preview(){
    LogInScreen(navController = null, viewModel = LogInScreenViewModel())
}

