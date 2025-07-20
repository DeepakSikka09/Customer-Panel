package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.CustomTextField
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.SpinnerExample
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.navigation.popTo
import com.ecomexpress.customerpanel.ui.event.CreateShipmentEvent
import com.ecomexpress.customerpanel.ui.theme.grey1CD
import com.ecomexpress.customerpanel.ui.theme.grey8B8
import com.ecomexpress.customerpanel.ui.theme.greyC1CD
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable

fun AddAddressScreen(navController: NavHostController,mViewModel: CreateShipmentViewModel)
{
    val data = mViewModel.state.collectAsState().value

    Scaffold(topBar = {
        TextToolbar(title = "Add Pick-up Address", navController=navController,false,null,null)

    }, content = {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = white)
        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 15.dp)
                    .background(color = white)
            ) {


                CustomTextField(
                    data = data.name,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.NameChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Seller Name",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)

                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.address1,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.Address1Changed(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Flat, House no., Building",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.address2,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.Address2Changed(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Street, Sector, Village",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.landmark,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.LandMarkChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Landmark",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.pincode,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.PincodeChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Pincode",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.city,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.CityChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "City",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.state,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.StateChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "State",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp).background(greyC1CD))

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.mobile,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.MobileChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Mobile Number",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.altMobile,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.AltMobileChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Alternate Phone Number",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp).background(greyC1CD))

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.sellerGST,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.SellerGSTNChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Seller GST Number",
                    visualTransformation = VisualTransformation.None,
                    modifier = Modifier.padding( horizontal = 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                val locationType = listOf("Market Place/Seller", "Market Place", "Seller")

                SpinnerExample("Location Type", itemList = locationType,
                    modifier = Modifier.padding( horizontal = 20.dp))

            }
            Spacer(modifier = Modifier.weight(1f))




        }
    },
        bottomBar = {
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(grey8B8)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                    SearchButton(
                        function = {
                            navController.popTo(ScreenEnum.CreateShipment.name, false)
                        },
                        text = "Save",
                        imageId = null,
                        modifier = Modifier,
                        enabled = true
                    )

            }
        }
    )


}

@Preview
@Composable
fun ShowAddressPreview(){
    AddAddressScreen(navController = rememberNavController(), CreateShipmentViewModel())
}