package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ecomexpress.customerpanel.data.response.ActionPendingModel
import com.ecomexpress.customerpanel.data.response.ActionTakenModel
import com.ecomexpress.customerpanel.data.response.DeliveredModel
import com.ecomexpress.customerpanel.data.response.RtoModel
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.utils.constants.orderAwbValue
import com.ecomexpress.customerpanel.utils.constants.orderTypeHeading
import com.ecomexpress.customerpanel.utils.constants.orderTypeValue

@Composable
fun ActionPendingTable(
    list: ArrayList<ActionPendingModel>,
    modifier: Modifier,
    showBottomSheet: (SheetContent) -> Unit,
    navController: NavController,
    hideBottomSheet: () -> Unit

) {
    LazyColumn(
        content = {
            item {
                Row(
                    modifier = Modifier
                ) {
                    RowCell(
                        text = "AWB No.",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Date",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Attempt\nLeft",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.8f
                    )
                    RowCell(
                        text = "Product\nType",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.7f
                    )
                }
            }

            items(list) { order ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showBottomSheet {
                            bottomSheetNDR(
                                awbNo = order.awbNo.toString(),
                                productType = if (order.productType.equals("PPD",ignoreCase = false)) "Prepaid Delivery" else "Cash On Delivery",
                                navController = navController,
                                hideBottomSheet
                            )
                        }
                    }) {
                    RowCell(
                        text = "${order.awbNo}",
                        textStyle = orderAwbValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f,

                    )
                    RowCell(
                        text = order.date,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.attemptLeft,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.8f
                    )
                    RowCell(
                        text = order.productType,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.7f
                    )
                }
            }
        }
    )
}

@Composable
fun ActionTakenTable(list: ArrayList<ActionTakenModel>, modifier: Modifier) {
    LazyColumn(
        content = {
            item {
                Row(
                    modifier = Modifier
                ) {
                    RowCell(
                        text = "AWB No.",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Aged",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Last\nInstructed",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.9f
                    )
                    RowCell(
                        text = "Attempt\nLeft",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.7f
                    )
                }
            }

            items(list) { order ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    RowCell(
                        text = "${order.awbNo}",
                        textStyle = orderAwbValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.aged,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.lastInstructed,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.9f
                    )
                    RowCell(
                        text = "${order.attemptLeft}",
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.7f
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun DeliveredTable(list: ArrayList<DeliveredModel>, modifier: Modifier) {
    LazyColumn(
        content = {
            item {
                Row(
                    modifier = Modifier
                ) {
                    RowCell(
                        text = "AWB No.",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Attempt Done",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Status",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.8f
                    )
                }
            }

            items(list) { order ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    RowCell(
                        text = "${order.awbNo}",
                        textStyle = orderAwbValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.attemptDone,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.status,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.8f
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun RtoTable(list: ArrayList<RtoModel>, modifier: Modifier) {
    LazyColumn(
        content = {
            item {
                Row(
                    modifier = Modifier
                )
                {
                    RowCell(
                        text = "AWB No.",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = "Attempt Done",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 0.8f
                    )
                    RowCell(
                        text = "Reason",
                        textStyle = orderTypeHeading,
                        borderWidth = 1.dp,
                        rowWeight = 1f
                    )
                }
            }

            items(list) { order ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    RowCell(
                        text = "${order.awbNo}",
                        textStyle = orderAwbValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                    RowCell(
                        text = order.attemptDone,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 0.8f
                    )
                    RowCell(
                        text = order.reason,
                        textStyle = orderTypeValue,
                        borderWidth = (0.3).dp,
                        rowWeight = 1f
                    )
                }
            }
        },
        modifier = modifier
    )
}

