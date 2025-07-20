package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ecomexpress.customerpanel.data.local.db.entities.ProfileData
import com.ecomexpress.customerpanel.ui.view.ProfileComposable


@Composable
fun LazyListComposable(list: List<ProfileData>, navHostController: NavController) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(color = Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize(),

                ) {
                items(list) { item ->
                    ProfileComposable(
                        leadingIcon = item.leadingIcon,
                        laggingIcon = item.laggingIcon,
                        phoneNumber = item.phoneNumber,
                        description = item.description,
                        Modifier.clickable {
                            if (item.screen!=""){
                                navHostController.navigate(item.screen)

                            }
                        }
                    )

                }
            }
        }
    }
}