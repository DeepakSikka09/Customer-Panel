package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.utils.constants.Calender

@Composable
fun CustomCalendarButton(
    modifier: Modifier,
    dateSelected:String
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "calendar"
            )
            Text(
                text = dateSelected,
                style = Calender,
                modifier = Modifier.padding(start = 5.dp, end = 10.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_down_arrow),
            contentDescription = "calendar"
        )
    }
}