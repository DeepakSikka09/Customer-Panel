package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.data.local.db.entities.listOfWalletItem
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.greyB7
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable
fun WalletScreen(
    showBottomSheet: (SheetContent) -> Unit,
    hideBottomSheet: () -> Unit,
    homeNavHostController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Column() {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .padding(start = 20.dp, top = 20.dp)
                            ) {
                                Text(
                                    text = "₹1,080",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .wrapContentHeight(),
                                    color = black1A

                                )
                            }
                            Box(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .padding(start = 16.dp, bottom = 16.dp)
                            ) {
                                Text(
                                    text = "Available Balance",
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                    fontWeight = FontWeight(400),
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .wrapContentHeight(), color = black1A

                                )
                            }
                        }
                        SearchWalletButton(text = "Recharge Wallet") {
                            homeNavHostController.navigate(ScreenEnum.RechargeWallet.name)
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = grey6FF).padding(20.dp)
                )  {
                    Text(
                        text = "May 2023",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(), color = black1A
                    )
                }
                LazyListWalletComposable(list = listOfWalletItem)
            }
        }
    }
}

@Preview
@Composable
fun WalletPreview()
{
    WalletScreen(showBottomSheet =  {sheet->

    }, hideBottomSheet = { /*TODO*/ }, homeNavHostController = rememberNavController())
}
