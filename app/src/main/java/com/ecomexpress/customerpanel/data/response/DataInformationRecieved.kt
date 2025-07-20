package com.ecomexpress.customerpanel.data.response
import androidx.annotation.DrawableRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R

class DataInformationRecieved(
    @DrawableRes var leadingImageId: Int,
    @DrawableRes var trailingImageId: Int? = null,
    var text: String,
    var size: TextUnit? = 0.sp,
    var modifier: Modifier? = Modifier,
    var city: String,
   var  date: String,
    var isInTransit:Boolean?=false


)

var listofInformationRecieved = listOf(
    DataInformationRecieved(
        leadingImageId = R.drawable.active_information_received,
        text = "Information Received",
        city = "Ahemdabad",
        date = "Thursday - 01 June, 2023",
    ),
    DataInformationRecieved(
        leadingImageId = R.drawable.active_information_received,
        text = "Pickup Completed",
        city = "Ahemdabad",
        date = "Thursday - 01 June, 2023"
    ),
    DataInformationRecieved(
        leadingImageId = R.drawable.active_information_received,
        text = "In-Transit",
        city = "Ahemdabad",
        date = "Thursday - 01 June, 2023",
        isInTransit = true

    ),

    DataInformationRecieved(
        leadingImageId = R.drawable.active_information_received,
        text = "Out for Delivery",
        city = "Ahemdabad",
        date = "Thursday - 01 June, 2023"

    ),
)

data class TransitUpdates(
    @DrawableRes var leadingImageId: Int,
    var title: String,
    var city: String,
    var  date: String,
    var isLastIndex:Boolean?=false
)

val transitUpdateList = listOf(TransitUpdates(  leadingImageId = R.drawable.dots,
    title = "Information Received",
    city = "Bengluru-BLR",
    date = "02May ,2023 09:33 hrs",
    isLastIndex = false),
    TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false),TransitUpdates(  leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = true),
)


