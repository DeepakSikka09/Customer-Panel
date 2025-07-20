package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.*
import com.ecomexpress.customerpanel.ui.viewModel.RechargeWalletViewModel
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
@Composable
fun RechargeWalletComposable(navController: NavController) {
    Column {
        TextToolbar(title = "Recharge Wallet", navController = navController, false, null, null)
        rechargeWallet()
    }
}
*/


@Composable
fun rechargeWallet(modifier: Modifier,navController: NavController, viewModel: RechargeWalletViewModel, showBottomSheet: (SheetContent) -> Unit, hideBottomSheet: () -> Unit) {

    val rechargeText by viewModel.rechargeText.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    var moveToNextScreen by remember{
        mutableStateOf(false)
    }
     LaunchedEffect(key1 = moveToNextScreen, block ={
         if (moveToNextScreen){

             lifecycleOwner.lifecycleScope.launch {
                 delay(3000)
                 navController.popBackStack()

             }

         }
     } )
    Box(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.White)
    ) {


        Column() {

            /*Column {
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(start = 16.dp, top = 16.dp)
                ) {
                    Text(
                        text = "₹1,080",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(),
                        color = grey4F

                    )
                }
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(start = 16.dp, top = 4.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = "Available Balance",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(), color = greyB7

                    )
                }
            }*/

            Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
                Text(
                    text = "Select amount for quick recharge",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(), color = black1A

                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Most used",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400),
                    color = black1A,

                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                CustomBox(
                    shadowColor = blue16,
                    borderColor = grey1CD,
                    backgroundColor = white,
                    textColor = black1A,
                    textValue = "+ ₹1,000"
                )
                CustomBox(
                    shadowColor = blue16,
                    borderColor = grey1CD,
                    backgroundColor = grey7FE,
                    textColor = black1A,
                    textValue = "+ ₹2,000"
                )
                CustomBox(
                    shadowColor = blue16,
                    borderColor = grey1CD,
                    backgroundColor = white,
                    textColor = black1A,
                    textValue = "+ ₹5,000"
                )

            }
            Box(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 16.dp,
                    bottom = 4.dp
                )
            ) {
              /*  AmountBoxComposable(
                    "₹2,000"
                )*/
                CustomTextField(
                    data =rechargeText ,
                    onChange = {viewModel.setRechargeText(it)},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Enter recharge amount",
                    visualTransformation = VisualTransformation.None
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(end = 20.dp)
            ) {
                Text(
                    text = "Minimum Recharge ₹200",
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        color = greyB7,
                        fontSize = 12.sp
                    ), modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .align(alignment = Alignment.CenterEnd)

                )
            }
           /* Box(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
            ) {
                AmountBoxComposable(
                    leadingIcon = R.drawable.percent,
                    R.drawable.arrow_right,
                    "Apply offer and Discount"
                )
            }*/
/*
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)

            ) {

                Text(
                    text = "Bonus Amount (0%)",
                    style = TextStyle(
                        fontWeight = FontWeight(500),
                        color = grey4F,
                        fontSize = 16.sp
                    )
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "₹500",
                        style = TextStyle(
                            fontWeight = FontWeight(500),
                            color = Color(0xFF404A5B),
                            fontSize = 16.sp
                        )
                    )

                }
            }*/
        /*    Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Added to the wallet after successful recharge",
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        color = greyB7,
                        fontSize = 12.sp
                    ), modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()

                )
            }
            Box(modifier = Modifier.padding(16.dp)) {
                AmountBoxComposable(
                    "Amount to be paid", "₹2,000"
                )
            }*/
//            RechargeButton(text = "Recharge Now")

        }

        Column(modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom) {

            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(grey8B8)
            )

            RechargeButton(text = "Recharge Now"){

                showBottomSheet {
                    rechargeBottomSheet(
                        transactionId = "123456789",
                        navController = navController,
                        hideBottomSheet

                    )
                  moveToNextScreen=true
                }

            }

        }


    }

}
/*@Composable
fun CustomTextField(
    data:String,
    onChange:(String)->Unit,
    keyBoardType: KeyboardType,
    isError:Boolean,
    labelText:String,
    visualTransformation: VisualTransformation
){
    val interactionSource = remember {
        MutableInteractionSource()
    }
    OutlinedTextField(
        value = data,
        onValueChange = onChange,
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.None,


            ),


        label = {
            Text(
                text = labelText,
                style = if (interactionSource.collectIsFocusedAsState().value || data.isNotEmpty()) TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,

                    ) else TextStyle(
                    fontFamily = FontFamily.Default,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                ),
            )
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            cursorColor = Color.Black,
        ),

        modifier = Modifier
            .fillMaxWidth(),
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        isError = if(interactionSource.collectIsFocusedAsState().value) isError else false ,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
        )
    )
}*/


