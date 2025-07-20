package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LogInScreenViewModel  : ViewModel(){

    // Create MutableStateFlow for username and password
    private val _username = MutableStateFlow("")
    private val _password  = MutableStateFlow("")


    // Expose username and password as read-only StateFlow
    val username: StateFlow<String> get() = _username
    val password: StateFlow<String> get() = _password

    // Functions to update username and password values
    fun setUsername(newUsername: String) {
        _username.value = newUsername
    }

    fun setPassword(newPassword : String){
        _password.value = newPassword
    }

}