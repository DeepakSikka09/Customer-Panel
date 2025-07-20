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
import com.ecomexpress.customerpanel.data.local.db.entities.OptionsData
import com.ecomexpress.customerpanel.data.local.db.entities.WalletData

@Composable
fun LazyListOptionsComposable(list: List<OptionsData>) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize(),

                ) {
                items(list) { item ->
                    OfferOptionsComposable(
                        leadingIcon = item.leadingIcon,
                        content = item.content,
                        description = item.description
                    )
                    Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))

                }
            }
        }
    }


}
