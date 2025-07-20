package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.greyD2

val modifier:Modifier=Modifier
    .border(
        width = 1.dp,
        color = black1A,
        shape = RoundedCornerShape(6.dp)
    )
    .width(36.dp)
    .height(36.dp)
    .background(color = Color.White, shape = RoundedCornerShape(6.dp))
    .padding(8.dp)




@Composable
fun KgPlusBox(@DrawableRes icon:Int?,onClick:()->Unit={}){
    Box(modifier = modifier.
        clickable {
            onClick()
        }) {
        Icon(painter = painterResource(icon!!), contentDescription ="" ) }

}

@Composable
fun KgMinusBox(@DrawableRes icon:Int?,onClick:()->Unit={}){
    Box(modifier = modifier.
    clickable {
        onClick()
    }) {
        Icon(painter = painterResource(icon!!), contentDescription ="" ) }

}

@Composable
fun GramPlusBox(@DrawableRes icon:Int?,onClick:()->Unit={}){
    Box(modifier = modifier.
    clickable {
        onClick()
    }) {
        Icon(painter = painterResource(icon!!), contentDescription ="" ) }

}

@Composable
fun GramMinusBox(@DrawableRes icon:Int?,onClick:()->Unit={}){
    Box(modifier = modifier.
    clickable {
        onClick()
    }) {
        Icon(painter = painterResource(icon!!), contentDescription ="" ) }

}


