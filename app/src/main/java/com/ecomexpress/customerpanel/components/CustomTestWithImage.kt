package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F

@Composable
fun TextWithImage(
    @DrawableRes leadingImageId: Int,
    trailingImageId: Int?,
    text: String,
    size: TextUnit?,
    state: String?,
    date: String?,
    modifier: Modifier=Modifier,
    style: TextStyle?
) {

    Row(verticalAlignment = Alignment.Top, modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.Top)) {
            Image(
                painter = painterResource(id = leadingImageId),
                contentDescription = "Icon",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column {
            Text(
                text = text,


            )
            Text(
                text = state ?: "",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = black1A,
                )
            )
            Text(
                text = date ?: "",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = grey4F,
                )
            )
            /*Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp))*/
        }
    }
}
