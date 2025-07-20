package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF

@Composable
fun ActionPendingScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TextToolbar(title = "Action Pending", navController = navController,false,null,null)
        },
        backgroundColor = whiteFF,
        content = {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(it)
                    .background(color = white)
            ) {
                Column (Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(color = white)){

                ShortCutMenu(
                    leadingIcon = R.drawable.ic_ndr_pending,
                    title = "NDR Pending",
                    description = "Non Delivery Report",
                    totalOrder = "50",
                    navController = navController
                )
            }}
        }
    )
}
@Preview
@Composable
fun NPreview()
{
    ActionPendingScreen(navController = rememberNavController())
}
