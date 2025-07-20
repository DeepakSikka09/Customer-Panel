package com.ecomexpress.customerpanel.utils.constants

import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.black65
import com.ecomexpress.customerpanel.ui.theme.blueE0
import com.ecomexpress.customerpanel.ui.theme.green9e
import com.ecomexpress.customerpanel.ui.theme.grey4F
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.*

fun heading(color: Color, fontSize: TextUnit = 14.sp) = TextStyle(
    fontSize = fontSize,
    fontFamily = fontFamily,
    fontWeight = FontWeight(700),
    color = color

    )
fun text (color: Color, fontSize: TextUnit = 14.sp) = TextStyle(
    fontSize = fontSize,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight(400),
    color = color

    )

fun subheading (color: Color, fontSize: TextUnit = 14.sp) = TextStyle(
    fontSize = fontSize,
    fontFamily = FontFamily(Font(R.font.roboto_medium)),
    fontWeight = FontWeight(500),
    color = color,


    )
fun buttonText (color: Color, fontSize: TextUnit = 21.sp) = TextStyle(
    fontSize = fontSize,
    color = color,
    fontFamily = fontFamily,
    fontWeight = FontWeight(600),
    textAlign = TextAlign.Center,
)

val orderTypeHeading = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = grey478,
    textAlign = TextAlign.Center,
)



val orderTypeAWB = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = blueCC6,
    textDecoration = TextDecoration.Underline,
)

val orderTypeValue = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = black1A,
    textAlign = TextAlign.Center,

    )

val orderAwbValue = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = blueCC6,
    textAlign = TextAlign.Center,
    textDecoration = TextDecoration.Underline,

    )
val searchHeading = TextStyle(
    fontSize = 21.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(700),
    color = black1A,
    textAlign = TextAlign.Start
)

fun text(color: Color) = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = color
)

val textSearch = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = black1A,
)






fun textSearchResultLower(color:Color = grey4F) = TextStyle(
    fontSize = 12.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = color,
)



val packetTypeButton = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = black1A,
    textAlign = TextAlign.Center,
)

val packetNotSelectButton = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = grey478,
    textAlign = TextAlign.Center,
)

fun bottomSheetHelp(color: Color) = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = color
)
 var bottomSheetHelpOne = TextStyle(
     fontSize = 14.sp,
     fontFamily = fontFamily,
     fontWeight = FontWeight(400),
     color = grey4F,
 )
var bottomSheetHelpTwo  = TextStyle(
    fontSize = 20.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = grey4F,
)
var bottomSheetHelpThree = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),

)
var Calender = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = grey4F,
)
var CustomButton = TextStyle(
    fontSize = 18.sp,
    lineHeight = 100.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = white,
    textAlign = TextAlign.Center,
)
var CheckBox = TextStyle(
    fontSize = 18.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = black1A,
)
var customDashBoardBox = TextStyle(
    fontSize = 21.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(600),
    color = black1A,
)
var customDashBoardBoxOne = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(400),
    color = black1A,

)

var selectedPaymentType = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = black1A,
    textAlign = TextAlign.Center,
)

var unselectedPaymentType = TextStyle(
    fontSize = 14.sp,
    fontFamily = fontFamily,
    fontWeight = FontWeight(500),
    color = black1A,
    textAlign = TextAlign.Center,
)

