package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.R


@Composable
fun imageComposable() {
    Column {
        Image(painter = painterResource(id = R.drawable.ellipse_38), contentDescription ="" )
        Spacer(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .height(30.dp)
            .width(2.dp)
            .background(color = Color.Black))

    }
}
@Preview
@Composable
fun imagePreview(){
    imageComposable()
}