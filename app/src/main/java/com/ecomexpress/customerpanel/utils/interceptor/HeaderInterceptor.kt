package com.ecomexpress.customerpanel.utils.interceptor

import androidx.datastore.preferences.core.Preferences
import com.ecomexpress.customerpanel.data.local.datastore.PreferenceDataStoreConstants.TOKEN
import com.ecomexpress.customerpanel.data.local.datastore.PreferenceDataStoreHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val preferenceDataStoreHelper: PreferenceDataStoreHelper): Interceptor {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        val originalRequest: Request = chain.request()
        val modifiedRequest: Request = originalRequest.newBuilder()
            .header("token", "Bearer " + getToken(TOKEN, "").await())
            .header("App_ver", "")
            .build()
        chain.proceed(modifiedRequest)

    }

    private fun getToken(key: Preferences.Key<String>, defaultValue: String) = coroutineScope.async {
        preferenceDataStoreHelper.getData(key, defaultValue).first().toString()
    }
}
