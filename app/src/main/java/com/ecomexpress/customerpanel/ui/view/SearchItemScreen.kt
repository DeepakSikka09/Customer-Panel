package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.SearchBar
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.ui.event.CreateShipmentEvent
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.runBlocking


@Composable
fun SearchItem(navController: NavController,viewModel: CreateShipmentViewModel){
    val searchItem by viewModel.searchItemText.collectAsState()
    val comeFromSearchItem by viewModel.comeFromSearchItem.collectAsState()

    Scaffold(
        topBar = {
            TextToolbar(
                title = "Search Items",
                navController = navController,
                false,
                null,
                null
            )


        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start) {
                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    text = searchItem,
                    placeholderText = "By Mobile Number",
                    onTextChange = { newText ->
                        viewModel.setSearchItem(newText)
                        // Handle the search text change
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
                    text = "Recent Items",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6E7478),
                    ), modifier = Modifier.padding(top = 25.dp, start = 10.dp, bottom = 20.dp)
                )

                LazyColumn{

                    items(3){
                        AddItem(modifier = Modifier.pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    if (comeFromSearchItem){
                                        viewModel.setDeclareValue("850")
                                        viewModel.showSearchItem(true)
                                    }
                                    navController.popBackStack()

                                }
                            )
                        })
                    }
                    item{
                        Text(
                            text = "Add Items",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF285CC6),
                                textDecoration = TextDecoration.Underline,
                            ),
                            modifier = Modifier.padding(start = 10.dp).clickable {
                                navController.navigate(ScreenEnum.AddItemScreen.name)
                            }
                        )
                    }
                }


            }
        })
}

@Composable
fun AddItem(modifier: Modifier){
    Row(modifier = modifier
        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = "Shirt ",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF1A1A1A),
            )
        )
        Text(
            text = "1.100 kg",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A),
            )
        )
    }
    
}

@Preview
@Composable
fun showItem(){
    //SearchItem(navController = rememberNavController())
}


