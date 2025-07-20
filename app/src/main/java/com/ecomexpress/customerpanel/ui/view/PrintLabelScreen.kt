package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.BlueButton
import com.ecomexpress.customerpanel.components.RowCell
import com.ecomexpress.customerpanel.ui.event.OrderEvent
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.viewModel.OrderViewModel
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.orderTypeAWB
import com.ecomexpress.customerpanel.utils.constants.orderTypeHeading
import com.ecomexpress.customerpanel.utils.constants.orderTypeValue
import com.ecomexpress.customerpanel.utils.enums.OrderType

@Composable
fun PrintAndMangerOrder(navController: NavController) {
    val mViewModel = viewModel<OrderViewModel>()
    val data = mViewModel.currentState.collectAsState()
    val count by mViewModel.filterCount.collectAsState()
    val isCheckedAll by mViewModel.isCheckdAll.collectAsState()

    val listOfAwb = remember {
        mutableListOf<Long>()
    }
    var isChecked by remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = grey6FF,
            contentColor = Color.Black,
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier.padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(end = 8.dp)
                )
                Text(
                    text = count.toString(),
                    style = heading(grey4F, 20.sp),
                )
            }
        }
    },
        content = {
            data.value.let { state ->

                LazyColumn(modifier = Modifier.padding(it)) {
                    item {
                        Column(
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        ) {

                            Row {
                                Box(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .wrapContentWidth()
                                ) {
                                    if (isCheckedAll) {
                                        Image(
                                            painter = painterResource(
                                                id = R.drawable.ic_checkbox
                                            ),
                                            contentDescription = "Checked Checkbox",
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp)
                                                .pointerInput(Unit) {
                                                    detectTapGestures(
                                                        onTap = {
                                                            mViewModel.checkedFilter(false)
                                                            mViewModel.onEvent(
                                                                OrderEvent.onAwbClicked(
                                                                    isUncheckedAll = true,
                                                                    isCheckedAll = false

                                                                )
                                                            )
                                                        }
                                                    )
                                                }
                                        )
                                    } else {
                                        Image(
                                            painter = painterResource(
                                                id = R.drawable.ic_uncheckbox
                                            ),
                                            contentDescription = "Checked Checkbox",
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp)
                                                .pointerInput(Unit) {
                                                    detectTapGestures(
                                                        onTap = {
                                                            mViewModel.checkedFilter(true)
                                                            mViewModel.onEvent(
                                                                OrderEvent.onAwbClicked(
                                                                    isCheckedAll = true,
                                                                    isUncheckedAll = false
                                                                )
                                                            )
                                                        }
                                                    )
                                                }
                                        )
                                    }


                                }


                                RowCell(
                                    text = "AWB No.",
                                    textStyle = orderTypeHeading,
                                    borderWidth = 1.dp,
                                    rowWeight = 1f,
                                    toShowBorder = false
                                )
                                RowCell(
                                    text = "Order Date",
                                    textStyle = orderTypeHeading,
                                    borderWidth = 1.dp,
                                    rowWeight = .7f,
                                    toShowBorder = false

                                )
                                RowCell(
                                    text = "Product\nType",
                                    textStyle = orderTypeHeading,
                                    borderWidth = 1.dp,
                                    rowWeight = 0.7f,
                                    toShowBorder = false

                                )


                            }
                            Divider(
                                color = grey1CD,
                                thickness = 1.dp,

                                )

                        }
                    }

                    items(state.orderList) { order ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp)
                        ) {
                            Row {
                                if (state.currentOrderType == order.orderType||state.currentOrderType==OrderType.FORWARD||state.currentOrderType==OrderType.REVERSE||state.currentOrderType==OrderType.BOTH) {
                                    Box {
                                        if (order.isChecked) {
                                            Image(
                                                painter = painterResource(
                                                    id = R.drawable.ic_checkbox
                                                ),
                                                contentDescription = "Checked Checkbox",
                                                modifier = Modifier
                                                    .padding(top = 8.dp, bottom = 8.dp)
                                                    .pointerInput(Unit) {
                                                        detectTapGestures(
                                                            onTap = {

                                                                mViewModel.onEvent(
                                                                    OrderEvent.onAwbClicked(
                                                                        order,
                                                                        false,
                                                                        false
                                                                    )
                                                                )


                                                            }
                                                        )
                                                    }
                                            )
                                        } else {
                                            Image(
                                                painter = painterResource(
                                                    id = R.drawable.ic_uncheckbox
                                                ),
                                                contentDescription = "Checked Checkbox",
                                                modifier = Modifier
                                                    .padding(top = 8.dp, bottom = 8.dp)
                                                    .pointerInput(Unit) {
                                                        detectTapGestures(
                                                            onTap = {

                                                                mViewModel.onEvent(
                                                                    OrderEvent.onAwbClicked(
                                                                        order,
                                                                        true,
                                                                        false
                                                                    )
                                                                )


                                                            }
                                                        )
                                                    }
                                            )
                                        }

                                    }
                                    RowCell(
                                        text = "${order.awbNo}",
                                        textStyle = orderTypeAWB,
                                        borderWidth = 1.dp,
                                        rowWeight = 1f,
                                        toShowBorder = false

                                    )
                                    RowCell(
                                        text = order.orderDate,
                                        textStyle = orderTypeValue,
                                        borderWidth = 1.dp,
                                        rowWeight = .7f,
                                        toShowBorder = false

                                    )
                                    RowCell(
                                        text = order.productType,
                                        textStyle = orderTypeValue,
                                        borderWidth = 1.dp,
                                        rowWeight = 0.7f,
                                        toShowBorder = false

                                    )

                                }
                            }

                            Divider(
                                color = grey1CD,
                                thickness = 1.dp,

                                )
                        }

                    }


                }
            }
        }, bottomBar = {
            Spacer(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(color = blueFF)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(

                        top = 25.dp,
                        bottom = 25.dp,


                        ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BlueButton(
                    isEnable = false,
                    onClick = {

                    },
                    btnText = "Manage Order",
                    modifier = Modifier

                        .weight(1f)
                        .padding(start = 10.dp, end = 5.dp)
                        .background(color = blue0f8)

                )
                BlueButton(
                    isEnable = true,
                    onClick = {

                    },
                    btnText = "Print Label",
                    modifier = Modifier

                        .weight(.8f)
                        .padding(start = 5.dp, end = 10.dp),
                    color = blue408f,
                    textColor = Color.White
                )
            }
        })
}

@Preview
@Composable
fun showPrintPreview() {
    PrintAndMangerOrder(rememberNavController())
}


@Composable
fun CustomCheckBox(
    check: Boolean,
    onChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.height(50.dp)) {
        if (check) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_checkbox
                ),
                contentDescription = "Checked Checkbox",
                modifier = Modifier.pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onChange() }
                    )
                }
            )
        } else {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_uncheckbox
                ),
                contentDescription = "Un-checked Checkbox",
                modifier = Modifier.pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onChange() }
                    )
                }
            )
        }
        Divider(
            color = grey1CD,
            thickness = 1.dp,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }


}