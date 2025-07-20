package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RechargeWalletViewModel : ViewModel() {
    // Create a MutableStateFlow for the searchText
    private val _rechargeText = MutableStateFlow("")

    // Convert searchText to read-only Flow
    val rechargeText: StateFlow<String> get() = _rechargeText

    // Function to update the searchText value
    fun setRechargeText(newText: String) {
        _rechargeText.value = newText
    }

    // Rest of your ViewModel code...
}