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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.*

@Composable
fun AmountBoxComposable(
   @DrawableRes leadingIcon:Int,
   @DrawableRes laggingIcon:Int,
   phoneNumber:String

){ Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = whiteFD,
                shape = RoundedCornerShape(size = 6.dp))
            .border(
                width = 1.dp,
                color = black65,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

    ) {
       Image(painter = painterResource(id = leadingIcon), contentDescription ="" )

    Text(text = phoneNumber,style = TextStyle(fontWeight = FontWeight(700),color = greyB7,fontSize = 14.sp))

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                painter = painterResource(laggingIcon),
                contentDescription = "",
            )
        }
    }

    }

@Composable
fun AmountBoxComposable(
    leadingString:String,
    laggingString:String

){ Row(
    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = greyFF, shape = RoundedCornerShape(size = 6.dp))
        .border(width = 1.dp, color = blueE0, shape = RoundedCornerShape(size = 6.dp))
        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

) {

    Text(text = leadingString,style = TextStyle(fontWeight = FontWeight(500),color = blueE0,fontSize = 16.sp))

    Box(
        modifier = Modifier
            .weight(1f)
            .padding(end = 8.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(text = laggingString,style = TextStyle(fontWeight = FontWeight(500),color = blueE0,fontSize = 16.sp))

    }
}

}

@Composable
fun AmountBoxComposable(
    leadingString:String,

){ Row(
    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = whiteFD, shape = RoundedCornerShape(size = 6.dp))
        .border(width = 1.dp, color = black65, shape = RoundedCornerShape(size = 6.dp))
        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

) {

    Text(text = leadingString,style = TextStyle(fontWeight = FontWeight(500),color = grey4F,fontSize = 16.sp))


}

}

@Preview
@Composable
fun AmtPreview(){
    CustomerPanelTheme {
        AmountBoxComposable(leadingString = stringResource(R.string.amount_to_be_paid))
    }
}