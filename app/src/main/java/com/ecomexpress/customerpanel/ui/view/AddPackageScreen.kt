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
import com.ecomexpress.customerpanel.ui.theme.grey8B8
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable

fun AddPackageScreen(navController: NavHostController,mViewModel: CreateShipmentViewModel)
{
    val data = mViewModel.state.collectAsState().value

    Scaffold(topBar = {
        TextToolbar(title = "Add Package Type", navController=navController,false,null,null)

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
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
                    .background(color = white)
            ) {


                CustomTextField(
                    data = data.packagingName,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.PackagingNameChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Packaging Name",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                val packageType = listOf("Poly Bag", "Polythene", "Poly Bag")

                SpinnerExample("Packaging Type", itemList = packageType)
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.length,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.LengthChange(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Length (cm)",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.breadth,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.BreadthChange(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Breadth (cm)",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.height,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.HeightChange(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Height (cm)",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.volWeight,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.VolWeightChange(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Volumetric Weight (Kg)",
                    visualTransformation = VisualTransformation.None
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(grey8B8)
            )
            Box(modifier=Modifier.fillMaxWidth().padding(20.dp)) {
                SearchButton(
                    function = {
                        mViewModel.showPackageItem(true)
                        navController.popTo(ScreenEnum.CreateShipment.name,false)
                    },
                    text = "Add",
                    imageId = null,
                    modifier = Modifier,
                    enabled = true
                )
            }


        }
    }
    )


}

@Preview
@Composable
fun ShowPackagePreview(){
    AddPackageScreen(navController = rememberNavController(), CreateShipmentViewModel())
}