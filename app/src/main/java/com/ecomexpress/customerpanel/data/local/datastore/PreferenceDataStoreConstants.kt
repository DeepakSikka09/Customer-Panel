package com.ecomexpress.customerpanel.data.local.datastore

import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceDataStoreConstants {
    val SHIPPER_CODE = longPreferencesKey("SHIPPER_CODE")
    val USERNAME = stringPreferencesKey("USERNAME")
    val EMPLOYEE_CODE = longPreferencesKey("EMPLOYEE_CODE")
    val TOKEN = stringPreferencesKey("TOKEN")
    // val IS_MINOR_KEY = booleanPreferencesKey("IS_MINOR_KEY")
    // val AGE_KEY = intPreferencesKey("AGE_KEY")

}