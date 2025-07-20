package com.ecomexpress.customerpanel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ecomexpress.customerpanel.ui.view.OrderScreen
import com.ecomexpress.customerpanel.ui.view.DashboardScreen
import com.ecomexpress.customerpanel.ui.view.WalletScreen
import com.ecomexpress.customerpanel.utils.constants.SheetContent
import com.ecomexpress.customerpanel.ui.view.MoreScreen

@Composable
fun DashBoardNavGraph(
    navHostController: NavHostController,
    modifier: Modifier,
    showBottomSheet: (SheetContent) -> Unit,
    hideBottomSheet: () -> Unit,
    homeNavHostController: NavController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        builder = {
            composable(route = BottomNavBarItem.Dashboard.title) {
                DashboardScreen(
                    showBottomSheet,
                    hideBottomSheet,
                    homeNavHostController
                )
            }
            composable(route = BottomNavBarItem.Order.title) {
                OrderScreen(
                    showBottomSheet,
                    hideBottomSheet,
                    homeNavHostController
                )
            }
            composable(route = BottomNavBarItem.Wallet.title) {
                WalletScreen(
                    showBottomSheet,
                    hideBottomSheet,
                    homeNavHostController
                )
            }
            composable(route = BottomNavBarItem.More.title) {
                MoreScreen(
                    showBottomSheet,
                    hideBottomSheet,
                    homeNavHostController
                )
            }
        },
        startDestination = BottomNavBarItem.Dashboard.title
    )
}