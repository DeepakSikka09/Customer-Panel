package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.data.local.db.entities.WalletData

@Composable
fun LazyListWalletComposable(list: List<WalletData>) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(color = Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize(),

                ) {
                items(list) { item ->

                    WalletComposable(
                        leadingIcon = item.leadingIcon,
                        shipmentCharge = item.shipmentCharge,
                        date = item.date,
                        rupees = item.rupees,
                        type=item.type,
                        awb=item.awb
                    )

                }
            }
        }
    }


}