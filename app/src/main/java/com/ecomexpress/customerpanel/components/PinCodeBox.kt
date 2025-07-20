package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.green9e
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.ui.view.PinCodeScreen
import androidx.compose.ui.text.font.FontWeight
import com.ecomexpress.customerpanel.ui.theme.white

@Composable
fun PinCodeCard() {
    Column(
        modifier = Modifier.fillMaxWidth().background(white).padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "State",
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),

                    fontSize = 16.sp
                )
                Text(
                    text = "Tamil Nadu",
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 18.sp
                )
            }
            Column(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "District",
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = 16.sp
                )
                Text(
                    text = "Thiruvarur",
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),

                    fontSize = 18.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = whiteFF, shape = RoundedCornerShape(size = 8.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               /* Image(
                    painter = painterResource(id = R.drawable.ic_tick),
                    contentDescription = "Image",
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                )*/
                Text(
                    text = "609608",
                    modifier = Modifier.padding(top = 20.dp),
                    color = black1A,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),

                    fontSize = 27.sp
                )
                Text(
                    text = "Ubayavedanthapuram",
                    modifier = Modifier.padding(top = 15.dp),
                    color = black1A,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400),
                    fontSize = 21.sp
                )
                Text(
                    text = "Pincode is serviceable",
                    modifier = Modifier.padding(top = 15.dp, bottom = 20.dp),
                    color = black1A,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),
                    fontSize = 21.sp
                )
            }
        }
    }

}

@Composable
fun PinCodeDelivery(pickup:String,check:String) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().background(white).padding(20.dp)
        ) {

                Text(
                    text = pickup,
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),

                    fontSize = 21.sp
                )

                Text(
                    text = check,
                    modifier = Modifier.padding(top = 2.dp),
                    color = black1A,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 21.sp
                )


        }



}
@Preview
@Composable
fun PinCodePreview()
{
    PinCodeCard()
}


