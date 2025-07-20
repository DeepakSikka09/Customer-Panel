package com.ecomexpress.customerpanel.ui.view
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ecomexpress.customerpanel.components.LazyListComposable
import com.ecomexpress.customerpanel.data.local.db.entities.listOfMoreOptions
import com.ecomexpress.customerpanel.utils.constants.SheetContent

@Composable
fun MoreScreen(
    showBottomSheet: (SheetContent) -> Unit,
    hideBottomSheet: () -> Unit,
    navHostController: NavController
){
    LazyListComposable(list = listOfMoreOptions,navHostController)
}