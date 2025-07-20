package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.text
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun TextToolbar(
    title: String,
    navController: NavController,
    isSearch: Boolean = false,
    awbNoHeading: String? = null,
    awbNo: String? = null,
    isCreateShipment: Boolean = false,
    isTraillingIcon:Boolean?=false,
    clearModifier: Modifier = Modifier,
    showHelpBottomSheet:(()->Unit)={}
) {
    TopAppBar(
        backgroundColor = grey6FF,
        contentColor = Color.Black,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(end = 8.dp)
                )
                Text(
                    text = title,
                    style = heading(grey4F, 20.sp),
                )



            }
            if (isTraillingIcon!!){
                Image(
                    painter = painterResource(id = R.drawable.help_icon),
                    contentDescription = "Question",
                    modifier = Modifier
                        .clickable {
                                showHelpBottomSheet()

                        }
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(end = 8.dp),
                    alignment = Alignment.CenterEnd

                )
            }
            if (isSearch) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search_icon),
                    contentDescription = "search icon"
                )
            }
            Column() {
                if (awbNoHeading != null) {
                    Text(
                        text = "AWB No.",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF8899B7),
                            textAlign = TextAlign.Right,
                        )
                    )
                }
                if (awbNo != null) {
                    Text(
                        text = awbNo,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF35374F),
                            textAlign = TextAlign.Right,
                        )
                    )
                }
            }
            if (isCreateShipment) {
                Text(
                    text = "Clear",
                    style = text(color = grey4F),
                    modifier = clearModifier
                )
            }
        }
    }
}


@Composable
fun SearchToolbar(
    title: String,
    onSearchQueryChanged: (String) -> Unit,
    textSize: TextUnit = 18.sp,
    navController: NavController
) {
    var searchQuery by remember { mutableStateOf("") }

    TopAppBar(
        backgroundColor = whiteFF,
        contentColor = Color.Black,
        elevation = 0.dp,


        ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back_arrow), // Replace with your own drawable resource
                contentDescription = "Logo",
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .wrapContentSize()
                    .padding(end = 0.dp)
            )

            TextField(
                value = searchQuery,
                onValueChange = { query ->
                    searchQuery = query
                    onSearchQueryChanged(query)
                },

                placeholder =
                {
                    Text(
                        text = "Search AWB, Order ID & TRID",
                        modifier = Modifier
                            .padding(start = 0.dp),
                        fontSize = 18.sp
                    )
                },
                modifier = Modifier
                    .padding(start = 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle.Default.copy(fontSize = textSize)
            )
        }
    }
}


