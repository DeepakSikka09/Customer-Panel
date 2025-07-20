package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchAddressViewModel:ViewModel(){
    private val _searchText = MutableStateFlow("")

    // Convert searchText to read-only Flow
    val searchText: StateFlow<String> get() = _searchText

    // Function to update the searchText value
    fun setSearchText(newText: String) {
        _searchText.value = newText
    }
}