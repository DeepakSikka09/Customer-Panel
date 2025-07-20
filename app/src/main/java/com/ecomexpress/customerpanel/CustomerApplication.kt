package com.ecomexpress.customerpanel

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}