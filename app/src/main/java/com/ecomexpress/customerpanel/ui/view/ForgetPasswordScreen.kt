package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.CustomTextField
import com.ecomexpress.customerpanel.components.LogInButton
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.ui.theme.blue408f
import com.ecomexpress.customerpanel.ui.theme.blueBF8
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.ui.viewModel.ForgetPasswordViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ForgetPasswordComposable(navController: NavHostController,viewModel: ForgetPasswordViewModel)
{
    val username by viewModel.username.collectAsState()

    val lifecycleOwner = LocalLifecycleOwner.current
    var moveToNextScreen by remember{
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = moveToNextScreen, block ={
        if (moveToNextScreen){

            lifecycleOwner.lifecycleScope.launch {

                navController.navigate(ScreenEnum.VerifyResendScreen.name)

                delay(3000)

                navController.navigate(ScreenEnum.ChangePassword.name){
                    popUpTo(ScreenEnum.VerifyResendScreen.name) {
                        inclusive = true
                    }
                }
            }

        }
    } )
    Scaffold(topBar = {
        TextToolbar(title = "", navController=navController,false,null,null)

    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
                .background(color = white)
                .fillMaxWidth()
        ){
            Text(
                text = "Forget Password",
                style = TextStyle(
                    fontSize = 21.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1A1A1A),

                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(top = 15.dp)
            )
            Text(
                text = "Enter your username or email address and we will send you instructions on how to create a new password.",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1A1A1A),
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp, bottom = 30.dp)
            )
          CustomTextField(
        data = username,
        onChange = {viewModel.setUsername(it)},
        keyBoardType = KeyboardType.Text ,
        isError = false,
        labelText ="Enter Username Or Email" ,
        visualTransformation = VisualTransformation.None
    )
     Spacer(modifier = Modifier.height(25.dp).fillMaxWidth())

            SearchButton(
                function = { moveToNextScreen=true },
                text = "Submit",
                imageId = null,
                modifier = Modifier,
                enabled = username.length>5
            )

    Row(modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(top = 15.dp)
            .align(alignment = Alignment.CenterHorizontally)
    ){
        Text(text = "Back to ",
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight(400),
            color = Color(0xFF1A1A1A),
        )
        )
        Text(text = "Login",
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = blueBF8,
            ),
            modifier = Modifier.clickable {
                navController.navigate(ScreenEnum.Login.name)
            }
        )
    }
        }
    })


}

@Preview
@Composable
fun ShowForgetPassword(){
    ForgetPasswordComposable(navController = rememberNavController(), ForgetPasswordViewModel())
}