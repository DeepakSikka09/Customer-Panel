package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R

@Composable
fun CustomBox(modifier: Modifier=Modifier,shadowColor: Color,borderColor: Color,textColor: Color,backgroundColor:Color,textValue:String) {
    Box(modifier = modifier
        .shadow(
            elevation = 2.dp,
            spotColor = shadowColor,
            ambientColor = shadowColor
        )
        .border(
            width = 1.dp,
            color = borderColor,
            shape = RoundedCornerShape(size = 50.dp)
        )
        .background(
            color =backgroundColor,
            shape = RoundedCornerShape(size = 50.dp)
        )
        .padding(start = 18.dp, top = 10.dp, end = 18.dp, bottom = 10.dp)
    )
    {
        Text(
            text = textValue,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontWeight = FontWeight(500),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(), color = textColor

        )
    }
}