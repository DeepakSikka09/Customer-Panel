package com.ecomexpress.customerpanel.components

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat

/*
* The PermissionHandler composable checks if each permission needs to be requested using the
  ActivityCompat.shouldShowRequestPermissionRationale function and filters out the ones that need
  to be requested now.*/

/*The purpose of shouldShowRequestPermissionRationale is to help you determine whether you should show a rationale
  or explanation to the user when requesting a particular permission. This is typically used when the user has
  denied the permission previously, and you want to provide context or explain why the permission is needed before
  requesting it again.*/

/* using the filter function, you extract the permissions that need to be requested.*/

@Composable
fun PermissionHandler(permissions: List<String>) {
    val context = LocalContext.current

    // Request permissions using a rememberLauncherForActivityResult

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissionResults ->
            // Process the permission results if needed
            for ((permission, isGranted) in permissionResults) {
                // Handle the results if required
            }
        }
    )

    LaunchedEffect(permissions) {
        val permissionsToRequestNow = permissions.filter { permission ->
            !ActivityCompat.shouldShowRequestPermissionRationale(
                context as Activity,
                permission
            )
        }

        if (permissionsToRequestNow.isNotEmpty()) {
            requestPermissionLauncher.launch(permissionsToRequestNow.toTypedArray())
        }
    }
}