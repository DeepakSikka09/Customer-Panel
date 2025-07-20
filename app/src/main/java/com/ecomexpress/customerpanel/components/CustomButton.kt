package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.blue16
import com.ecomexpress.customerpanel.ui.theme.blueCC6
import com.ecomexpress.customerpanel.ui.theme.blueE0
import com.ecomexpress.customerpanel.ui.theme.green9e
import com.ecomexpress.customerpanel.ui.theme.grey1CD
import com.ecomexpress.customerpanel.ui.theme.grey400
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey7FE
import com.ecomexpress.customerpanel.ui.theme.grey8B8
import com.ecomexpress.customerpanel.ui.theme.greyD2
import com.ecomexpress.customerpanel.ui.theme.greyFF
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFD
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.utils.constants.CustomButton
import com.ecomexpress.customerpanel.utils.constants.buttonText
import com.ecomexpress.customerpanel.utils.constants.packetNotSelectButton
import com.ecomexpress.customerpanel.utils.constants.packetTypeButton
import com.ecomexpress.customerpanel.utils.constants.selectedPaymentType
import com.ecomexpress.customerpanel.utils.constants.selectedView
import com.ecomexpress.customerpanel.utils.constants.unselectedPaymentType
import com.ecomexpress.customerpanel.utils.constants.unselectedView
import com.ecomexpress.customerpanel.utils.enums.NdrTypeEnum

@Composable
fun CircularButton(
    text: String?,
    icon: Int?,
    iconDescription: String?,
    bgColor: Color,
    modifier: Modifier = Modifier,
    onClick: ((Offset) -> Unit)?,
    onProfileClick: ((Offset) -> Unit)?
) {
    Card(
        modifier = modifier.padding(5.dp), shape = CircleShape, content = {
            text?.let {
                Text(
                    text = it,
                    style = CustomButton,
                    modifier = Modifier
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = onProfileClick
                            )
                        }
                )
            }
            icon?.let {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = iconDescription,
                    modifier =
                    Modifier
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = onClick
                            )
                        }

                )
            }

        },
        backgroundColor = bgColor,
        elevation = 0.dp
    )
}

@Composable
fun CircularProfileButton(
    text: String?,
    icon: Int?,
    iconDescription: String?,
    bgColor: Color,
    modifier: Modifier = Modifier,
    onClick: ((Offset) -> Unit)?,
    onProfileClick: ((Offset) -> Unit)?
) {
    Card(
        modifier = modifier.padding(5.dp), shape = CircleShape, content = {
            text?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 40.sp,
                        lineHeight = 100.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = white,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = onProfileClick
                            )
                        }
                )
            }
            icon?.let {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = iconDescription,
                    modifier =
                    Modifier
                        .padding(start = 7.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = onClick
                            )
                        }

                )
            }

        },
        backgroundColor = bgColor,
        elevation = 0.dp
    )
}

@Composable
fun SearchButton(
    text: String?,
    imageId: Int?,
    modifier: Modifier = Modifier,
    function: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = function,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = blue408f),
        shape = RoundedCornerShape(6.dp),
        enabled = enabled
    ) {
        if (imageId != null) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null, // Provide a content description if required
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        if (text != null) {
            Text(
                text = text,
                color = Color.White,
                style = buttonText( color = white)
            )
        }
    }
}

@Composable
fun ShareButton(function: () -> Unit) {
    Button(
        onClick = function,
        modifier = Modifier
            .height(50.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(6.dp))
            .wrapContentWidth(align = Alignment.End)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(size = 6.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = whiteFF,
            contentColor = Color.Black
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "Share Icon",
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Share File",
                maxLines = 1
            )
        }
    }
}

@Composable
fun TwoRowsWithButton(onButtonClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "AWB No. | Order No. ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = grey4F,
                )
            )
            Button(
                onClick = onButtonClick,
                modifier = Modifier.padding(end = 0.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Help")
                    Image(
                        painter = painterResource(R.drawable.ic_help),
                        contentDescription = "Trailing Icon",
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(2.dp),
                    )
                }
            }
        }
        Text(
            text = "5708301471 | AS56896456",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = grey4F,
            )
        )
    }
}

