package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.AppShapes
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.whiteFF

@Composable
fun CurvedShapeCard(
    leadingIcon: Int,
    trailingIcon: Int,
    cardText: String
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            )
            .wrapContentWidth()
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        // Content of the card
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = leadingIcon),
                contentDescription = "Leading Icon",
                modifier = Modifier
                    .wrapContentSize()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = cardText,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = grey4F,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = trailingIcon),
                contentDescription = "Trailing Icon",
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}

@Composable
fun Card() {
    Box(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = whiteFF, shape = AppShapes.large)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.align(Alignment.Top)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_origin_location),
                        contentDescription = "Origin Icon",
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                    )
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .background(color = Color.Black)
                            .align(Alignment.CenterHorizontally)
                            .width(2.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Origin Location",
                    fontFamily = fontFamily,
                    modifier = Modifier.align(Alignment.Top)
                )
            }
            Spacer(modifier = Modifier.height(0.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_destination_location),
                    contentDescription = "Destination Icon",
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Destination Location",
                    fontFamily = fontFamily,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}






