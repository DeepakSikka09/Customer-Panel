package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.fontFamily


@Composable
fun TextImageDataIformation(
    @DrawableRes leadingImageId: Int,
    title:String,
    city: String,
    date: String,
    modifier: Modifier,
    isLastIndex: Boolean = false,
     isInTransit:Boolean=false,
    showTransitUpdateBottomSheet: () -> Unit,
) {
    val titleStyle =  TextStyle(
        fontSize = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFF1A1A1A),
        )

    val cityStyle=  TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFF1A1A1A),
        )

    val dateStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(400),
        color = Color(0xFF6E7478),
        )

    Row(verticalAlignment = Alignment.Top,modifier = Modifier.height(IntrinsicSize.Min)) {
        Column(verticalArrangement = Arrangement.Top,) {
            Image(
                painter = painterResource(id = leadingImageId),
                contentDescription = "Icon",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            )
            if (!isLastIndex) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.Blue)
                        .align(Alignment.CenterHorizontally)
                        .width(2.dp)
                )
            }
            }
        Column(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(
                text = title,
                style = titleStyle,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start)
            )
            Text(
                text = city,
                style = cityStyle,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start)
            )
            Text(
                text =date,
                style =dateStyle,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start)
            )
            if (isInTransit){
                Text(text = "See All Updates", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                ), modifier = Modifier.padding(start = 8.dp, top = 10.dp).clickable(enabled = true) {
                    showTransitUpdateBottomSheet()
                })
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )
        }
    }
}


@Composable
fun TransitsUpdateComposable(
    @DrawableRes leadingImageId: Int,
    title:String,
    city: String,
    date: String,
    isLastIndex: Boolean = false,
) {
    val titleStyle =  TextStyle(
        fontSize = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFF1A1A1A),
    )

    val cityStyle=  TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFF1A1A1A),
    )

    val dateStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight(400),
        color = Color(0xFF6E7478),
    )

    Row(verticalAlignment = Alignment.Top,modifier = Modifier.height(IntrinsicSize.Min)) {
        Column(verticalArrangement = Arrangement.Top,) {
            Image(
                painter = painterResource(id = leadingImageId),
                contentDescription = "Icon",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            )
            if (!isLastIndex) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = Color.Blue)
                        .align(Alignment.CenterHorizontally)
                        .width(2.dp)
                )
            }
        }
        Column(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(
                text = title,
                style = titleStyle,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Start)
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = city,
                    style = cityStyle,
                    modifier = Modifier
                        .padding(start = 8.dp)

                )
                Spacer(modifier = Modifier.width(1.dp).fillMaxHeight().padding(bottom = 10.dp, start = 5.dp).background(color = Color.Black))
                Text(
                    text =date,
                    style =dateStyle,
                    modifier = Modifier
                        .padding(start = 8.dp).wrapContentWidth()
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )
        }
    }
}

@Preview
@Composable
fun ShowPreview(){
    TextImageDataIformation(
        leadingImageId = R.drawable.dots,
        title = "Information Received",
        city = "Bengluru-BLR",
        date = "02May ,2023 09:33 hrs",
        isLastIndex = false,
        modifier = Modifier,
        showTransitUpdateBottomSheet = {}
    )
}

