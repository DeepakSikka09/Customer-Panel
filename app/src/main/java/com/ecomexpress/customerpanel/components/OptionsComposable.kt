package com.ecomexpress.customerpanel.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.data.local.db.entities.listOfOptionsItem
import com.ecomexpress.customerpanel.data.local.db.entities.listOfWalletItem
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.ecomexpress.customerpanel.ui.theme.grey400
import com.ecomexpress.customerpanel.ui.theme.white

@Composable
fun options(){
            Column(verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .shadow(elevation = 4.dp, spotColor = grey400, ambientColor = Color(0x40000000))
                .background(color = white,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp, bottomEnd = 0.dp, bottomStart = 0.dp))
                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 20.dp)
            ) {

                Box( contentAlignment = Alignment.Center,modifier = Modifier.fillMaxWidth().wrapContentHeight().padding( 16.dp)) {
                    Text(
                        text = "Best Offers For You",
                        fontWeight = FontWeight.Normal,
                         fontSize = 14.sp,
                    )
                }

                LazyListOptionsComposable(list = listOfOptionsItem)
            }




}




@Preview(showBackground = true)
@Composable
fun DPreview() {
    CustomerPanelTheme {

options()

    }
}