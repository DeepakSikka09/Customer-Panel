package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.greyB7

@Composable
fun WeightCalcComposable(kilogramCount:String,weightText: String,onPlusClick:()->Unit={},onMinusClick:()->Unit={},modifier: Modifier=Modifier)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(end = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()

        ) {
            KgMinusBox(R.drawable.minus_,onMinusClick)
           // Spacer(modifier = Modifier.width(10.dp))
            Text(text = kilogramCount)
           // Spacer(modifier = Modifier.width(10.dp))
            KgPlusBox(R.drawable.plus_,onPlusClick)
        }
       WeightText(weightText = weightText)
    }
}

@Composable
fun GramWeightComposable(gramCount:String,weightText: String,onPlusClick:()->Unit={},onMinusClick:()->Unit={},modifier: Modifier=Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(start = 12.dp)
    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            GramMinusBox(R.drawable.minus_,onMinusClick)
           // Spacer(modifier = Modifier.width(15.dp))
            Text(text = gramCount)
           // Spacer(modifier = Modifier.width(15.dp))
            GramPlusBox(R.drawable.plus_,onPlusClick)
        }
        WeightText(weightText = weightText)
    }

}

@Composable
fun WeightText(weightText:String){
    Text(
        text = weightText,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight(400),
            color = Color(0xFF1A1A1A),
            textAlign = TextAlign.Center,
        )
    )
}