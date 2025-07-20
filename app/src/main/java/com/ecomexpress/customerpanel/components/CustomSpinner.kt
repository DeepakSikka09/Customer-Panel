package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F

@Composable

fun CustomSpinner(modifier: Modifier=Modifier,itemList:List<String>) {
    var isDropdownVisible by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf("Select") }
    val dropdownItems = itemList
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp)) {
        TextField(
            value = selectedValue, onValueChange = {},
            enabled = false,
            modifier = modifier
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { isDropdownVisible = !isDropdownVisible },
            textStyle = TextStyle(
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
            trailingIcon = {Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription =null, tint = Color.Black )}
        )

        if (isDropdownVisible) {
            DropdownMenu(
                expanded = isDropdownVisible,
                onDismissRequest = { isDropdownVisible = false }
            ) {
                dropdownItems.forEach { item ->
                    DropdownMenuItem(onClick = {
                        selectedValue = item
                        isDropdownVisible = false
                    }) {
                        Text(item)
                    }
                }
            }

        }
    }
}


@Composable
fun SpinnerExample(labeltxt:String,itemList:List<String>,modifier: Modifier=Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select") }
    val dropdownItems = itemList

    Column(modifier = Modifier.fillMaxWidth())
    {

        CustomSpinnerField(
            data = "$selectedOption",
            onChange = {},
            keyBoardType = KeyboardType.Text,
            isError = false,
            labelText = labeltxt,
            visualTransformation = VisualTransformation.None,
            modifier = modifier.clickable {expanded = !expanded  }



        )
        if (expanded) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                dropdownItems.forEach { item ->
                    DropdownMenuItem(onClick = {
                        selectedOption = item
                        expanded = false
                    }) {
                        Text(item)
                    }
                }
            }

        }

        /*DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            DropdownMenuItem(onClick = {
                selectedOption = "18%"
                expanded = false
            }) {
                Text(text = "18%")
            }
            DropdownMenuItem(onClick = {
                selectedOption = "28%"
                expanded = false
            }) {
                Text(text = "28%")
            }
            DropdownMenuItem(onClick = {
                selectedOption = "24%"
                expanded = false
            }) {
                Text(text = "24%")
            }
        }*/


        /*Icon(
            painter = painterResource(id = R.drawable.down_arrow),
            contentDescription = "Icon",
            modifier = Modifier
                .clickable { expanded = !expanded }
        )*/
        /*OutlinedButton(onClick = { expanded = !expanded }) {
            Text(text = "Toggle Dropdown")
        }*/
    }
}

@Composable
fun CustomSpinnerField(
    data:String,
    onChange:(String)->Unit,
    keyBoardType: KeyboardType,
    isError:Boolean,
    labelText:String,
    visualTransformation: VisualTransformation,
    modifier: Modifier =Modifier
){
    val interactionSource = remember {
        MutableInteractionSource()
    }
    OutlinedTextField(
        value = data,
        enabled = false,
        onValueChange = onChange,
        textStyle = TextStyle(
            fontWeight = FontWeight.W500,
            textDecoration = TextDecoration.None,
            fontSize = 21.sp,
            color = black1A


            ),
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.down_arrow),
                contentDescription = "Icon",
                modifier = modifier


            )
        },


        label = {
            Text(
                text = labelText,
                style = if (interactionSource.collectIsFocusedAsState().value || data.isNotEmpty()) TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,

                    ) else TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                ),
            )
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            cursorColor = Color.Black,
        ),

        modifier =modifier
            .fillMaxWidth(),
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        isError = if(interactionSource.collectIsFocusedAsState().value) isError else false ,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
        )
    )
}








@Preview
@Composable
fun SpinnerPreview() {
    val names = listOf("abc","def","ghk")
    var selectedItem by rememberSaveable() { mutableStateOf("Select") }

    //CustomSpinner(itemList = names)
 //  SpinnerExample()
}


