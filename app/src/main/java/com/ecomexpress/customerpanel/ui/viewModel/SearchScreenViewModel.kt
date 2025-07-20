package com.ecomexpress.customerpanel.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchScreenViewModel : ViewModel(){

    private val _searchText = MutableStateFlow("")

    val searchText: StateFlow<String> get() = _searchText

    fun setSearchText(newText: String) {
        _searchText.value = newText
    }
}