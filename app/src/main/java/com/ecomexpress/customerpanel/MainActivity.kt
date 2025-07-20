package com.ecomexpress.customerpanel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ecomexpress.customerpanel.components.PermissionHandler
import com.ecomexpress.customerpanel.navigation.SetupNavGraph
import com.ecomexpress.customerpanel.ui.theme.CustomerPanelTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomerPanelTheme {
                // Set up the navigation and content using the main @Composable function
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        val systemUiController = rememberSystemUiController()
        val permissionsToRequest = listOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.RECORD_AUDIO
        )

        // Call the PermissionHandler composable to handle permissions
        PermissionHandler(permissionsToRequest)

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }


        // Customize the status bar color
        CustomizeStatusBarColor(systemUiController)
    }

    @Composable
    fun CustomizeStatusBarColor(systemUiController: SystemUiController) {
        val statusBarColor = Color(0xFFF6F8FF)
        SideEffect {
            systemUiController.setStatusBarColor(statusBarColor)
        }
    }
}


