package com.ecomexpress.customerpanel.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.RechargeButton
import com.ecomexpress.customerpanel.components.TextToolbar
import com.ecomexpress.customerpanel.components.rechargeWallet
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.ecomexpress.customerpanel.ui.theme.grey00
import com.ecomexpress.customerpanel.ui.viewModel.RechargeWalletViewModel
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RechargeWalletComposable(navController: NavController, viewModel: RechargeWalletViewModel) {
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
                        title = "Recharge Wallet",
                        navController = navController,
                        false,
                        null,
                        null
                    )
                }
            ) {
                rechargeWallet(Modifier.padding(it), navController, viewModel,showBottomSheet, hideBottomSheet)

            }
        },
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
    )
}

@Preview
@Composable
fun RechargeWalletPreview() {
    CustomerPanelTheme {
        RechargeWalletComposable(rememberNavController(), viewModel())
    }
}