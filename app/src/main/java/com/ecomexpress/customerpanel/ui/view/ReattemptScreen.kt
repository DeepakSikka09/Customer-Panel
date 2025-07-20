package com.ecomexpress.customerpanel.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.data.local.db.entities.listofOptionsItem
import com.ecomexpress.customerpanel.navigation.popTo
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.viewModel.ReattemptViewModel
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.constants.text
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Reattempt(navController: NavController, viewModel: ViewModel) {
    val selectedDateOptions = remember { mutableStateListOf<Int>() }

    val systemUiController = rememberSystemUiController()
    var commentText by remember { mutableStateOf("") }
    val isSubmitButtonEnabled = commentText.isNotBlank()
    val commentHint = "Enter Comment"
    SideEffect {
        systemUiController.setStatusBarColor(Color.White)
    }
    val span: (LazyGridItemSpanScope) -> GridItemSpan = { GridItemSpan(4) }


    Scaffold(
        topBar = {
            TextToolbar(
                title = "Reattempt",
                navController = navController,
                false,
                awbNo = null,
                awbNoHeading = null
            )
        },
        content = {
            LazyVerticalGrid(
                modifier = Modifier.padding(it),
                columns = GridCells.Fixed(4),
            ) {
                item(span = span) {
                    AwbOrderIdColum()
                }
                item(span = span) {
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .fillMaxWidth()
                            .background(color = whiteFF)
                    )

                }
                item(span = span) {
                    Text(
                        text = "Schedule Reattempt Shipment",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = black1A,

                            ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, start = 20.dp)
                    )
                }
                item(span = span) {


                    FlowRow(
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 15.dp,
                            bottom = 1.dp,
                            end = 20.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        maxItemsInEachRow = 4
                    ) {

                        repeat(8) {
                            if (it < 7) {

                                DateOption(
                                    date = listofOptionsItem[it].date,
                                    label = listofOptionsItem[it].label,
                                    modifier = Modifier
                                        .padding(bottom = 4.dp)
                                        .weight(1f),
                                    selectedDateOptions = selectedDateOptions,
                                    onDateOptionSelected = { hashCode ->
                                        selectedDateOptions.clear()
                                        selectedDateOptions.add(hashCode)
                                    }
                                )
                            } else {
                                Box(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
                item(span = span) {
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .fillMaxWidth()
                    )

                }
                item(span = span) {
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .fillMaxWidth()
                            .background(color = whiteFF)
                    )
                }

                item(span = span) {
                    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Update Address Details",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF1A1A1A),
                            ),

                            )
                        Spacer(modifier = Modifier.height(10.dp))

                        com.ecomexpress.customerpanel.components.CustomTextField(
                            data = "",
                            onChange = {},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "Mobile Number",
                            visualTransformation = VisualTransformation.None,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        com.ecomexpress.customerpanel.components.CustomTextField(
                            data = "",
                            onChange = {},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "Flat,House no. building",
                            visualTransformation = VisualTransformation.None,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        com.ecomexpress.customerpanel.components.CustomTextField(
                            data = "",
                            onChange = {},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "Area,Street,Sector,Village",
                            visualTransformation = VisualTransformation.None,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        com.ecomexpress.customerpanel.components.CustomTextField(
                            data = "",
                            onChange = {},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "LandMark",
                            visualTransformation = VisualTransformation.None,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        com.ecomexpress.customerpanel.components.CustomTextField(
                            data = "",
                            onChange = {},
                            keyBoardType = KeyboardType.Text,
                            isError = false,
                            labelText = "Pincode",
                            visualTransformation = VisualTransformation.None,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                    }
                }
                item(span = span) {
                    Column {
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                                .fillMaxWidth()
                                .background(color = whiteFF)
                        )
                        Text(
                            text = "Comment Reattempt Shipment ",
                            style = TextStyle(
                                fontSize = 19.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF1A1A1A),
                            ),
                            modifier = Modifier.padding(top = 10.dp, start = 20.dp)
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
                            placeholder = {
                                Text(
                                    text = commentHint,
                                    style = TextStyle(color = greyB7),
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp,
                                )
                            },
                            textStyle = text(greyB7),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(104.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 15.dp)
                                .border(
                                    width = 1.dp,
                                    color = grey1CD,
                                    shape = RoundedCornerShape(size = 4.dp)
                                )
                                .background(color = Color.White),


                            )


                    }


                }
            }
        },
        bottomBar = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()

            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.5.dp)
                        .background(color = grey8B8)
                )
                SearchButton(
                    text = "Submit",
                    imageId = null,
                    function = { navController.popTo(ScreenEnum.Home.name, false) },
                    enabled = isSubmitButtonEnabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(20.dp)
                )
            }


        }
    )
}

@Composable
fun DateOption(
    date: String,
    label: String,
    modifier: Modifier,
    selectedDateOptions: List<Int>,
    onDateOptionSelected: (Int) -> Unit,

    ) {
    val isSelected = selectedDateOptions.contains(date.hashCode())
    val backgroundColor = if (isSelected) Color(0xFFDBE7FE) else Color(0xFFF9FBFD)
    val textColor = if (isSelected) Color(0xFF3C6EE0) else Color(0xFF1A1A1A)

    Box(
        modifier = modifier
            .padding(bottom = 10.dp)

            .shadow(
                elevation = 2.dp,
                spotColor = blue16,
                ambientColor = blue16
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                width = 1.dp,
                color = greyD2,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(5.dp)
            .clickable {
                if (!isSelected) {
                    onDateOptionSelected(date.hashCode())
                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = date,
                style = subheading(textColor, 12.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding()
            )
            Text(
                text = label,
                style = subheading(textColor, 12.sp), textAlign = TextAlign.Center,
                modifier = Modifier.padding()
            )
        }
    }
}


@Composable
fun AddressField(label: String, value: String, iconResourceId: Int) {
    var text by remember { mutableStateOf(value) }

    Box(
        Modifier
            .border(width = 1.dp, greyD2)
            .fillMaxWidth()
            .height(43.dp)
            .background(whiteFD)
            .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResourceId),
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .align(Alignment.CenterStart)
                .padding(8.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = 40.dp)
        ) {
            Text(
                text = label,
                style = text(greyB7),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = subheading(grey4F, 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun ReattemptUi() {
    val viewModel = ReattemptViewModel()
    Reattempt(navController = NavController(context = LocalContext.current), viewModel = viewModel)
}