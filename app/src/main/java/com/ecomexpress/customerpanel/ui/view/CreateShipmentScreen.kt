package com.ecomexpress.customerpanel.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.event.CreateShipmentEvent
import com.ecomexpress.customerpanel.ui.event.OrderEvent
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.blueB7
import com.ecomexpress.customerpanel.ui.theme.fontFamily
import com.ecomexpress.customerpanel.ui.theme.grey00
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.greyD2
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.ui.viewModel.CreateShipmentViewModel
import com.ecomexpress.customerpanel.utils.DateTransformation
import com.ecomexpress.customerpanel.utils.constants.Calender
import com.ecomexpress.customerpanel.utils.constants.bottomSheetHelp
import com.ecomexpress.customerpanel.utils.constants.heading
import com.ecomexpress.customerpanel.utils.constants.searchHeading
import com.ecomexpress.customerpanel.utils.constants.subheading
import com.ecomexpress.customerpanel.utils.constants.text
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateShipment(navController: NavHostController,mViewModel: CreateShipmentViewModel) {
    val searchText by mViewModel.searchText.collectAsState()
    val declareValue by mViewModel.declareValue.collectAsState()
    val showPickAddress by mViewModel.showPickUpAddress.collectAsState()
    val showDeliverAddress by mViewModel.showDeliveryAddress.collectAsState()
    val showSearchItem by mViewModel.showSearchItem.collectAsState()
    val showPackageItem by mViewModel.showPackageItem.collectAsState()
    val itemCount by mViewModel.itemCount.collectAsState()
    val showPickUpMobile by mViewModel.showPickupMobile.collectAsState()
    val showDeliveryMobile by mViewModel.showDeliveryMobile.collectAsState()

    val data = mViewModel.state.collectAsState().value
    val bottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true,
            confirmValueChange = { false }
        )
    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_item),
                        contentDescription = "add_item"
                    )
                    Text(
                        text = "Add Items",
                        style = bottomSheetHelp(
                            color = grey4F
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.cross),
                        contentDescription = "cross",
                        modifier = Modifier.clickable {
                            coroutineScope.launch {
                                bottomSheetState.hide()
                            }
                            mViewModel.onEvent(CreateShipmentEvent.NewItemClose)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                AddItemField(
                    value = data.newItem.itemName,
                    onValue = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemNameChange(it))
                    },
                    heading = "Item Name",
                    keyBoardType = KeyboardType.Text
                )
                AddItemField(
                    value = data.newItem.category,
                    onValue = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemCategoryChange(it))
                    },
                    heading = "Category",
                    keyBoardType = KeyboardType.Text
                )
                AddItemField(
                    value = data.newItem.weight,
                    onValue = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemWeightChange(it))
                    },
                    heading = "Weight (Kg)",
                    keyBoardType = KeyboardType.Number
                )
                AddItemField(
                    value = data.newItem.quantity,
                    onValue = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemQuantityChange(it))
                    },
                    heading = "Quantity",
                    keyBoardType = KeyboardType.Number
                )
                ShipmentItemSwitch(
                    headingTxt = "Essential Goods",
                    isCheck = data.newItem.isEssentialGoods,
                    onCheckChange = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemIsEssential)
                    }
                )
                ShipmentItemSwitch(
                    headingTxt = "Dangerous Goods",
                    isCheck = data.newItem.isDangerousGood,
                    onCheckChange = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemIsDangerous)
                    }
                )
                BlueButton(
                    isEnable = data.newItemAddEnable,
                    onClick = {
                        mViewModel.onEvent(CreateShipmentEvent.NewItemAdd)
                        coroutineScope.launch {
                            bottomSheetState.hide()
                        }
                    },
                    btnText = "Apply",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        sheetState = bottomSheetState,
        scrimColor = grey00,
        sheetElevation = 4.dp,
        sheetShape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp,
        ),
    ) {
        Scaffold(
            topBar = {
                TextToolbar(
                    title = "Create Shipment",
                    navController = navController,
                    isCreateShipment = true,
                    clearModifier = Modifier.clickable {
                        mViewModel.onEvent(CreateShipmentEvent.ClearAll)
                    }
                )
            },
            content = {
                BackHandler(enabled = bottomSheetState.isVisible, onBack = {
                    mViewModel.onEvent(CreateShipmentEvent.NewItemClose)
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                })
                Column(
                    modifier = Modifier
                        .padding(it)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        ExpandableHeading(
                            isExpanded = data.consigneeExpand,
                            onClick = { mViewModel.onEvent(CreateShipmentEvent.ConsigneeExpand) },
                            number = "1",
                            heading = "Seller & Consignee Address",
                            enable = data.formFilled >= 0
                        )
                        ExpandableList(data.consigneeExpand) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {


                                Text(
                                    text = "Pick-up Address",
                                    style = subheading(color = black1A,18.sp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                if (showPickUpMobile){
                                    data.address1="9876363663"
                                    CustomTextField(
                                        data = data.address1,
                                        onChange = {},
                                        keyBoardType = KeyboardType.Text,
                                        isError = false,
                                        labelText ="Mobile Number" ,
                                        visualTransformation = VisualTransformation.None
                                    )
                                }else{
                                    SearchBar(
                                        text = data.address1,
                                        onTextChange = {
                                            // Handle the search text change
                                            mViewModel.onEvent(CreateShipmentEvent.Address1Changed(it))


                                        },
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_search),
                                                contentDescription = "Icon",
                                                modifier = Modifier.wrapContentSize()
                                            )
                                        },
                                        trailingIcon = {

                                        },
                                        enable = false,
                                        function = {
                                            navController.navigate(ScreenEnum.SearchAddressScreen.name)
                                            mViewModel.setPickUp(true)
                                            mViewModel.setDelivery(false)
                                        }
                                    )
                                }

                                if (showPickAddress){
                                    Spacer(modifier = Modifier.height(15.dp))
                                    AddressItemWithButton()

                                }


                                Spacer(modifier = Modifier.height(20.dp))

                                CustomFilterCheckBox(
                                    text = "Same as Return Address",
                                    check = true,
                                    onChange = {

                                    }
                                )
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "Delivery Address",
                                    style = subheading(color = black1A,18.sp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))

                                if (showDeliveryMobile){
                                    data.address2="9876363663"
                                    CustomTextField(
                                        data = data.address2,
                                        onChange = {},
                                        keyBoardType = KeyboardType.Text,
                                        isError = false,
                                        labelText ="Mobile Number" ,
                                        visualTransformation = VisualTransformation.None
                                    )
                                }else{
                                    SearchBar(
                                        text = data.address2,
                                        onTextChange = {
                                            mViewModel.onEvent(CreateShipmentEvent.Address2Changed(it))

                                            // Handle the search text change
                                        },
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_search),
                                                contentDescription = "Icon",
                                                modifier = Modifier.wrapContentSize()
                                            )
                                        },
                                        trailingIcon = {

                                        },
                                        enable = false,
                                        function = {navController.navigate(ScreenEnum.SearchAddressScreen.name)
                                            mViewModel.setDelivery(true)
                                            mViewModel.setPickUp(false)
                                        }
                                    )
                                }


                                Spacer(modifier = Modifier.height(15.dp))
                                if (showDeliverAddress){
                                    AddressItemWithButton()

                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth().background(grey6FF))


                        ExpandableHeading(
                            isExpanded = data.orderExpand,
                            onClick = { mViewModel.onEvent(CreateShipmentEvent.OrderExpand) },
                            number = "2",
                            heading = "Orders",
                            enable = data.formFilled >= 1
                        )
                        ExpandableList(
                            isExpanded = data.orderExpand,
                        ) {
                            Column(modifier = Modifier.weight(1f)) {

                                CustomTextField(
                                    data = data.orderNumber,
                                    onChange = {mViewModel.onEvent(CreateShipmentEvent.OrderNumberChange(it))},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Order ID",
                                    visualTransformation = VisualTransformation.None
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                CustomTextField(
                                    data = data.invoiceNumber,
                                    onChange = { mViewModel.onEvent(CreateShipmentEvent.InvoiceNumberChange(it))},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Invoice No.",
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                CustomTextField(
                                    data = data.invoiceDate,
                                    onChange = { if (it.length <= 8) {
                                        mViewModel.onEvent(
                                            CreateShipmentEvent.InvoiceDateChange(
                                                it
                                            )
                                        )
                                    }},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Invoice Date",
                                    visualTransformation = DateTransformation()
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth().background(grey6FF))

                        ExpandableHeading(
                            isExpanded = data.pickupExpand,
                            onClick = { mViewModel.onEvent(CreateShipmentEvent.PickupExpand) },
                            number = "3",
                            heading = "Shipment",
                            enable = data.formFilled >= 2
                        )
                        ExpandableList(
                            isExpanded = data.pickupExpand,
                        ) {
                            Column(modifier = Modifier.weight(1f)) {

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Payment Mode",
                                    style = subheading(color = black1A,18.sp)
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    CustomPaymentType(
                                        onClick = {
                                            mViewModel.onEvent(
                                                CreateShipmentEvent.PaymentTypeChange(
                                                    0
                                                )
                                            )
                                        },
                                        paymentSelected = data.paymentType,
                                        icon = R.drawable.selected_radio,
                                        title = "Cash on\nDelivery",
                                        paymentValue = 0
                                    )
                                    CustomPaymentType(
                                        onClick = {
                                            mViewModel.onEvent(
                                                CreateShipmentEvent.PaymentTypeChange(
                                                    1
                                                )
                                            )
                                        },
                                        paymentSelected = data.paymentType,
                                        icon = R.drawable.unselected_radio,
                                        title = "Prepaid\nDelivery",
                                        paymentValue = 1
                                    )
                                }
                                Spacer(modifier = Modifier.height(30.dp))
                                Text(
                                    text = "Item Details",
                                    style = subheading(color = black1A,18.sp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                SearchBar(
                                    text = searchText,
                                    onTextChange = { newText ->
                                        mViewModel.setSearchText(newText)
                                        // Handle the search text change
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_search),
                                            contentDescription = "Icon",
                                            modifier = Modifier.wrapContentSize()
                                        )
                                    },
                                    trailingIcon = {

                                    },
                                    function = {
                                        navController.navigate(ScreenEnum.SearchItemScreen.name)
                                        mViewModel.setSearchItem(true)
                                        mViewModel.setPackgeItem(false)
                                    },
                                    enable = false
                                )

                                //  ll
                                if (showSearchItem){
                                    Spacer(modifier = Modifier.height(10.dp))

                                    AddItemBox(declareValue = declareValue, viewModel = mViewModel, count = itemCount.toString())
                                }
                                Spacer(modifier = Modifier.height(30.dp))

                                Text(
                                    text = "Packaging Details",
                                    style = subheading(color = black1A,18.sp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                SearchBar(

                                    text = searchText,
                                    onTextChange = { newText ->
                                        mViewModel.setSearchText(newText)
                                        // Handle the search text change
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_search),
                                            contentDescription = "Icon",
                                            modifier = Modifier.wrapContentSize()
                                        )
                                    },
                                    trailingIcon = {

                                    },
                                    function = {
                                        navController.navigate(ScreenEnum.SearchPackageScreen.name)
                                        mViewModel.setPackgeItem(true)
                                        mViewModel.setSearchItem(false)
                                    },
                                    enable = false
                                )

                                if (showPackageItem){
                                    Spacer(modifier = Modifier.height(10.dp))

                                    AddPackageBox()
                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth().background(grey6FF))

                        ExpandableHeading(
                            isExpanded = data.shipmentExpand,
                            onClick = { mViewModel.onEvent(CreateShipmentEvent.ShipmentExpand) },
                            number = "4",
                            heading = "Finance Details",
                            enable = data.formFilled >= 3
                        )
                        ExpandableList(
                            isExpanded = data.shipmentExpand,
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                if (data.itemList.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(5.dp))
                                    for (item in data.itemList) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 10.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Text(
                                                    text = item.itemName,
                                                    style = bottomSheetHelp(
                                                        color = grey4F
                                                    )
                                                )
                                                Spacer(modifier = Modifier.height(2.dp))
                                                Text(
                                                    text = item.category,
                                                    style = Calender
                                                )
                                            }
                                            Column(
                                                horizontalAlignment = Alignment.End
                                            ) {
                                                Text(
                                                    text = "${item.weight} Kg",
                                                    style = Calender
                                                )
                                                Spacer(modifier = Modifier.height(2.dp))
                                                Text(
                                                    text = "Qty: ${item.quantity}",
                                                    style = Calender
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_delete),
                                                contentDescription = "delete Item",
                                                modifier = Modifier.clickable {
                                                    mViewModel.onEvent(CreateShipmentEvent.DeleteItem(item))
                                                }
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                CustomTextField(
                                    data = data.sellerGST,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.SellerGSTNChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Seller GSTN" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.eWayBill,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.EwayBillChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "E-Waybill No." ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.totalItemValue,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.TotalItemValueChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Total Item Value" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                val names = listOf("18%","24%","28%")
                                SpinnerExample("GST Rates",names)

                                Spacer(modifier = Modifier.height(12.dp))

                                val namestype = listOf("SGST/CGST","SGST","CGST")

                                SpinnerExample("Type",namestype)

                                Spacer(modifier = Modifier.height(12.dp))

                                CustomTextField(
                                    data = data.sgstAmt,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.SGSTAmtChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "SGST Amount" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.cgstAmt,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.CGSTAmtChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "CGST Amount" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.igstAmt,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.IGSTAmtChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "IGST Amount" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.totalgstAmt,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.TotalGSTAmtChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Total GST Amount" ,
                                    visualTransformation = VisualTransformation.None
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                CustomTextField(
                                    data = data.totalinvoiceValue,
                                    onChange = { mViewModel.onEvent(
                                        CreateShipmentEvent.TotalInvoiceValueChanged(
                                            it
                                        )
                                    )},
                                    keyBoardType = KeyboardType.Text,
                                    isError = false,
                                    labelText = "Total Invoice Value" ,
                                    visualTransformation = VisualTransformation.None
                                )

                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Box(
                        Modifier
                            .background(color = whiteFF)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    text = "₹0.00",
                                    style = searchHeading
                                )
                                Text(
                                    text = "Estimate Charges",
                                    style = text(color = black1A)
                                )

                            }
                            BlueButton(
                                isEnable = data.submitEnable,
                                onClick = {

                                },
                                btnText = "Submit"
                            )
                        }
                    }
                }

            }
        )
    }

}

