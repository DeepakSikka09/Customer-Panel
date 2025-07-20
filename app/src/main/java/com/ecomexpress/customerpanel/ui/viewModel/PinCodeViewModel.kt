package com.ecomexpress.customerpanel.ui.viewModel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/*
* _searchText is a private property inside the PinCodeViewModel class, which is a type of MutableStateFlow.
* A MutableStateFlow is a container that holds a single value and allows you to read and update that value.
* In this case, _searchText holds a String value representing the search text entered by the user.
* searchText is a public property in the PinCodeViewModel class, which is a type of StateFlow.
* A StateFlow is similar to MutableStateFlow, but it provides read-only access to the data it contains.
* It exposes a StateFlow<String> representing the current search text. Other parts of the app can only read
* this value but cannot modify it directly.

* fun setSearchText(newText: String):
* This is a function defined in the PinCodeViewModel class. It is responsible for updating the value of _searchText.
* When this function is called with a new String, it sets _searchText.value to the provided newText, effectively
* updating the search text*/



class PinCodeViewModel : ViewModel() {
    // Create a MutableStateFlow for the searchText
    private val _searchText = MutableStateFlow("")

    // Convert searchText to read-only Flow
    val searchText: StateFlow<String> get() = _searchText

    // Function to update the searchText value
    fun setSearchText(newText: String) {
        _searchText.value = newText
    }

    // Rest of your ViewModel code...
}
