package com.ecomexpress.customerpanel.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.greyB7
import com.ecomexpress.customerpanel.ui.theme.whiteFD

@Composable
fun OfferOptionsComposable(
    @DrawableRes leadingIcon:Int,
    content:String,
    description:String,


){

    Box(modifier = Modifier.fillMaxWidth().wrapContentHeight()
        .shadow(elevation = 2.dp, spotColor = Color(0x40161616), ambientColor = Color(0x40161616))
        .background(color = whiteFD, shape = RoundedCornerShape(size = 10.dp)))

    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(7.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, top = 8.dp)   ) {
                Image(painter = painterResource(id = leadingIcon), contentDescription = "",Modifier.padding(5.dp))
                Text(
                    text = content,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFB861A),
                    fontSize = 20.sp,

                    modifier = Modifier.padding( 2.dp)
                )


            }
            Box(
                     modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                         .padding(start = 16.dp)
            ) {
                Text(text = description, fontWeight = FontWeight.Normal,
                    color = grey4F
                    ,fontSize = 12.sp)

            }
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight().padding(top = 8.dp, bottom = 8.dp)
            ) {
                Text(text = "Tap to Apply", fontWeight = FontWeight.Normal,
                    color = greyB7
                    ,fontSize = 14.sp)

            }
         }


    }



}

@Preview
@Composable
fun OfferOptionsPreview(){
    CustomerPanelTheme {
        OfferOptionsComposable(R.drawable.offer,"500WALLET","GET ₹500 Bonus on ₹2000 wallet Recharge")
    }
}