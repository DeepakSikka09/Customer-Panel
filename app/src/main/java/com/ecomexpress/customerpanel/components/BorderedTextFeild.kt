package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.ecomexpress.customerpanel.ui.theme.black5B
import com.ecomexpress.customerpanel.ui.theme.black65
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.whiteFD
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelp
import com.ecomexpress.customerpanel.utils.constants.subheading


@Composable
fun BorderedTextFeild(value:String,@DrawableRes leadingIcon :Int?) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp)) {
        TextField(value = value, onValueChange = {},

            modifier = Modifier
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            textStyle =
            TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = grey4F,
            ),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                textColor = Color.DarkGray,
                placeholderColor = Color.Gray,
            ),


            leadingIcon = {
                Icon(
                    painter = painterResource(id = leadingIcon!!),
                    contentDescription = ""
                )
            }
        )

    }
}

@Composable
fun BorderedTextFeild_(value:String,modifier: Modifier=Modifier) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp)) {
        TextField(
            value = value, onValueChange = {},
            enabled = false,


            modifier = modifier
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                .wrapContentHeight()
                .fillMaxWidth()
                ,
            textStyle =
            TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                color = grey4F,
            ),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                textColor = Color.DarkGray,
                placeholderColor = Color.Gray,
            ),
        )


    }
}

@Composable
fun AddItemField(
    value: String,
    onValue:(String)->Unit,
    heading:String,
    keyBoardType:KeyboardType
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = heading, style = bottomSheetHelp(
                color = black5B
            )
        )
        Spacer(modifier = Modifier.height(3.dp))
        TextField(
            value = value,
            onValueChange = onValue,
            modifier = Modifier
                .background(color = whiteFD, shape = RoundedCornerShape(size = 6.dp))
                .border(
                    width = 1.dp,
                    color = black65,
                    shape = RoundedCornerShape(size = 6.dp)
                )
                .wrapContentHeight()
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                backgroundColor = whiteFD,
                textColor = grey4F
            ),
            textStyle = subheading(
                fontSize = 16.sp,
                color = grey4F
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyBoardType
            )
        )
    }
}

@Preview
@Composable
fun calcPreview(){
    CustomerPanelTheme() {
        BorderedTextFeild_(value = "abc")
    }
}