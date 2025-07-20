package com.ecomexpress.customerpanel.data.repository

import com.ecomexpress.customerpanel.data.remote.ApiService
import com.ecomexpress.customerpanel.domain.repository.CustomerPanelRepository
import javax.inject.Inject


class CustomerPanelRepositoryImpl @Inject constructor(private val apiService: ApiService): CustomerPanelRepository {
/**
    override suspend fun getUsers(): CustomerPanelRepository = apiService.getUsers()
 **/
}