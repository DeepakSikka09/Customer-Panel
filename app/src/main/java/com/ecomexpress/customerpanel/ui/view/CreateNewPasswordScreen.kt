package com.ecomexpress.customerpanel.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.CustomTextField
import com.ecomexpress.customerpanel.components.LogInButton
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.ui.theme.blueBF8
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.ui.viewModel.ChangePasswordViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable
fun NewPasswordComposable(navController: NavHostController,viewModel: ChangePasswordViewModel)
{
    val newPassword by viewModel.newPassword.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()
    val visualTransformation  by remember {
        mutableStateOf(VisualTransformation.None)
    }

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
                text = "Create new password",
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
                text = "Password should be at least of 8 characters, should contain uppercase, number and special character.",
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
                data = newPassword,
                onChange = {viewModel.setNewPassword(it)},
                keyBoardType = KeyboardType.Text ,
                isError = false,
                labelText ="New Password" ,
                visualTransformation = PasswordVisualTransformation(mask = '*'),
                isIcon = true, iconId = R.drawable.eye
            )
            Spacer(modifier = Modifier
                .height(10.dp)
                .fillMaxWidth())
            CustomTextField(
                data = confirmPassword,
                onChange = {viewModel.setConfirmPassword(it)},
                keyBoardType = KeyboardType.Text ,
                isError = false,
                labelText ="Confirm Password" ,
                visualTransformation = PasswordVisualTransformation(mask = '*'),
                isIcon = true, iconId = R.drawable.eye
            )
            Spacer(modifier = Modifier
                .height(25.dp)
                .fillMaxWidth())

            SearchButton(
                function = {navController.navigate(ScreenEnum.VerifyScreen.name) },
                text = "Submit",
                imageId = null,
                modifier = Modifier,
                enabled = newPassword.length>7
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
fun NewPasswordComposable(){
    NewPasswordComposable( rememberNavController(), ChangePasswordViewModel())
}