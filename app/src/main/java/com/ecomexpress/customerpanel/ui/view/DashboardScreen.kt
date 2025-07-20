package com.ecomexpress.customerpanel.ui.view

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.blueFF
import com.ecomexpress.customerpanel.ui.theme.grey400
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey6FF

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(
    showBottomSheet: (SheetContent) -> Unit,
    hideBottomSheet: () -> Unit,
    navHostController: NavController
) {

    val pagerState = rememberPagerState(
        initialPage = 0,
    )
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(grey6FF)  // Replace with your desired color
    }
    val imagesList = arrayListOf(
        R.drawable.ic_frame,
        R.drawable.ic_frame,
        R.drawable.ic_frame
    )
    var datePicked by remember { mutableStateOf("Today") }



    val calendar = Calendar.getInstance()
    val datePickerListener =
        DatePickerDialog.OnDateSetListener { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            calendar[Calendar.DAY_OF_MONTH] = selectedDay
            calendar[Calendar.MONTH] = selectedMonth
            calendar[Calendar.YEAR] = selectedYear
            val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)

            datePicked = sdf.format(calendar.time)

        }
    val datePicker = DatePickerDialog(
        context,
        datePickerListener,
        calendar[Calendar.YEAR],
        calendar[Calendar.MONTH],
        calendar[Calendar.DAY_OF_MONTH]
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
            .verticalScroll(rememberScrollState())
            .background(color = whiteFF)
    ) {
        Box( modifier = Modifier
            .fillMaxWidth()
            .background(
                color = white,
                shape = RoundedCornerShape(2.dp)
            )
            .padding(bottom = 15.dp)
        ) {
            HorizontalPager(
                pageCount = imagesList.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(122.dp)
                    .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                    .background(
                        color = blueFF,
                        shape = RoundedCornerShape(size = 6.dp)
                    ),
                beyondBoundsPageCount = 1

            ) { pos ->
                if (pos % 2 == 0) {
                    Image(
                        painter = painterResource(id = imagesList[pos]),
                        contentDescription = "image$pos",
                        modifier = Modifier
                            .fillMaxSize()

                    )
                } else {
                    Image(
                        painter = painterResource(id = imagesList[pos]),
                        contentDescription = "image$pos",
                        modifier = Modifier
                            .fillMaxSize()

                    )
                }
                LaunchedEffect(key1 = Unit) {
                    while (true) {
                        delay(5000)
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                (pagerState.currentPage + 1) % imagesList.size,
                                animationSpec = tween(600)
                            )
                        }

                    }
                }
            }
            CustomSliderIndicator(
                imagesList.size,
                pagerState.currentPage,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 6.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = white,
                    shape = RoundedCornerShape(2.dp)
                )
                .padding(top = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShortCutButton(
                    icon = R.drawable.ic_create_shipment,
                    title = "Create\nShipment",
                    cashAmount = null,
                    modifier = Modifier.clickable {
                        navHostController.navigate(ScreenEnum.CreateShipment.name)
                    }
                )
                ShortCutButton(
                    icon = R.drawable.ic_action_pending,
                    title = "Action\nPending",
                    cashAmount = null,
                    modifier = Modifier.clickable {
                        navHostController.navigate(ScreenEnum.ActionPending.name)
                    }
                )
                ShortCutButton(
                    icon = R.drawable.ic_rate_calculator,
                    title = "Rate\nCalculator",
                    cashAmount = null,
                    modifier = Modifier.clickable {
                        navHostController.navigate(ScreenEnum.RateCalculator.name)
                    }
                )
                ShortCutButton(
                    icon = R.drawable.ic_recharge_wallet,
                    title = "Recharge",
                    cashAmount = "₹1,080"
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = white,
                    shape = RoundedCornerShape(2.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Summary",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(500),
                            color = black1A,
                        )
                    )

                    Image(painter = painterResource(id = R.drawable.ic_mi_filter), contentDescription = "")


                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomDashBoardBox(
                        R.drawable.ic_order_placed,
                        "12000",
                        "Orders Placed",
                        Modifier
                            .weight(1f)
                            .padding(end = 5.dp)
                    )
                    CustomDashBoardBox(
                        R.drawable.ic_delivered,
                        "11000",
                        "Delivered",
                        Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                ) {
                    CustomDashBoardBox(
                        R.drawable.ic_returned,
                        "1200",
                        "Returned",
                        Modifier
                            .weight(1f)
                            .padding(end = 5.dp)
                    )
                    CustomDashBoardBox(
                        R.drawable.ic_cod,
                        "120",
                        "COD Remittance",
                        Modifier
                            .weight(1f)
                            .padding(start = 10.dp)
                    )
                }
                CustomDashboard(
                    title1 = "Total NDR",
                    value1 = "100",
                    title2 = "Pending",
                    value2 = "100",
                    title3 = "Raised",
                    value3 = "100",
                    title4 = "Delivered",
                    value4 = "100"
                )
                CustomDashboard(
                    title1 = "Total Revenue",
                    value1 = "100",
                    title2 = "COD",
                    value2 = "100",
                    title3 = "PPD",
                    value3 = "100",
                    title4 = "COD to PPD",
                    value4 = "100"
                )
            }
        }
    }
}

@Preview
@Composable
fun DashScreenPreview()
{
    DashboardScreen(showBottomSheet = {sheet->

    }, hideBottomSheet = {  }, navHostController = rememberNavController())
}
