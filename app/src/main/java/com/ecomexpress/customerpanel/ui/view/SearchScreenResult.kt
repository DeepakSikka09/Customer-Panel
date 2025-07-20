package com.ecomexpress.customerpanel.ui.view

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.data.response.listofInformationRecieved
import com.ecomexpress.customerpanel.data.response.transitUpdateList
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.viewModel.SearchScreenViewModel
import com.ecomexpress.customerpanel.ui.viewModel.SerachScreenResultViewModel
import com.ecomexpress.customerpanel.utils.constants.*
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

/*
*  removed the BottomSheetScaffold and replaced it with the ModalBottomSheetLayout.
* The main content is wrapped inside the Scaffold's content block,
* while the bottom sheet content is provided within the sheetContent parameter of ModalBottomSheetLayout.
* The ModalBottomSheetLayout now appears above the main layout as desired.
* */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreenSecond(navController: NavController, viewModel: SerachScreenResultViewModel) {
    val systemUiController = rememberSystemUiController()
    val showDialog by viewModel.showDialog.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))  // Replace with your desired color
    }


    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)


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


    Scaffold(backgroundColor = white,
        topBar = {
            TextToolbar(
                title = "",
                navController = navController,
                isTraillingIcon = true,
                showHelpBottomSheet = { showBottomSheet { ShowHelpBottomSheet() } })

        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)


            ) {

                AwbOrderIdColumn()

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                        .background(color = whiteFF)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(color = white)
                        .padding(top = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "Prepaid Delivery",
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1A1A1A),

                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                        .background(color = whiteFF)
                )
                // Card()
                DeliveryLocationComposable()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                        .background(color = whiteFF)
                )
                LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(color = Color.White)
                                .padding(start = 20.dp, top = 15.dp)
                                ,
                        ) {
                            itemsIndexed(listofInformationRecieved) { index, item ->
                                // Check if it's the last index
                                val isLastIndex = index == listofInformationRecieved.size - 1

                                TextImageDataIformation(
                                    leadingImageId = R.drawable.active_information_received,
                                    title = listofInformationRecieved[index].text,
                                    city = listofInformationRecieved[index].city,
                                    date = listofInformationRecieved[index].date,
                                    modifier = Modifier,
                                    isLastIndex = isLastIndex,
                                    isInTransit = listofInformationRecieved[index].isInTransit!!,
                                    showTransitUpdateBottomSheet = { showBottomSheet { ShowTransitUpdates(dismissBottomSheet = hideBottomSheet) } }
                                )
                            }
                    item {
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp))
                    }


                        }
            }

            if (showDialog) {
                hideBottomSheet()
                CenteredImageWithTextAndButtons(
                    onDismiss = {
                        viewModel.dialogStatus(false)
                    } // Dismiss the dialog when the user clicks outside box
                , isYesClicked = {showBottomSheet{
                        viewModel.dialogStatus(false)
                        SearchScreenBottomSheet(navController = navController,hideBottomSheet)}}
                )
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
                    text = "Manage Order",
                    imageId = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(20.dp),
                    function = {
                        showBottomSheet {
                            CancelPickup(viewModel)
                        }
                    },

                    )
            }
        }
    )

    // Display the BottomSheetLayout when bottomSheetVisible is true
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
fun showSearchResult() {
    SearchScreenSecond(
        navController = rememberNavController(),
        viewModel = SerachScreenResultViewModel()
    )
}


@Composable
fun AwbOrderIdColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.White)
    ) {
        Text(
            text = "AWB: 5708301471 ",
            style = TextStyle(
                fontSize = 21.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),

                ),
            modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
        )
        Text(
            text = "Order Id: AS56896456",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A),

                ),
            modifier = Modifier.padding(start = 20.dp, bottom = 15.dp)

        )
    }
}

