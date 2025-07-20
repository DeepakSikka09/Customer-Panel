package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.navigation.popTo
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.utils.constants.text
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ReturnScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    var commentText by remember { mutableStateOf("") }
    val isSubmitButtonEnabled = commentText.isNotBlank()
    val commentHint = "Enter Comment"
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))
    }
    Scaffold(
        topBar = {
            TextToolbar(
                title = "Return",
                navController = navController,
                false,
                awbNo = null,
                awbNoHeading = null
            )

        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(color = white),
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color.White)
                ) {
                    AwbOrderIdColum()
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                            .fillMaxWidth()
                            .background(color = whiteFF)
                    )
                    Column {
                        Text(
                            text = "Comment Reattempt Shipment ",
                            style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1A1A1A),
                        ),
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp),
                        )
                        TextField(
                            value = commentText,
                            onValueChange = { newValue ->
                                commentText = newValue
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = white,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            placeholder = { Text(text = "Enter Comment") },
                            textStyle = text(greyB7),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(104.dp).padding(start = 20.dp, end = 20.dp, top = 10.dp)
                                .border(
                                    width = 1.dp,
                                    color = grey1CD,
                                    shape = RoundedCornerShape(size = 4.dp)
                                )
                                .background(color = Color.White)
                        )

                    }

                    Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )


            }}

        }, bottomBar = {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color(0xFFFFFFFF))
            ) {
                Spacer(
                    modifier = Modifier
                        .background(color = blue0f8)
                        .fillMaxWidth()
                        .height(0.5.dp)
                        .background(color = grey8B8)
                )
                SearchButton(
                    text = "Submit",
                    imageId = null,
                    function = {navController.popTo(ScreenEnum.Home.name,false)},
                    enabled = isSubmitButtonEnabled,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
                    )

                )
            }
        })

}

@Composable
fun AwbOrderIdColum() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFFFFFFFF))
            .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
    ) {

        // Child views.
        Text(
            text = "AWB: 3170222927",
            style = TextStyle(
                fontSize = 21.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
            )
        )
        Text(
            text = "Order Id: AA58345678",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A),
            )
        )


    }
}

@Preview
@Composable
fun ReturnUi() {
    ReturnScreen(navController = rememberNavController())
}

