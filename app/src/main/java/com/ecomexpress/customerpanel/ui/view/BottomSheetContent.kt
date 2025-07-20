package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.TextLabelComposable
import com.ecomexpress.customerpanel.ui.theme.fontFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent() {
    Column(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .background(color = Color.White, shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
        .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 8.dp))) {
        Text(
            text = "Estimate Charges",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF1A1A1A),
            ), modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp)
        )
        Text(
            text = "Volumetric/Dead Weight Whichever Is High. This Is An Indicative Price Only. Actual Cost Will Be Present In The Bill.",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A),
            ), modifier = Modifier.padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
        )
    } }

@Preview
@Composable
fun BottomPreview() {
    BottomSheetContent()
}
