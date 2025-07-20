package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.ui.theme.grey400
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.utils.constants.customDashBoardBox
import com.ecomexpress.customerpanel.utils.constants.customDashBoardBoxOne

@Composable
fun CustomDashBoardBox(icon:Int,value:String,title:String,modifier: Modifier){
    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                spotColor = grey400,
                ambientColor = grey400
            )
            .height(120.dp)
            .background(color = white, shape = RoundedCornerShape(size = 6.dp))
    ){
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 15.dp).fillMaxHeight()
        ) {
            Image(painter = painterResource(id = icon), contentDescription = "$icon")
            Text(
                text = value,
                style = customDashBoardBox
            )
            Text(
                text = title,
                style = customDashBoardBoxOne

            )

        }
    }
}