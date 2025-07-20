package com.ecomexpress.customerpanel.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.CustomTextField
import com.ecomexpress.customerpanel.components.SearchButton
import com.ecomexpress.customerpanel.components.ShipmentItemSwitch
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.navigation.popTo
import com.ecomexpress.customerpanel.ui.event.CreateShipmentEvent
import com.ecomexpress.customerpanel.ui.theme.grey478
import com.ecomexpress.customerpanel.ui.theme.grey8B8
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.utils.constants.text
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable

fun AddItems(navController: NavHostController, mViewModel: CreateShipmentViewModel) {

    val data = mViewModel.state.collectAsState().value

    Scaffold(topBar = {
        TextToolbar(title = "Add Items", navController = navController, false, null, null)

    }, content = {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = white),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
                    .background(color = white)
            ) {
                CustomTextField(
                    data = data.referenceId,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.ReferenceIdChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Reference ID",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.itemCategory,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.ItemCategoryChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Item Category",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                CustomTextField(
                    data = data.itemName,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.ItemNameChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Item Name",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.itemDescription,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.ItemDescriptionChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Item Description",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.HSNCode,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.HSNCodeChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "HSN Code",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.deadWeight,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.DeadWeightChanged(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Dead Weight (Kg)",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Dead Weight can not be more than 9 Kg",
                    style = text(grey478, 12.sp),
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )

                CustomTextField(
                    data = data.declaredValue,
                    onChange = { mViewModel.onEvent(
                        CreateShipmentEvent.DeclaredValueChange(
                            it
                        )
                    )},
                    keyBoardType = KeyboardType.Text,
                    isError = false,
                    labelText = "Declared Value",
                    visualTransformation = VisualTransformation.None
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                ShipmentItemSwitch(
                    headingTxt = "Essential Goods",
                    isCheck = false,
                    onCheckChange = {
                    }
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                ShipmentItemSwitch(
                    headingTxt = "Dangerous Goods",
                    isCheck = false,
                    onCheckChange = {
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(grey8B8)
            )


        }
    }, bottomBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            SearchButton(
                function = {
                    mViewModel.showSearchItem(true)
                    navController.popTo(ScreenEnum.CreateShipment.name, false)

                },
                text = "Add",
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
fun ShowItemsPreview() {
    AddItems(navController = rememberNavController(), CreateShipmentViewModel())
}