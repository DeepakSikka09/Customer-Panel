package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.CircularButton
import com.ecomexpress.customerpanel.components.CircularProfileButton
import com.ecomexpress.customerpanel.components.LazyListComposable
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.data.local.db.entities.listOfProfileItem
import com.ecomexpress.customerpanel.ui.theme.ProfileButtonColor
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.blueB7
import com.ecomexpress.customerpanel.ui.theme.grey478
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.constants.text

@Composable
fun <ProfileViewModel> ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel) {
    Scaffold(
        topBar = {
            TextToolbar(
                title = "Profile",
                navController = navController,
                false,
                null,
                null
            )
        }
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = white),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(color = grey6FF)
            ) {

                Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)) {
                    CircularProfileButton(
                        text = "SS",
                        icon = null,
                        iconDescription = null,
                        bgColor = ProfileButtonColor,
                        onClick = null,
                        onProfileClick = null,
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(text = "Sandeep Singh", style = subheading(black1A,20.sp))
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "95433", style = subheading(black1A,20.sp))
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Shipper Code",style = text(grey478)
                        )
                    }
                }
                LazyListComposable(list = listOfProfileItem, navHostController = navController)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .background(color = Color.White)
                    .padding(15.dp)
            ) {
                Text(
                    text = "Version 1.0",
                    style = text(black1A, 14.sp),
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .background(color = Color.White),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview()
{
    ProfileScreen(navController = rememberNavController(), viewModel = null)
}

