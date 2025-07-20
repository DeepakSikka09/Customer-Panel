package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.ProfileButtonColor

@Composable
fun DashboardTopBar(
    onSearchClick: ((Offset) -> Unit)?,
    onProfileClick:((Offset) -> Unit)?
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        content = {

                CircularButton(
                    text = "SS",
                    icon = null,
                    iconDescription = null,
                    bgColor = ProfileButtonColor,
                    onClick = null,
                    onProfileClick = onProfileClick,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_logo_bike,
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 2.dp),
                    contentDescription = "logo")

            Row(
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                CircularButton(
                    text = null,
                    icon = R.drawable.ic_search,
                    iconDescription = "search",
                    bgColor = Color.White,
                    onClick = onSearchClick,
                    onProfileClick = null
                )
                CircularButton(
                    text = null,
                    icon = R.drawable.ic_notification,
                    iconDescription = "notification",
                    bgColor = Color.White,
                    onClick = null,
                    onProfileClick = null
                )
            }

        }
    )
}