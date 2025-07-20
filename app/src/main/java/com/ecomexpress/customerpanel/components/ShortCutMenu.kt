package com.ecomexpress.customerpanel.components

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.greyB7
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.view.ActionPendingScreen
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelp
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.textSearchResultLower
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable
fun ShortCutMenu(
    @DrawableRes leadingIcon: Int,
    title: String,
    description: String,
    totalOrder: String,
    navController: NavController

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = white)
            .clickable {
                navController.navigate(ScreenEnum.NdrScreen.name)
            },
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Image(painter = painterResource(id = leadingIcon), contentDescription = "")
            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .wrapContentHeight()
            ) {
                Text(text = title, style = bottomSheetHelp(color = black1A),fontSize = 18.sp,fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500) )
                Text(text = description, style = textSearchResultLower(color = black1A),fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight(400))
            }
        }
        Row(
            modifier = Modifier
                .padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = totalOrder, style = heading(color = black1A, fontSize = 21.sp),
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500) )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Your Image",
            )
        }
    }


}
@Preview
@Composable
fun NPview()
{
    ShortCutMenu(R.drawable.arrow_right,"QQ","qq","77",navController = rememberNavController())
}
