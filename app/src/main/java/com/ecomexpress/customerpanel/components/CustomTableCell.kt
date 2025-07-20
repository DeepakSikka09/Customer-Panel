package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.ui.theme.black65
import com.ecomexpress.customerpanel.ui.theme.grey1CD

@Composable
fun RowScope.RowCell(
    text: String,
    textStyle: TextStyle,
    borderWidth: Dp,
    rowWeight:Float,
    toShowBorder:Boolean=true
) {
    Box(
        modifier = Modifier
            .weight(rowWeight)
            .height(50.dp)
    ) {

        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 2.dp)
                .align(Alignment.Center),
            style = textStyle,
            textAlign = TextAlign.Center
        )
        if (toShowBorder){
            Divider(
                color = grey1CD,
                thickness = borderWidth,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }

    }
}
