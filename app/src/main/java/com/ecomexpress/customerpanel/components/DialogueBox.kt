package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ecomexpress.customerpanel.ui.theme.*

@Composable
fun CenteredImageWithTextAndButtons(
    onDismiss: () -> Unit,
    isYesClicked:()->Unit={},
    isNoClicked:()->Unit={}
) {
    var isYesSelected by remember {
        mutableStateOf(true)
    }
    var isNoSelected by remember {
        mutableStateOf(false)
    }
    Dialog(onDismissRequest = {
        onDismiss()
    }) {

        Column(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(320.dp)
                .height(201.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))
                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Are you sure you want to cancel this order?",
                style = TextStyle(
                    fontSize = 20.sp,
                    // fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(500),
                    color = grey4F,
                   textAlign = TextAlign.Center,

                ),
                modifier = Modifier.padding(start = 20.dp , end = 20.dp, bottom = 30.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
               ActionButton(value = "No", onDismiss = onDismiss, modifier = Modifier.weight(1f).padding(end = 5.dp), backgroundColor = blue0f8, textColor = grey478, function = {isNoSelected=!isYesSelected}, actionClicked = onDismiss)
               // Spacer(modifier = Modifier.width(5.dp)) // Add space between the buttons
                ActionButton(value = "Yes", onDismiss = onDismiss, modifier = Modifier.weight(1f).padding(start = 5.dp), backgroundColor = blue408f, textColor = Color.White,function = {isNoSelected=!isYesSelected}, actionClicked = isYesClicked)

            }
        }
    }
}

@Composable
fun ActionButton(modifier: Modifier=Modifier,value:String,backgroundColor: Color,onDismiss: () -> Unit,textColor: Color,function:()->Unit={},actionClicked:()->Unit={},
){
    Button(
        onClick = {
            actionClicked()
            //onDismiss() // Close the dialog when "No" button is clicked
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor, contentColor = Color.Black
        ),
        modifier = modifier
            .height(55.dp)
            .background(shape = RoundedCornerShape(6.dp), color = backgroundColor)
            .shadow(
                elevation = 4.dp, shape = RoundedCornerShape(size = 6.dp)
            )
    ) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 21.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color =textColor,
                textAlign = TextAlign.Center,
            )
        )
    }
}


@Preview
@Composable
fun showDialog() {
    CenteredImageWithTextAndButtons ({}){

    }
}




