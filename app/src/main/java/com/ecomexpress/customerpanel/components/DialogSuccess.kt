package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.utils.constants.buttonText
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.subheading

@Composable
fun dialogSuccess(

) {
    Dialog(onDismissRequest = {  }) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            modifier = Modifier
                .width(320.dp)
                .height(331.dp)
        ) {

                Column(){

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(20.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cross),
                            contentDescription = "Centered Image",
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_wallet),
                            contentDescription = "Centered Image",
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Wallet Recharge\n" +
                                    "successfully",
                            style = subheading(Color(0xFF35374F),20.sp),textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 0.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Transaction ID",
                            style = subheading(Color(0xFF8899B7),14.sp),
                                textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 0.dp)
                        )

                        Text(
                            text = "22338262893",
                            style = heading(Color(0xFF35374F),16.sp),
                                textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 0.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp)) // Vertical spacing between text and buttons
                        Button(
                            onClick = { /* Handle button click here */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                            shape = RoundedCornerShape(8.dp)

                        ) {
                            Text(
                                text = "Go Back to Home"!!,
                                style = buttonText(Color(0xFFFFFFFF),18.sp),
                                    textAlign = TextAlign.Center,
                                )
                        }
                    }
                }
        }
    }
}
@Preview
@Composable
fun dialogPreview(){
    CustomerPanelTheme {
        dialogSuccess()
    }
}
