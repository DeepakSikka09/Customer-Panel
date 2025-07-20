package com.ecomexpress.customerpanel.navigation

import com.ecomexpress.customerpanel.R

sealed class BottomNavBarItem(var title: String, var selectedIcon: Int, val unselectedIcon: Int) {

    object Dashboard : BottomNavBarItem(
        "DashBoard",
        selectedIcon = R.drawable.selected_dashboard_nav,
        unselectedIcon = R.drawable.unselected_dashboard_nav
    )

    object Order :
        BottomNavBarItem(
            "Order",
            selectedIcon = R.drawable.selected_order_nav,
            unselectedIcon = R.drawable.unselected_order_nav
        )

    object Wallet :
        BottomNavBarItem(
            "Wallet",
            selectedIcon = R.drawable.selected_wallet_nav,
            unselectedIcon = R.drawable.unselected_wallet_nav
        )

    object More : BottomNavBarItem(
        "More",
        selectedIcon = R.drawable.selected_more_nav,
        unselectedIcon = R.drawable.unselected_more_nav
    )
}
