package com.ecomexpress.customerpanel.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.viewModel.PinCodeViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.grey296
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.white

@Composable
fun PinCodeScreen(navController: NavController, viewModel: PinCodeViewModel) {
    val searchText by viewModel.searchText.collectAsState()
    val systemUiController = rememberSystemUiController()
    var showEnable by remember {
        mutableStateOf(false)
    }
    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))  // Replace with your desired color
    }

    Scaffold(
        topBar = {
            TextToolbar(
                title = "PinCode Coverage",
                navController = navController,
                false,
                null,
                null
            )

        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(white),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(white)
                            .padding(20.dp)
                    ) {


                        CustomTextField(
                            data = searchText,
                            onChange = {viewModel.setSearchText(it)},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "Enter Pincode & City",
                            visualTransformation = VisualTransformation.None,
                            isIcon = true, iconId = R.drawable.ic_input_cross
                        )

                    Spacer(modifier = Modifier.height(15.dp))
                    SearchButton(
                        function = { showEnable=true },
                        text = "Search",
                        imageId = null,
                        modifier = Modifier,
                        enabled = searchText.length == 6
                    )
                }

                    showPincode(showEnable)



                }
            }
        }
    )
}

@Composable
fun showPincode(enabled:Boolean)
{
   if (enabled)
   {
    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp) .background(grey6FF))
    PinCodeCard()

    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp) .background(grey6FF))
    PinCodeDelivery("Pickup: ","Yes")
    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp) .background(grey6FF))
    PinCodeDelivery("Delivery: ","Yes")
    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp) .background(grey6FF))
    PinCodeDelivery("Return: ","Yes")
   }
}

@Preview
@Composable
fun PinCodePreview()
{
    PinCodeScreen(navController = rememberNavController(), viewModel = viewModel())
}




