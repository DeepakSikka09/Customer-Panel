package com.ecomexpress.customerpanel.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.utils.DateTransformation
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
    placeholderText:String="Search",
    function:()->Unit={},
    enable:Boolean=true

) {
    var searchValue by remember { mutableStateOf(text) }

    TextField(
        value = searchValue,
        placeholder = { Text(
            text = placeholderText,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF8C9296),
                textAlign = TextAlign.Center
            )
        ) },
        textStyle = TextStyle(
            fontWeight = FontWeight.W500,
            textDecoration = TextDecoration.None,
            fontSize = 18.sp
        ),
        onValueChange = {

            if (it.length <= 6 && it.all { it.isDigit() }) {
                searchValue = it
                onTextChange(it)
            }
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min)
            .border(width = 1.dp, color = grey1CD, shape = RoundedCornerShape(4.dp))
            .clickable {
                    function()
            }, enabled = enable,


        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = white,
            focusedIndicatorColor = white,
            disabledIndicatorColor = white,
            backgroundColor = Color.Transparent,
            textColor = Color.DarkGray,
            placeholderColor = Color.Gray,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}


@Composable
fun CustomTextField(
    data: String,
    onChange: (String) -> Unit,
    keyBoardType: KeyboardType,
    isError: Boolean,
    labelText: String,
    visualTransformation: VisualTransformation,
    modifier: Modifier? = Modifier,
    isIcon: Boolean = false,
    @DrawableRes iconId: Int = 0,
    iconClicked: () -> Unit = {}
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    if (modifier != null) {

        OutlinedTextField(
            value = data,
            onValueChange = onChange,
            textStyle = TextStyle(
                fontWeight = FontWeight.W500,
                textDecoration = TextDecoration.None,
                fontSize = 21.sp),
            label = {
                Text(
                    text = labelText,
                    style = if (interactionSource.collectIsFocusedAsState().value || data.isNotEmpty())
                        TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,

                        ) else TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.W500,
                        color = grey296
                    ),
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                cursorColor = Color.Black,
            ),

            modifier = modifier
                .fillMaxWidth(),
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            isError = if (interactionSource.collectIsFocusedAsState().value) isError else false,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyBoardType,
            ),
            trailingIcon = {
                if (isIcon && data.isNotEmpty())
                    Image(
                        painter = painterResource(id = iconId),
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            iconClicked()
                        })
            }
        )
    }
}


@Composable
fun CreateShipmentTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    leadingIcon: Int,
    isMobile: Boolean = false,
    keyBoardType: KeyboardType,
    isDate: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = labelText
                )
                if (isMobile) {
                    Spacer(modifier = Modifier.width(2.dp))
                    Box(modifier = Modifier.fillMaxHeight()) {
                        Text(
                            text = "+91 ",
                            style = bottomSheetHelp(grey4F),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .align(
                                    Alignment.Center
                                ),
                        )
                    }
                }
            }
        },
        label = {
            Text(
                text = labelText,
                style = bottomSheetHelp(
                    color = black65
                ),
                textAlign = TextAlign.Start
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = whiteFD,
            focusedLabelColor = blueB7,
            disabledLabelColor = blueB7,
            disabledIndicatorColor = greyD2,
            focusedIndicatorColor = greyD2,
            unfocusedIndicatorColor = greyD2
        ),
        textStyle = bottomSheetHelp(grey4F),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        visualTransformation = if (isDate) DateTransformation() else VisualTransformation.None
    )
}