@Composable
fun DeliveryLocationComposable() {
    val modifier: Modifier = Modifier
        .padding(1.dp)
        .width(20.dp)
        .height(20.dp)
    val modifierDot: Modifier = Modifier
        .padding(start = 10.dp)
        .height(16.dp)

    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.White)
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.origin),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = modifier
            )
            Text(
                text = "Ahmedabad, Gujarat",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1A1A1A),

                    ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row {
            Column(modifier = Modifier.padding(start = 9.dp)) {
                Divider(
                    modifier = Modifier
                        .border(width = 2.dp, color = Color(0xFF1A1A1A))
                        .padding(2.dp)
                        .width(0.dp)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Divider(
                    modifier = Modifier
                        .border(width = 2.dp, color = Color(0xFF1A1A1A))
                        .padding(2.dp)
                        .width(0.dp)
                        .height(6.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Divider(
                    modifier = Modifier
                        .border(width = 2.dp, color = Color(0xFF1A1A1A))
                        .padding(2.dp)
                        .width(0.dp)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))


            }
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = modifier
            )
            Text(
                text = "Ahmedabad, Gujarat",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1A1A1A),

                    ),
                modifier = Modifier.padding(start = 8.dp)

            )
        }


    }
}

@Composable
fun CancelPickup(SearchScreenViewModel: SerachScreenResultViewModel?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFF6F8FF))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFFFFFFFF))
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            .clickable {
                SearchScreenViewModel!!.dialogStatus(true)
            }

    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.cancel_shipment),
                contentDescription = "",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )

            Text(
                text = "Cancel Pickup",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1A1A1A),
                ), modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = "")

    }
}

@Composable
fun ShowTransitUpdates(dismissBottomSheet:()->Unit={}){
    Column(
        modifier = Modifier.background(
            shape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp
            ), color = Color.White
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Shipment Delivered",
                style = TextStyle(
                    fontSize = 21.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1A1A1A),
                )
            )
            Image(painter = painterResource(id = R.drawable.cross), contentDescription = "", modifier = Modifier.clickable {
                dismissBottomSheet()
            })

        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(15.dp),
            contentPadding = PaddingValues(bottom = 10.dp)
        ) {
            itemsIndexed(transitUpdateList) { index, item ->
                // Check if it's the last index
                val isLastIndex = index == transitUpdateList.size - 1
                TransitsUpdateComposable(
                    leadingImageId = transitUpdateList[index].leadingImageId,
                    title = transitUpdateList[index].title,
                    city = transitUpdateList[index].city, date = transitUpdateList[index].date,
                    isLastIndex = isLastIndex
                )

            }
        }

    }
}

@Composable
fun SearchScreenBottomSheet(
    navController: NavController,
    hideBottomSheet: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {
                    navController.navigate(ScreenEnum.Return.name)
                    hideBottomSheet()
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_return),
                contentDescription = "Leading Icon",
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(

                text = "Return",
                style = subheading(black1A, 18.sp),
                modifier = Modifier.weight(1f)

            )
            Icon(
                painter = painterResource(id = R.drawable.ic_right_face_arrow),
                contentDescription = "Trailing Icon",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {

                    }
            )
        }

        // Third Row
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {
                    navController.navigate(ScreenEnum.Reattempt.name)
                    hideBottomSheet()
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_reattempt),
                contentDescription = stringResource(R.string.leading_icon),

                )
            Spacer(modifier = Modifier.width(14.dp))
            Text(

                text = "Reattempt",
                style = subheading(black1A, 18.sp),
                modifier = Modifier.weight(1f)

            )
            Icon(
                painter = painterResource(id = R.drawable.ic_right_face_arrow),
                contentDescription = stringResource(R.string.trailing_icon),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        // Navigate to the new screen using the NavController

                    }
            )
        }
    }
}

@Preview
@Composable
fun screenPreview()
{
    SearchScreenBottomSheet(navController = rememberNavController(), hideBottomSheet = {})
}


