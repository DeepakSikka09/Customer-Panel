package com.ecomexpress.customerpanel.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.ui.theme.black1A
import com.ecomexpress.customerpanel.ui.theme.grey478
import com.ecomexpress.customerpanel.ui.theme.grey4F
import com.ecomexpress.customerpanel.ui.theme.grey6FF
import com.ecomexpress.customerpanel.ui.theme.greyB7

@Composable
fun BottomNavBar(navController:NavController){
    val itemList = arrayListOf(
        BottomNavBarItem.Dashboard,
        BottomNavBarItem.Order,
        BottomNavBarItem.Wallet,
        BottomNavBarItem.More
    )
    BottomNavigation(
        backgroundColor = grey6FF
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        itemList.forEach {item->
            BottomNavigationItem(
                selected = currentRoute == item.title,
                onClick = {
                    navController.navigate(item.title) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = black1A,
                unselectedContentColor = grey478,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if(currentRoute == item.title){
                           // Image(painter = painterResource(id = R.drawable.nav_indicator), contentDescription = "icon")
                            Image(painter = painterResource(id = item.selectedIcon), contentDescription = "icon")
                        }else{
                            Image(painter = painterResource(id = item.unselectedIcon), contentDescription = "icon")
                        }
                    }
                },
                label = {
                    Text(
                        text = item.title, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            textAlign = TextAlign.Center,
                        )
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}