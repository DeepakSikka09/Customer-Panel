package com.ecomexpress.customerpanel.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.viewModel.RateCalculatorViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RateCalculator(navController: NavHostController, viewModel: RateCalculatorViewModel) {
    val originPincode by viewModel.originPincode.collectAsState()
    val destinationPincode by viewModel.destinationPincode.collectAsState()

    val kgCount by viewModel.kgCount.collectAsState()
    val gramCount by viewModel.gramCount.collectAsState()

    val productType by viewModel.productType.collectAsState()
    val collectableValue by viewModel.collectableValues.collectAsState()

    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current

    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)


    var bottomSheetContent: SheetContent? by remember { mutableStateOf(null) }
    // Button to open the bottom sheet
    val coroutineScope = rememberCoroutineScope()
    val showBottomSheet: (SheetContent) -> Unit = { content ->
        bottomSheetContent = content
        coroutineScope.launch {
            bottomSheetState.show()
        }
    }
    val hideBottomSheet: () -> Unit = {
        coroutineScope.launch {
            bottomSheetState.hide()
            bottomSheetContent = null
        }
    }
    BackHandler(enabled = bottomSheetState.isVisible, onBack = {
        hideBottomSheet()
    })

    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))
    }
    Scaffold( topBar = {
        TextToolbar(title = "Rate Calculator", navController=navController,false,null,null)
                       },
    content = {

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .background(color = whiteFF)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()


                    .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
            ) {
                CustomTextField(
                    data = originPincode,
                    onChange = { viewModel.setOriginPincode(it) },
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Origin Pincode",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding(top =15.dp, start = 20.dp, bottom = 5.dp, end = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                CustomTextField(
                    data = destinationPincode,
                    onChange = { viewModel.setDestinationPincode(it) },
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Destination Pincode",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding(start = 20.dp, bottom = 15.dp, end = 20.dp)

                )

            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Column(modifier = Modifier.background(color = Color.White)) {

                Text(
                    text = "Shipment Weight (Kg)",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1A1A1A),
                    ),
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    WeightCalcComposable(kgCount,"Kilogram", onMinusClick = {viewModel.setKgCount(-1)}, onPlusClick = {viewModel.setKgCount(1)}, modifier = Modifier.weight(1f))
                    GramWeightComposable(gramCount,"Gram",onMinusClick = {viewModel.setGramCount(-100)}, onPlusClick = {viewModel.setGramCount(100)}, modifier = Modifier.weight(1f))
                }



                val locationType = listOf("Prepaid","Postpaid")

                SpinnerExample("Product Type", itemList = locationType, modifier =Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp ))
                CustomTextField(
                    data = collectableValue,
                    onChange = { viewModel.setCollectableValue(it) },
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Collectable Value (₹)",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 15.dp)
                )


            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )


            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(0.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                ) {
                    Row {
                        Text(
                            text = "Estimate Charges",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF1A1A1A),
                            ),
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                        )
                        Image(
                            painter = painterResource(id = com.ecomexpress.customerpanel.R.drawable.question),
                            contentDescription = "",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .padding(1.dp)
                                .clickable {
                                    showBottomSheet { BottomSheetContent() }
                                }
                        )
                    }
                    Text(
                        text = "₹109.74",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF1A1A1A),

                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(19.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
                ) {


                    Text(
                        text = "Estimate Delivery Date",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1A1A1A),
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    )


                    Text(
                        text = "21 Jun, 2023",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1A1A1A),

                        ),
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                    )
                }
            }


        }
    }, bottomBar = {

            Column(modifier = Modifier
                .background(color = Color.White)
                ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp).background(grey8B8))

                LogInButton(function = { }, value ="Calculate" , modifier = Modifier.padding(20.dp))
            }
        })
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = grey400,
                        ambientColor = grey400
                    )
                    .fillMaxWidth()
                    .wrapContentHeight()

            )
            {
                bottomSheetContent?.invoke(this)
            }

        },
        // sheetPeekHeight = 0.dp,
        scrimColor = grey00,
        sheetElevation = 4.dp,
        content = {},
        sheetShape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp,
        ),
        sheetBackgroundColor = white
    )
}
@Preview
@Composable
fun showCalcComposable(){
    RateCalculator(navController = rememberNavController(), viewModel = RateCalculatorViewModel())
}

