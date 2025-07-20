package com.ecomexpress.customerpanel.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.viewModel.HomeViewModel
import com.ecomexpress.customerpanel.ui.theme.grey00
import com.ecomexpress.customerpanel.navigation.BottomNavBar
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum
import com.ecomexpress.customerpanel.navigation.DashBoardNavGraph
import kotlinx.coroutines.launch
import com.ecomexpress.customerpanel.components.*
import com.ecomexpress.customerpanel.ui.theme.grey6FF

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val navHostController = rememberNavController()
    val bottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true,
            confirmValueChange = { false }
        )
    var bottomSheetContent: SheetContent? by remember { mutableStateOf(null) }
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
    BackHandler(bottomSheetContent != null) {
        hideBottomSheet()
    }
    ModalBottomSheetLayout(
        sheetContent = {
            bottomSheetContent?.invoke(this)
        },
        content = {
            Scaffold(
                topBar = {

                    Box(modifier = Modifier.background(grey6FF).paint(
                        painter = painterResource(id = R.drawable.dashboard_top_bg),
                        contentScale = ContentScale.FillWidth
                    ).fillMaxWidth()
                    ) {
                        DashboardTopBar(
                            onSearchClick = {
                                navController.navigate(ScreenEnum.Search.name)
                            },
                            onProfileClick = {
                                navController.navigate(ScreenEnum.ProfileScreen.name)
                            }
                        )
                    }
                },
                content = {
                    DashBoardNavGraph(
                        navHostController = navHostController,
                        modifier = Modifier.padding(it),
                        showBottomSheet,
                        hideBottomSheet,
                        navController
                    )
                },
                bottomBar = { BottomNavBar(navController = navHostController) },
            )
        },
        scrimColor = grey00,
        sheetElevation = 4.dp,
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp,
        ),
    )
}
