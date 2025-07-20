package com.ecomexpress.customerpanel.di

import com.ecomexpress.customerpanel.data.remote.ApiService
import com.ecomexpress.customerpanel.data.repository.CustomerPanelRepositoryImpl
import com.ecomexpress.customerpanel.domain.repository.CustomerPanelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(apiService: ApiService): CustomerPanelRepository =
        CustomerPanelRepositoryImpl(apiService)
}