@Preview
@Composable
fun CustomPaymentTypePreview()
{
    CreateShipment(navController = rememberNavController(),CreateShipmentViewModel())
}

@Composable
fun AddressItemWithButton(){
    Column(
        modifier = Modifier

            .shadow(
                elevation = 4.dp,
                spotColor = Color(0xFFB0BAC9),
                ambientColor = Color(0xFFB0BAC9)
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))

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
        Spacer(modifier = Modifier
            .height(15.dp)
            .fillMaxWidth())
        Row{
            Text(
                text = "Edit",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Delete",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )

        }


    }
}

@Composable
fun  AddItemBox(declareValue:String,viewModel: CreateShipmentViewModel,count:String){
    Column(
        modifier = Modifier
            .padding(bottom = 25.dp, top = 8.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0xFFB0BAC9),
                ambientColor = Color(0xFFB0BAC9)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
    ){
       Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
           Column() {
               Text(
                   text = "Pant Fabric",
                   style = TextStyle(
                       fontSize = 16.sp,
                       fontFamily = fontFamily,
                       fontWeight = FontWeight(500),
                       color = Color(0xFF1A1A1A),
                   )
               )
               Text(
                   text = "1.300 Kg",
                   style = TextStyle(
                       fontSize = 16.sp,
                       fontFamily = fontFamily,
                       fontWeight = FontWeight(400),
                       color = Color(0xFF1A1A1A),
                   )
               )
           }
           Row(modifier = Modifier
               .border(
                   width = 1.dp,
                   color = Color(0xFF1A1A1A),
                   shape = RoundedCornerShape(size = 6.dp)
               )
               .wrapContentWidth()
               .wrapContentHeight()
               .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))
               .padding(start = 10.dp, top = 8.dp, end = 10.dp, bottom = 8.dp),
               horizontalArrangement = Arrangement.Center,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(painter = painterResource(id = R.drawable.minus) , contentDescription ="", modifier = Modifier
                   .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 15.dp)
                   .width(12.dp)
                   .height(12.dp)
                   .clickable {
                       viewModel.setCount(-1)
                   })
               Text(
                   text = count,
                   style = TextStyle(
                       fontSize = 16.sp,
                       fontFamily = fontFamily,
                       fontWeight = FontWeight(500),
                       color = Color(0xFF1A1A1A),
                       textAlign = TextAlign.Center,
                   )
               )
               Image(painter = painterResource(id = R.drawable.plus_) , contentDescription ="", modifier = Modifier
                   .padding(end = 10.dp, start = 15.dp, top = 10.dp, bottom = 10.dp)
                   .width(12.dp)
                   .height(12.dp)
                   .clickable {
                       viewModel.setCount(1)
                   })
           }
       }
        Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))

        CustomTextField(
            data = declareValue,
            onChange = {viewModel.setDeclareValue(it)},
            keyBoardType = KeyboardType.Text,
            isError = false,
            labelText ="Declared Value" ,
            visualTransformation = VisualTransformation.None
        )

        Row(modifier = Modifier.padding(top =15.dp)){
            Text(
                text = "Edit",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Delete",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )

        }

    }
}

@Composable
fun  AddPackageBox(){
    Column(
        modifier = Modifier
            .padding(bottom = 25.dp, top = 8.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0xFFB0BAC9),
                ambientColor = Color(0xFFB0BAC9)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 15.dp)
    ){
        Text(
            text = "Poly Bag",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF1A1A1A),
            )
        )
        Text(
            text = "L39 cm x B53 cm x H6 cm",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(300),
                color = Color(0xFF1A1A1A),
            )
        )



        Row(modifier = Modifier.padding(top =15.dp)){
            Text(
                text = "Edit",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Delete",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF285CC6),
                    textDecoration = TextDecoration.Underline,
                )
            )

        }

    }
}


@Preview
@Composable
fun showBoxx(){
    AddItemBox("",CreateShipmentViewModel(),"")
}