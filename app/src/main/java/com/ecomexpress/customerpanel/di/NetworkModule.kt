package com.ecomexpress.customerpanel.di

import android.content.Context
import com.ecomexpress.customerpanel.BuildConfig.BASE_URL
import com.ecomexpress.customerpanel.data.local.datastore.PreferenceDataStoreHelper
import com.ecomexpress.customerpanel.data.remote.ApiService
import com.ecomexpress.customerpanel.utils.interceptor.CustomHttpLogger
import com.ecomexpress.customerpanel.utils.interceptor.ErrorInterceptor
import com.ecomexpress.customerpanel.utils.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideApplicationContext(@ApplicationContext application: Context): Context {
        return application
    }

    @Provides
    fun provideDataStoreHelper(context: Context): PreferenceDataStoreHelper {
        return PreferenceDataStoreHelper(context)
    }

    @Singleton
    @Provides
    fun provideRetrofitAPI(context: Context, preferenceDataStoreHelper: PreferenceDataStoreHelper): ApiService {
        val okHttpClient = OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor(preferenceDataStoreHelper))
            .addInterceptor(ErrorInterceptor())
            .addInterceptor(HttpLoggingInterceptor(CustomHttpLogger()).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
            .create(ApiService::class.java)
    }

}