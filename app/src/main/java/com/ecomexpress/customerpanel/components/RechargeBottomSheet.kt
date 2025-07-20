package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.greyB7
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import androidx.compose.foundation.Image

@Composable
fun rechargeBottomSheet(
    transactionId: String,
    navController: NavController,
    hideBottomSheet: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            ), verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Column {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.charm_tick),
                        contentDescription = null)
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Wallet Recharge successfully",
                    style = heading(black1A,21.sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Transaction ID",
                    style = subheading(black1A,14.sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = transactionId,
                    style = subheading(black1A,16.sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }


    }
}

@Preview
@Composable
fun RechargeBottomPreview()
{
    rechargeBottomSheet(transactionId = "22338262893", navController = rememberNavController() ) {
        
    }
}

