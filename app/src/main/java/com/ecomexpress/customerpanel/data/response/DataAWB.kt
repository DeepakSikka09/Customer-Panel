package com.ecomexpress.customerpanel.data.response
import androidx.annotation.DrawableRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R

class Data(
    @DrawableRes var leadingImageId: Int,
    @DrawableRes var trailingImageId: Int? = null,
    var text: String,
    var size: TextUnit? = 0.sp,
    var modifier: Modifier? = Modifier,
    state: String,
    date: String
)

var listofAwb = listOf(
    Data(
        leadingImageId = R.drawable.ic_awb,
        text = "5708301471",
        state = "null",
        date = "null"
    ),
    Data(
        leadingImageId = R.drawable.ic_awb,
        text = "5708301471",
        state = "null",
        date = "null"
    ),
    Data(
        leadingImageId = R.drawable.ic_awb,
        text = "5708301471",
        state = "null",
        date = "null"
    ),
    Data(
        leadingImageId = R.drawable.invoice,
        text = "5708301471",
        state = "null",
        date = "null"
    ),
    Data(
        leadingImageId = R.drawable.invoice_truck,
        text = "5708301471",
        state = "null",
        date = "null"
    ),







)