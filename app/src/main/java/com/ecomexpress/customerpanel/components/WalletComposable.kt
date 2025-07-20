package com.ecomexpress.customerpanel.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.data.local.db.entities.WalletData
import com.ecomexpress.customerpanel.ui.theme.*

@Composable
fun WalletComposable(
    @DrawableRes leadingIcon: Int,
    shipmentCharge: String,
    date: String,
    rupees: String,
    type: String,
    awb: String

) {
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = white
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically


    ) {
        Image(painter = painterResource(id = leadingIcon), contentDescription = "")
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .wrapContentHeight()
        ) {
            Text(
                text = shipmentCharge,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                color = black1A,
                modifier = Modifier.padding(bottom = 5.dp)
            )


            Text(text = awb,style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = black1A,
            ))
        }
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .wrapContentHeight()
                .weight(1f),
            horizontalAlignment = Alignment.End
        ) {
           /* if (type == "plus") {
                Text(
                    text = rupees,
                    fontWeight = FontWeight.Bold,
                    color = green9e,
                    fontSize = 20.sp
                )

            } else {*/
            Text(
                text = rupees,
                color = black1A,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                modifier = Modifier.padding(bottom = 5.dp)

            )
            Text(
                text = date,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight(400),
                color = black1A,
                textAlign = TextAlign.Right,

                )

           // }





        }


    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.LightGray)
    )
}

@Preview
@Composable
fun WalletPreview() {
    CustomerPanelTheme {
        WalletComposable(
            R.drawable.rsicon, "Wallet Recharge", "25 May, 2023", "+ ₹780", "plus","AWB: 1942298362"
        )
       // WalletComposable(R.drawable.rsiconblack,"Shipment Charge","25 May, 2023", rupees = "- ₹180","minus","AWB: 1942298362")

    }
}