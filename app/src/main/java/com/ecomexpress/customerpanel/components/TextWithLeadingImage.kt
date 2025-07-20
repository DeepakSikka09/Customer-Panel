package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TextWithLeadingImage(
    text: String,
    @DrawableRes leadingImageId: Int,
    modifier: Modifier = Modifier,
    style: TextStyle?
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Image(
            painter = painterResource(id = leadingImageId),
            contentDescription = "Leading Image",
            modifier = Modifier
                .height(22.dp)
                .width(22.dp)
        )
        Spacer(modifier = Modifier.width(11.dp))
        //Spacer(modifier = Modifier.height(30.dp))

        if (style != null) {
            Text(text = text, style = style)
        }

    }
}
