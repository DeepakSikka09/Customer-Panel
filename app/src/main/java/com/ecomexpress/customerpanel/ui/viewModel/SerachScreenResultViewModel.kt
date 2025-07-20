package com.ecomexpress.customerpanel.ui.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SerachScreenResultViewModel : ViewModel(){


    private val _showDialog  = MutableStateFlow(false)

    val showDialog: StateFlow<Boolean> get() = _showDialog


    fun dialogStatus(showDialog: Boolean) {
        _showDialog.value = showDialog
    }


}