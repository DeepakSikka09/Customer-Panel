package com.ecomexpress.customerpanel.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ProfileComposable(
    @DrawableRes leadingIcon: Int,
    @DrawableRes laggingIcon: Int,
    phoneNumber: String,
    description: String,
    modifier: Modifier

){
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFFFFFFFF))
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

    ) {
       Image(painter = painterResource(id = leadingIcon), contentDescription ="" )
        Column(modifier = Modifier
            .padding(start = 12.dp)
            .wrapContentHeight()) {
            Text(text = phoneNumber, style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF1A1A1A))
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = description, style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A)
                ))
        }
        Box(
            modifier = Modifier
                .weight(1f)
                ,
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                painter = painterResource(laggingIcon),
                contentDescription = "Your Image",
            )
        }
    }
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(0.5.dp)
        .background(color = Color.LightGray))
    }

@Preview
@Composable
fun Preview(){
    CustomerPanelTheme {
        ProfileComposable(
            R.drawable.frame,
            R.drawable.right_face_arrow,
            "7895413090",
            "I want to Change my Number",
            Modifier.clickable {
            })
    }
}