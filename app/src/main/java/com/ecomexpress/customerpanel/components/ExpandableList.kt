package com.ecomexpress.customerpanel.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey8B8
import com.ecomexpress.customerpanel.ui.theme.greyD2
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.utils.constants.heading


@Composable
fun ExpandableHeading(
    isExpanded: Boolean,
    onClick: () -> Unit,
    number: String,
    heading: String,
    enable: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Box(
            modifier = Modifier

                .background(shape = CircleShape, color = if (enable) grey4F else greyD2)
                .width(28.dp)
                .height(28.dp)
        ) {
            Text(
                text = number,
                modifier = Modifier
                    .align(Alignment.Center),
                style = heading(white)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = heading,
            style = heading(color = if (enable) black1A else grey8B8, fontSize = 18.sp),
            modifier = Modifier.weight(1f),
        )
        Image(
            painter = painterResource(
                id = if (isExpanded) {
                    if (enable) {
                        R.drawable.ic_enable_up_arrow
                    } else {
                        R.drawable.ic_disable_up_arrow
                    }
                } else {
                    if (enable) {
                        R.drawable.ic_down_arrow
                    } else {
                        R.drawable.ic_disable_down_arrow
                    }
                }
            ),
            contentDescription = "drop down",
            modifier = Modifier
                .clickable {
                    onClick()
                }
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun ExpandableList(isExpanded: Boolean, content: @Composable () -> Unit) {
    val expandTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeIn(
            animationSpec = tween(300)
        )
    }

    val collapseTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeOut(
            animationSpec = tween(300)
        )
    }

    AnimatedVisibility(
        visible = isExpanded,
        enter = expandTransition,
        exit = collapseTransition,
        modifier = Modifier.wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .height(IntrinsicSize.Max)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxHeight(),
                content = {
                    Divider(
                        modifier = Modifier
                            .border(width = 2.dp, color = grey4F)
                            .width(2.dp)
                            .fillMaxHeight()
                            .align(Alignment.Center)
                    )
                }
            )
            content()
        }
    }
}


@Preview
@Composable
fun showPrev() {
    ExpandableHeading(
        isExpanded = true,
        onClick = {},
        number = "1",
        heading = "Consignee",
        enable = true
    )
}
