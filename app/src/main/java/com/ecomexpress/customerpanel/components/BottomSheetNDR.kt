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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
import com.ecomexpress.customerpanel.ui.view.NdrScreen
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.constants.text
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable
fun bottomSheetNDR(
    awbNo: String,
    productType: String,
    navController: NavController,
    hideBottomSheet: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
            )
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        // First Row

            Column(modifier=Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "AWB: "+awbNo,
                    style = heading(black1A,21.sp)

                )
                Text(
                    text = productType,
                    style = text(black1A,16.sp)
                )
            }


        // Second Row
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_return),
                contentDescription = "Leading Icon",
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(

                text = "Return",
                style = subheading(black1A, 18.sp),
                modifier = Modifier.weight(1f)

            )
            Icon(
                painter = painterResource(id = R.drawable.ic_right_face_arrow),
                contentDescription = "Trailing Icon",
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        navController.navigate(ScreenEnum.Return.name)
                        hideBottomSheet()
                    }
            )
        }

        // Third Row
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_reattempt),
                contentDescription = stringResource(R.string.leading_icon),

                )
            Spacer(modifier = Modifier.width(14.dp))
            Text(

                text = "Reattempt",
                style = subheading(black1A, 18.sp),
                modifier = Modifier.weight(1f)

            )
            Icon(
                painter = painterResource(id = R.drawable.ic_right_face_arrow),
                contentDescription = stringResource(R.string.trailing_icon),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        // Navigate to the new screen using the NavController
                        navController.navigate(ScreenEnum.Reattempt.name)
                        hideBottomSheet()
                    }
            )
        }
    }
}

@Preview
@Composable
fun NPreview()
{
    bottomSheetNDR("123","aa",navController = rememberNavController(), hideBottomSheet = {})
}


