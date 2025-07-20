package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.ecomexpress.customerpanel.ui.state.CreateShipmentState
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.ui.viewModel.SearchAddressViewModel
import com.ecomexpress.customerpanel.ui.viewModel.SearchScreenViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.runBlocking

@Composable
fun SearchAddress(navController: NavController,viewModel: CreateShipmentViewModel){
    val searchText by viewModel.searchAddress.collectAsState()
    val comeFromPickUp by viewModel.comeFromPickUp.collectAsState()
    val comeFromDelivery by viewModel.comeFromDelivery.collectAsState()
    Scaffold(
        topBar = {
            TextToolbar(
                title = "Search Address",
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
                    text = searchText,
                    placeholderText = "By Mobile Number",
                    onTextChange = { newText ->
                        viewModel.setSearchText(newText)
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
                    text = "Recent Address",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6E7478),
                    ), modifier = Modifier.padding(top = 25.dp, start = 10.dp, bottom = 20.dp)
                )

                LazyColumn{

                    items(3){
                          AddressItem(modifier = Modifier.pointerInput(Unit) {
                              detectTapGestures(
                                  onTap = {
                                      runBlocking {
                                          if (comeFromPickUp){
                                              viewModel.showPickUpAddress(true)
                                              viewModel.setPickupMobile(true)
                                              viewModel.onEvent(CreateShipmentEvent.Address1Changed("+91 9893898383"))
                                          }else{
                                              viewModel.showDeliveryAddress(true)
                                              viewModel.setDeliveryMobile(true)
                                              viewModel.onEvent(CreateShipmentEvent.Address2Changed("+91 9389838983"))
                                          }
                                          navController.popBackStack()

                                      }
                                  }
                              )
                          })
                    }
                    item{
                        Text(
                            text = "Add Pick-up Address",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF285CC6),
                                textDecoration = TextDecoration.Underline,
                            ),
                            modifier = Modifier.padding(start = 10.dp).clickable {
                                navController.navigate(ScreenEnum.AddAddressScreen.name)
                            }
                        )
                    }
                }


            }
        })
}

@Composable
fun AddressItem(modifier: Modifier=Modifier){
    Column(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0xFFB0BAC9),
                ambientColor = Color(0xFFB0BAC9)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))


            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
    ) {
        Text(
            text = "Sandeep Singh",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF1A1A1A),
            )
        )

        Text(
            text = "Ground Floor, H-271, Shiv Vihar, Sector-12, West Rajiv Nagar,Gurugram -India Pincode- 122004",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF1A1A1A),
            )
        )


    }
}



@Preview
@Composable
fun showAddressPreview(){
    SearchAddress(navController = rememberNavController(), CreateShipmentViewModel())
}