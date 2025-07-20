package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.constants.text



@Composable
fun BottomSheetCharges(
    icon_top: Int,
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            )
            .width(360.dp)
            .height(169.dp)
            .background(
                color = white,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Why Estimate Charges",
                    style = subheading(Color(0xFF35374F), 16.sp),
                )
                Spacer(modifier = Modifier.width(6.dp))
                // Row with Image and Main Text
                Image(
                    painter = painterResource(id = icon_top),
                    contentDescription = "Icon_top",
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Volumetric/Dead Weight Whichever Is High. This Is An Indicative Price Only. Actual Cost Will Be Present In The Bill.",
                style = text(Color(0xFF35374F), 16.sp),
                lineHeight = 22.sp
            )
        }
    }
}


