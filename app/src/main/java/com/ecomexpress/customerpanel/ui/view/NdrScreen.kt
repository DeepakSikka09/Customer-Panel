package com.ecomexpress.customerpanel.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.components.ActionPendingTable
import com.ecomexpress.customerpanel.components.ActionTakenTable
import com.ecomexpress.customerpanel.components.CustomPacketTypeButton
import com.ecomexpress.customerpanel.components.CustomTypeButton
import com.ecomexpress.customerpanel.components.DeliveredTable
import com.ecomexpress.customerpanel.components.RtoTable
import com.ecomexpress.customerpanel.components.SearchBar
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.ui.event.NdrEvent
import com.ecomexpress.customerpanel.ui.theme.grey00
import com.ecomexpress.customerpanel.ui.theme.grey7FE
import com.ecomexpress.customerpanel.ui.theme.white
import com.ecomexpress.customerpanel.ui.theme.whiteFF
import com.ecomexpress.customerpanel.ui.viewModel.NdrViewModel
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.utils.constants.selectedView
import com.ecomexpress.customerpanel.utils.constants.unselectedView
import com.ecomexpress.customerpanel.utils.enums.NdrTypeEnum
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NdrScreen(navController: NavHostController) {
    val mViewModel = viewModel<NdrViewModel>()
    val searchText by mViewModel.searchText.collectAsState()

    val data = mViewModel.ndrState.collectAsState().value
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var bottomSheetContent: SheetContent? by remember { mutableStateOf(null) }
    // Button to open the bottom sheet
    val coroutineScope = rememberCoroutineScope()
    val showBottomSheet: (SheetContent) -> Unit = { content ->
        bottomSheetContent = content
        coroutineScope.launch {
            bottomSheetState.show()
        }
    }
    val hideBottomSheet: () -> Unit = {
        coroutineScope.launch {
            bottomSheetState.hide()
            bottomSheetContent = null
        }
    }
    BackHandler(enabled = bottomSheetState.isVisible, onBack = {
        hideBottomSheet()
    })
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            bottomSheetContent?.invoke(this)
        },
        // sheetPeekHeight = 0.dp,
        scrimColor = grey00,
        sheetElevation = 4.dp,
        content = {
            Scaffold(
                topBar = {
                    TextToolbar(
                        title = "NDR - Non Delivery Report",
                        navController = navController,
                        isSearch = false,
                        null,
                        null
                    )
                },
                backgroundColor = whiteFF,
                content = {
                    Column(
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(it)
                            .background(color = white),

                    ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(Modifier.horizontalScroll(rememberScrollState())) {
                            CustomTypeButton(
                                type = "Action Pending",
                                isSelected = data.selectedNdrTypeEnum == NdrTypeEnum.Action_Pending,
                                onPress = {
                                    mViewModel.onEvent(NdrEvent.OnNdrChange(NdrTypeEnum.Action_Pending))
                                }
                            )
                            CustomTypeButton(
                                type = "Action Taken",
                                isSelected = data.selectedNdrTypeEnum == NdrTypeEnum.Action_Taken,
                                onPress = {
                                    mViewModel.onEvent(NdrEvent.OnNdrChange(NdrTypeEnum.Action_Taken))
                                }
                            )
                            CustomTypeButton(
                                type = "Delivered",
                                isSelected = data.selectedNdrTypeEnum == NdrTypeEnum.Delivered,
                                onPress = {
                                    mViewModel.onEvent(NdrEvent.OnNdrChange(NdrTypeEnum.Delivered))
                                }
                            )
                            CustomTypeButton(
                                type = "RTO",
                                isSelected = data.selectedNdrTypeEnum == NdrTypeEnum.Rto,


                                onPress = {
                                    mViewModel.onEvent(NdrEvent.OnNdrChange(NdrTypeEnum.Rto))
                                }
                            )

                        }

                        Spacer(modifier = Modifier.fillMaxWidth().height(10.dp).background(color = grey7FE))

                        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                            SearchBar(modifier = Modifier.fillMaxWidth(),
                                text = searchText,
                                onTextChange = { newText ->
                                    mViewModel.setSearchText(newText)

                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_search),
                                        contentDescription = "Icon",
                                        modifier = Modifier
                                            .wrapContentSize()
                                    )
                                },
                                trailingIcon = {

                                }
                            )
                        }
                        Spacer(modifier = Modifier.fillMaxWidth().height(10.dp).background(color = grey7FE))

                        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                            when(data.selectedNdrTypeEnum){
                                NdrTypeEnum.Action_Pending->{
                                    ActionPendingTable(data.actionPendingList,Modifier.weight(1f),showBottomSheet,navController,hideBottomSheet)
                                }
                                NdrTypeEnum.Action_Taken->{
                                    ActionTakenTable(list = data.actionTakenList, modifier = Modifier.weight(1f))
                                }
                                NdrTypeEnum.Delivered->{
                                    DeliveredTable(list = data.deliveredList, modifier = Modifier.weight(1f))
                                }
                                NdrTypeEnum.Rto->{
                                    RtoTable(list = data.rtoList, modifier = Modifier.weight(1f))
                                }
                            }
                        }

                    }
                }
            )
        },
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
    )

}

@Preview
@Composable
fun NDRPreview()
{
    NdrScreen(navController = rememberNavController())
}
