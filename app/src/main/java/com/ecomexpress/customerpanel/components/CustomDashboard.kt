package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.*

@Composable
fun CustomDashboard(
    title1:String,
    value1:String,
    title2:String,
    value2:String,
    title3:String,
    value3:String,
    title4:String,
    value4:String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 17.dp)
    ) {
        CustomTotalBox(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = grey6FF,
                    shape = RoundedCornerShape(topStart = 6.dp, bottomStart = 6.dp)
                ),
            title = title1,
            value = value1,
            titleColor = greyB7,
            valColor = grey4F
        )
        CustomTotalBox(
            modifier = Modifier
                .weight(1f)
                .background(color = Color(0xFFFFFFFF)),
            title = title2,
            value = value2,
            titleColor = greyB7,
            valColor = grey4F
        )
        CustomTotalBox(
            modifier = Modifier
                .weight(1f)
                .background(color = Color(0xFFFFFFFF)),
            title = title3,
            value = value3,
            titleColor = greyB7,
            valColor = grey4F
        )
        CustomTotalBox(
            modifier = Modifier
                .background(
                    color = white,
                    shape = RoundedCornerShape(bottomEnd = 6.dp, topEnd = 6.dp)
                )
                .weight(1f),
            title = title4,
            value = value4,
            titleColor = greyB7,
            valColor = grey4F
        )

    }
}

@Composable
fun CustomTotalBox(
    modifier: Modifier,
    value: String,
    title: String,
    valColor: Color,
    titleColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {

        Text(
            text = value,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = valColor,
            ),
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = titleColor,
                textAlign = TextAlign.Center

            ),
            modifier = Modifier
                .padding(top = 2.dp, bottom = 15.dp)
                .fillMaxWidth()
        )
    }
}