package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.SearchBar
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.components.TextWithLeadingImage
import com.ecomexpress.customerpanel.data.response.listofAwb
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.viewModel.SearchScreenViewModel
import com.ecomexpress.customerpanel.utils.constants.textSearch
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun SearchScreen(navController: NavController, viewModel: SearchScreenViewModel) {
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    val searchText by viewModel.searchText.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFFF6F8FF))  // Replace with your desired color
    }

    Scaffold(
        topBar = {
            TextToolbar(
                title = "Search AWB & Order ID",
                navController = navController,
                false,
                null,
                null
            )


        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {


                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    text = searchText,
                    onTextChange = { newText ->
                        viewModel.setSearchText(newText)
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Icon",
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    },
                    trailingIcon = {}
                )
                Text(
                    text = "Recents Search",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6E7478),
                    ), modifier = Modifier.padding(top = 25.dp, start = 10.dp, bottom = 20.dp)
                )
                LazyColumn {
                    items(listofAwb) { item ->
                        TextWithLeadingImage(
                            text = item.text,
                            leadingImageId = item.leadingImageId,
                            style = textSearch,

                            modifier = Modifier
                                .padding(start = 10.dp)
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onTap = {
                                            navController.navigate(ScreenEnum.SearchScreenResult.name)
                                        }
                                    )
                                },
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    )
}