@Composable
fun LogInButton(function: () -> Unit, value: String,modifier: Modifier=Modifier) {
    Button(

        onClick = function,
        modifier = modifier
            .fillMaxWidth()
            .padding()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = blue408f),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = value,
            style = buttonText( color = white)
        )
    }
}

@Composable
fun CustomPacketTypeButton(
    type: String,
    modifier: Modifier,
    onPress: ((Offset) -> Unit)
) {
    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = onPress,
                )
            }
    ) {
        Text(
            text = type,
            style = packetTypeButton,
        )
    }
}

@Composable
fun CustomTypeButton(
    type: String,
    isSelected: Boolean,
    onPress: ((Offset) -> Unit)
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Max)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = onPress,
                )

            },

        ) {
        if (isSelected)
        {
            Text(
                text = type,
                style = packetTypeButton,
                modifier = Modifier.padding(horizontal =  20.dp)
            )
        }
        else
        {
            Text(
                text = type,
                style = packetNotSelectButton,
                modifier = Modifier.padding(horizontal = 20.dp)

            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if ( isSelected)
            Divider(modifier = Modifier.fillMaxWidth(),thickness = 2.dp, color = blueCC6 )

        else
            Divider(modifier = Modifier.fillMaxWidth(),thickness = 2.dp, color = grey7FE )
    }
}


@Composable
fun ShortCutButton(icon: Int, title: String, cashAmount: String?, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(painter = painterResource(id = icon), contentDescription = title)
        Text(
            text = title, style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = black1A,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 5.dp)
        )
        cashAmount?.let {
            Box(
                modifier = Modifier
                    .background(color = green9e, shape = RoundedCornerShape(size = 50.dp))
                    .padding(start = 6.dp, end = 6.dp)
            ) {
                Text(
                    text = it, style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = white,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(vertical = 3.dp, horizontal = 6.dp)
                )
            }
        }

    }
}

@Composable
fun RechargeButton(text: String?, function: () -> Unit) {
    Button(
        onClick = function,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            /*.shadow(
                elevation = 4.dp,
                spotColor = grey400,
                ambientColor = grey400
            )*/

            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = blue408f),
        shape = RoundedCornerShape(6.dp)

    ) {
        Text(
            text = text!!,
            color = Color.White,
            fontSize = 21.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontWeight = FontWeight(600)
        )
    }
}

@Composable
fun SearchWalletButton(text: String?, function: () -> Unit) {
    Button(
        onClick = function,
        modifier = Modifier
            .padding(start = 10.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .wrapContentWidth()


            .height(35.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = blueCC6),
        shape = RoundedCornerShape(36.dp)

    ) {
        Text(
            text = text!!,
            color = Color.White
        )
    }
}

@Composable
fun CustomPaymentType(
    onClick:()->Unit,
    paymentSelected:Int,
    icon:Int,
    title:String,
    paymentValue: Int
    ){
    Row(
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = blue16,
                ambientColor = blue16
            )
            .border(
                width = 1.dp,
                color = if(paymentSelected == paymentValue) grey7FE else grey1CD,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .background(
                color = if(paymentSelected == paymentValue) grey7FE else white,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
            .clickable {
                       onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(paymentSelected == paymentValue)
        {
        Image(
            painter = painterResource(id = R.drawable.selected_radio),
            contentDescription = "order cod"
        )
        }
        else
        {
        Image(
            painter = painterResource(id = R.drawable.unselected_radio),
            contentDescription = "order cod"
        )
        }

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            style = if(paymentSelected == paymentValue) selectedPaymentType else unselectedPaymentType
        )
    }
}

@Composable
fun BlueButton(
    isEnable:Boolean,
    onClick: () -> Unit,
    btnText:String,
    modifier: Modifier = Modifier,
    color: Color?= grey8B8,
    textColor:Color?= white
){
    Button(
        onClick = onClick,
        content = {
            Text(
                text = btnText,
                style = buttonText(color =textColor!!)
            )
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color!!,
            contentColor = Color.White,
            disabledBackgroundColor = greyD2
        ),
        enabled = isEnable,

        shape = RoundedCornerShape(size = 6.dp),
        modifier = modifier
    )
}





