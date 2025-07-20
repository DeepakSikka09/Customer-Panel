package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.utils.constants.CheckBox

@Composable
fun CustomFilterCheckBox(
    text:String,
    check:Boolean,
    onChange:()->Unit
){
    Row(
        modifier = Modifier.padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if(check){
            Image(
                painter = painterResource(
                    id = R.drawable.ic_checkbox
                ),
                contentDescription = "Checked Checkbox",
                modifier = Modifier.pointerInput(Unit){
                    detectTapGestures(
                        onTap = { onChange() }
                    )
                }
            )
        }else{
            Image(
                painter = painterResource(
                    id = R.drawable.ic_uncheckbox
                ),
                contentDescription = "Un-checked Checkbox",
                modifier = Modifier.pointerInput(Unit){
                    detectTapGestures(
                        onTap = { onChange() }
                    )
                }
            )
        }
        Text(
            text = text,
            style = CheckBox,
            modifier = Modifier.padding(start = 15.dp)
        )


    }
}