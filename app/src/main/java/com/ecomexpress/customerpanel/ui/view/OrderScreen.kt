package com.ecomexpress.customerpanel.ui.view

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.BlueButton
import com.ecomexpress.customerpanel.components.CustomFilterCheckBox
import com.ecomexpress.customerpanel.components.RowCell
import com.ecomexpress.customerpanel.components.SearchBar
import com.ecomexpress.customerpanel.ui.event.OrderEvent
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.viewModel.OrderViewModel
import com.ecomexpress.customerpanel.utils.constants.*
import com.ecomexpress.customerpanel.utils.enums.OrderType
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
@Composable
fun OrderScreen(
    showBottomSheet: (SheetContent) -> Unit,
    hideBottomSheet: () -> Unit,
    navController: NavController
) {
    val mViewModel = viewModel<OrderViewModel>()
    val data = mViewModel.currentState.collectAsState()
    var datePicked by remember { mutableStateOf("Today") }
    var isBottomSheetVisible = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    var selectedIndex by remember {
        mutableStateOf(-1)
    }
    var calenderIndex by remember {
        mutableStateOf(0)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

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
    BackHandler(onBack = {
        isBottomSheetVisible.value = false
        hideBottomSheet()
        mViewModel.onEvent(OrderEvent.OnCloseFilter)
    }, enabled = isBottomSheetVisible.value)
    data.value.let { state ->
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .background(
                    color = Color.White
                )
        ) {
            Row {

                Column(modifier = Modifier
                    .weight(1f)
                    .clickable { mViewModel.onEvent(OrderEvent.OnOrderChange(OrderType.FORWARD)) }) {
                    Text(
                        text = "Forward",
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        color = if (OrderType.FORWARD == state.currentOrderType) Color.Black else Color.Gray
                    )
                    Divider(
                        modifier = if (OrderType.FORWARD == state.currentOrderType)
                            selectedView
                        else
                            unselectedView
                    )


                }
                Column(modifier = Modifier
                    .weight(1f)
                    .clickable { mViewModel.onEvent(OrderEvent.OnOrderChange(OrderType.REVERSE)) })
                {

                    Text(
                        text = "Reverse",
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        color = if (OrderType.REVERSE == state.currentOrderType) Color.Black else Color.Gray
                    )
                    Divider(
                        modifier = if (OrderType.REVERSE == state.currentOrderType)
                            selectedView
                        else
                            unselectedView
                    )

                }

            }
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(color = blueFF)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
            ) {
                Row(
                    modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                showBottomSheet {
                                    isBottomSheetVisible.value = true
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row {
                                                Icon(
                                                    painter = painterResource(
                                                        id = R.drawable.mi_filter_black
                                                    ), contentDescription = "filter_row"
                                                )
                                                Text(
                                                    text = "Filter",
                                                    style = TextStyle(
                                                        fontSize = 18.sp,
                                                        fontFamily = fontFamily,
                                                        fontWeight = FontWeight(700),
                                                        color = Color(0xFF1A1A1A),
                                                    )
                                                )


                                            }
                                            Icon(
                                                painter = painterResource(
                                                    id = R.drawable.ic_cancel
                                                ),
                                                contentDescription = "Cancel",
                                                modifier = Modifier.pointerInput(Unit) {
                                                    detectTapGestures(
                                                        onTap = {
                                                            mViewModel.onEvent(OrderEvent.OnCloseFilter)
                                                            isBottomSheetVisible.value = false
                                                            hideBottomSheet()
                                                        }
                                                    )
                                                }
                                            )
                                        }
                                        Text(
                                            text = "By Status",
                                            style = TextStyle(
                                                fontSize = 18.sp,
                                                fontFamily = fontFamily,
                                                fontWeight = FontWeight(500),
                                                color = Color(0xFF1A1A1A),
                                            ),
                                            modifier = Modifier.padding(top = 25.dp)
                                        )
                                        mViewModel.currentState.collectAsState().value.let { orderState ->
                                            LazyColumn(
                                                content = {
                                                    items(mViewModel.filterValue) { value ->

                                                        if (value.orderType == orderState.currentOrderType || value.orderType == OrderType.BOTH) {
                                                            CustomFilterCheckBox(
                                                                text = value.filter,
                                                                check = orderState.checkedFilterList.contains(
                                                                    value.filterType
                                                                ),
                                                                onChange = {
                                                                    mViewModel.onEvent(
                                                                        OrderEvent.OnCheckboxClick(
                                                                            value
                                                                        )
                                                                    )
                                                                }
                                                            )
                                                        }


                                                    }
                                                    item {
                                                        Text(
                                                            text = "By Date Range",
                                                            style = TextStyle(
                                                                fontSize = 18.sp,
                                                                fontFamily = fontFamily,
                                                                fontWeight = FontWeight(500),
                                                                color = Color(0xFF1A1A1A),
                                                            ),
                                                            modifier = Modifier.padding(
                                                                bottom = 20.dp,
                                                                top = 10.dp
                                                            )
                                                        )
                                                    }
                                                    item {

                                                        Column {
                                                            FlowRow(
                                                                horizontalArrangement = Arrangement.spacedBy(
                                                                    10.dp
                                                                ),
                                                                maxItemsInEachRow = 3
                                                            ) {
                                                                repeat(5) {
                                                                    RoundDateText(
                                                                        text = listOfDateRange[it].days,

                                                                        modifier = if (it < 3) {
                                                                            Modifier
                                                                                .weight(1f)
                                                                                .clickable(
                                                                                    interactionSource = interactionSource,
                                                                                    indication = null
                                                                                ) {

                                                                                    selectedIndex =
                                                                                        it
                                                                                    calenderIndex =
                                                                                        it
                                                                                }
                                                                        } else {
                                                                            Modifier.clickable(
                                                                                interactionSource = interactionSource,
                                                                                indication = null
                                                                            ) {
                                                                                selectedIndex = it
                                                                                calenderIndex = it
                                                                            }
                                                                        },
                                                                        isSelcted = it == selectedIndex,
                                                                        index = it>2

                                                                    )
                                                                }
                                                            }
                                                            if (calenderIndex == 4) {
                                                                Text(
                                                                    text = "Select Date",
                                                                    style = TextStyle(
                                                                        fontSize = 18.sp,
                                                                        fontFamily = fontFamily,
                                                                        fontWeight = FontWeight(500),
                                                                        color = Color(0xFF1A1A1A),
                                                                    ),
                                                                    modifier = Modifier.padding(
                                                                        top = 5.dp,
                                                                        bottom = 25.dp
                                                                    )
                                                                )
                                                                Row(
                                                                    horizontalArrangement = Arrangement.spacedBy(
                                                                        0.dp,
                                                                        Alignment.Start
                                                                    ),
                                                                    verticalAlignment = Alignment.CenterVertically,
                                                                    modifier = Modifier
                                                                        .border(
                                                                            width = 1.dp,
                                                                            color = Color(0xFFBCC1CD),
                                                                            shape = RoundedCornerShape(
                                                                                size = 4.dp
                                                                            )
                                                                        )
                                                                        .fillMaxWidth()
                                                                        .height(44.dp)
                                                                        .background(
                                                                            color = Color(
                                                                                0xFFFFFFFF
                                                                            ),
                                                                            shape = RoundedCornerShape(
                                                                                size = 4.dp
                                                                            )
                                                                        )
                                                                        .padding(
                                                                            start = 6.dp,
                                                                            top = 6.dp,
                                                                            end = 6.dp,
                                                                            bottom = 6.dp
                                                                        )
                                                                ) {
                                                                    Text(
                                                                        text = "28-05-2023 to 30-05-2023",
                                                                        modifier = Modifier.weight(
                                                                            1f
                                                                        ),
                                                                        fontWeight = FontWeight.Bold
                                                                    )
                                                                    Image(
                                                                        painter = painterResource(id = R.drawable.calender_new),
                                                                        contentDescription = ""
                                                                    )

                                                                }
                                                            }


                                                        }
                                                    }

                                                    item {
                                                        Row(
                                                            modifier = Modifier.padding(
                                                                top = 25.dp,
                                                                bottom = 25.dp
                                                            )
                                                        ) {
                                                            BlueButton(
                                                                isEnable = false,
                                                                onClick = {
                                                                    mViewModel.onEvent(OrderEvent.ApplyFilter)
                                                                    isBottomSheetVisible.value =
                                                                        false
                                                                    hideBottomSheet()
                                                                },
                                                                btnText = "Clear",
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .weight(1f)
                                                                    .padding(end = 5.dp)

                                                            )
                                                            BlueButton(
                                                                isEnable = orderState.checkedFilterList.isNotEmpty(),
                                                                onClick = {
                                                                    mViewModel.onEvent(OrderEvent.ApplyFilter)
                                                                    isBottomSheetVisible.value =
                                                                        false
                                                                    hideBottomSheet()
                                                                },
                                                                btnText = "Apply",
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .weight(1f)
                                                                    .padding(start = 5.dp),
                                                                color = blue408f,
                                                                textColor = Color.White
                                                            )
                                                        }
                                                    }
                                                },
                                                modifier = Modifier.padding(top = 25.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar(
                        modifier = Modifier.weight(1f),
                        text = "",
                        onTextChange = { newText ->

                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .wrapContentSize()
                            )
                        },
                        trailingIcon = {

                        }
                    )
                    if (state.currentlySelectedFilter.isEmpty()) {
                        Image(
                            painter = painterResource(id = R.drawable.mi_filter),
                            contentDescription = "filter",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    } else {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.mi_filter),
                                contentDescription = "remove filter",
                                modifier = Modifier
                                    .width(36.dp)
                                    .height(36.dp)
                            )
                            Text(
                                text = "${state.currentlySelectedFilter.size}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    color = white,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .background(shape = CircleShape, color = blueCC6)
                                    .width(18.dp)
                                    .height(18.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }

                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(color = blueFF)
            )

            LazyColumn(
                content = {
                    item {
                        Row(
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        ) {
                            RowCell(
                                text = "AWB No.",
                                textStyle = orderTypeHeading,
                                borderWidth = 1.dp,
                                rowWeight = 1f
                            )
                            RowCell(
                                text = "Order Date",
                                textStyle = orderTypeHeading,
                                borderWidth = 1.dp,
                                rowWeight = 1f
                            )
                            RowCell(
                                text = "Product\nType",
                                textStyle = orderTypeHeading,
                                borderWidth = 1.dp,
                                rowWeight = 0.7f
                            )
                            RowCell(
                                text = "Status",
                                textStyle = orderTypeHeading,
                                borderWidth = 1.dp,
                                rowWeight = 0.7f
                            )
                        }
                    }

                    items(state.orderList) { order ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp)
                                .combinedClickable(onLongClick = {
                                    navController.navigate(ScreenEnum.PrintLabelScreen.name)
                                }, onClick = {})
                        ) {
                            if (state.currentOrderType == order.orderType) {
                                RowCell(
                                    text = "${order.awbNo}",
                                    textStyle = orderTypeAWB,
                                    borderWidth = 1.dp,
                                    rowWeight = 1f
                                )
                                RowCell(
                                    text = order.orderDate,
                                    textStyle = orderTypeValue,
                                    borderWidth = 1.dp,
                                    rowWeight = 1f
                                )
                                RowCell(
                                    text = order.productType,
                                    textStyle = orderTypeValue,
                                    borderWidth = 1.dp,
                                    rowWeight = 0.7f
                                )
                                RowCell(
                                    text = order.status,
                                    textStyle = orderTypeValue,
                                    borderWidth = 1.dp,
                                    rowWeight = 0.7f
                                )
                            }
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.button),
                contentDescription = "shipment", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp)
                    .clickable {
                        navController.navigate(ScreenEnum.CreateShipment.name)
                    }
            )

        }
    }
}

@Composable
fun RoundDateText(
    text: String,
    modifier: Modifier = Modifier,
    isSelcted: Boolean,
    index:Boolean
) {
    val backgroundColor = if (isSelcted) grey7FE else white
    val borderColor = if (isSelcted) Color.Transparent else grey1CD


    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            color = black1A
        ),
        modifier = modifier
            .padding(bottom = 20.dp)
            .background(shape = RoundedCornerShape(50.dp), color = backgroundColor)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(50.dp))
            .padding(vertical = 10.dp, horizontal = if (index)20.dp else 10.dp), textAlign = TextAlign.Center
    )


}


@Preview
@Composable
fun showOrderPreview() {
    OrderScreen(showBottomSheet = {}, navController = rememberNavController(), hideBottomSheet = {})
}


data class DateRange(val days: String, val isSelected: Boolean)

val listOfDateRange = listOf(
    DateRange("Today", false),
    DateRange("Last 7 Days", false),
    DateRange("Last 15 Days", false),
    DateRange("Last 30 Days", false),
    DateRange("Custom Date", false)
)
