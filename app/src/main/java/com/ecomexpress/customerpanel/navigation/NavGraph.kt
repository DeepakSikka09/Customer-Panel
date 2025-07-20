package com.ecomexpress.customerpanel.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ecomexpress.customerpanel.ui.view.*
import com.ecomexpress.customerpanel.ui.viewModel.*
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val ShipmentViewModel: CreateShipmentViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = ScreenEnum.SplashScreen.name

    ) {
        composable(route = ScreenEnum.SplashScreen.name) {
            val viewModel: SplashScreenViewModel = viewModel()
            SplashScreen(navController, viewModel)
        }

        composable(route = ScreenEnum.Login.name) {
            val viewModel: LogInScreenViewModel = viewModel()
            LogInScreen(navController, viewModel)
        }

        composable(route = ScreenEnum.PinCodeSearch.name) {
            val viewModel: PinCodeViewModel = viewModel()
            PinCodeScreen(navController, viewModel)
        }
        composable(route = ScreenEnum.Search.name) {
            val viewModel: SearchScreenViewModel = viewModel()
            SearchScreen(navController, viewModel)
        }

        composable(route = ScreenEnum.SearchScreenResult.name) {
            val viewModel: SerachScreenResultViewModel = viewModel()
            SearchScreenSecond(navController, viewModel)
        }

        composable(route = ScreenEnum.Home.name) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(navController, viewModel)
        }

        composable(route = ScreenEnum.RateCalculator.name) {
            val viewModel: RateCalculatorViewModel = viewModel()
            RateCalculator(navController, viewModel)
        }

        composable(ScreenEnum.ProfileScreen.name) {
            val viewModel: ProfileViewModel = viewModel()
            ProfileScreen(navController, viewModel)
        }

        composable(ScreenEnum.NdrScreen.name) {
            NdrScreen(navController)
        }

        composable(ScreenEnum.ActionPending.name) {
            ActionPendingScreen(navController)
        }
        composable(ScreenEnum.RechargeWallet.name) {
            val viewModel: RechargeWalletViewModel = viewModel()
            RechargeWalletComposable(navController, viewModel)
        }
        composable(ScreenEnum.Reattempt.name) {
            val viewModel: ReattemptViewModel = viewModel()
            Reattempt(navController, viewModel)
        }
        composable(ScreenEnum.Return.name) {
            ReturnScreen(navController)
        }
        composable(ScreenEnum.CreateShipment.name) {
            CreateShipment(navController,ShipmentViewModel)
        }

        composable(route = ScreenEnum.ForgotPassword.name) {
            val viewModel: ForgetPasswordViewModel = viewModel()
            ForgetPasswordComposable(navController,viewModel)
        }

        composable(route = ScreenEnum.ChangePassword.name) {
            val viewModel: ChangePasswordViewModel = viewModel()
            NewPasswordComposable(navController,viewModel)
        }
        composable(route = ScreenEnum.VerifyScreen.name) {
            VerifyScreen(navController)
        }
        composable(route = ScreenEnum.VerifyResendScreen.name) {
            VerifyResendScreen(navController)
        }
        composable(route = ScreenEnum.SearchAddressScreen.name) {

            SearchAddress(navController,ShipmentViewModel)
        }
        composable(route = ScreenEnum.SearchItemScreen.name) {

            SearchItem(navController,ShipmentViewModel)
        }
        composable(route = ScreenEnum.SearchPackageScreen.name) {

            SearchPackage(navController,ShipmentViewModel)
        }
        composable(route = ScreenEnum.AddItemScreen.name) {

            AddItems(navController, ShipmentViewModel)
        }
        composable(route = ScreenEnum.AddPackageScreen.name) {

            AddPackageScreen(navController, ShipmentViewModel)
        }
        composable(route = ScreenEnum.PrintLabelScreen.name) {

            PrintAndMangerOrder(navController)
        }
        composable(route = ScreenEnum.AddAddressScreen.name) {

            AddAddressScreen(navController, ShipmentViewModel)
        }

    }

}


fun NavController.popTo(destination: String, isIncluded: Boolean = true) {
    popBackStack(destination, inclusive = isIncluded)
}







