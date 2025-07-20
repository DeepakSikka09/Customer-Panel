package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.blueE0
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.greyB7
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.utils.constants.heading

@Composable
fun ShipmentItemSwitch(
    headingTxt:String,
    isCheck:Boolean,
    onCheckChange:(Boolean)->Unit
){
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = headingTxt,
            style = heading(
                color = black1A,
                fontSize = 18.sp
            )
        )
        Switch(
            checked = isCheck,
            onCheckedChange = onCheckChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = white,
                checkedTrackColor = blueE0,
                uncheckedTrackColor = greyB7,
                uncheckedThumbColor = greyB7,
            ),
        )
    }
}